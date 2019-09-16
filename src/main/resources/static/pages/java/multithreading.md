
:palm_tree: [Interview Questions](https://kellylin1115.github.io/interview-questions-blog/)

# Java Multithreading Interview Questions

## Question List
https://www.javatpoint.com/java-multithreading-interview-questions

## Avoiding Deadlocks
* A program that never acquires more than **one lock** at a time cannot experience lock􏰁ordering deadlock. Of course, this is not always practical, but if you can get away with it, it's a lot less work. 
* If you must acquire multiple locks, **lock ordering** must be a part of your design: try to minimize the number of potential locking interactions, and follow and document a lock􏰁ordering protocol for locks that may be acquired together.
* Another technique for detecting and recovering from deadlocks is to use the **timed tryLock** feature of the explicit Lock classes instead of intrinsic locking. Where intrinsic locks wait forever if they cannot acquire the lock, explicit locks let you specify a timeout after which tryLock returns failure. 

## Deadlock Analysis with Thread Dumps
A thread dump includes a stack trace for each running thread, similar to the stack trace that accompanies an exception. Thread dumps also include locking information, such as which locks are held by each thread, in which stack frame they were acquired, and which lock a blocked thread is waiting to acquire.

Before generating a thread dump, the JVM searches the is-waiting-for graph for cycles to find deadlocks. If it finds one, it includes deadlock information identifying which locks and threads are involved, and where in the program the offending lock acquisitions are.

1. Find the process id [PS ID]

    jps -l
2. Execute jcmd [PS ID] Thread.print

    jcmd psid Thread.print
    
    The release of JDK 8 introduced Java Mission Control, Java Flight Recorder, and jcmd utility for diagnosing problems with JVM and Java applications. It is suggested to use the latest utility, **jcmd** instead of the previous **jstack** utility for enhanced diagnostics and reduced performance overhead.
    
## Executor Framework questions
https://www.concretepage.com/interview/java-interview/interview-questions-core-java-executor-framework

## Saturation Policies
When a bounded work queue fills up, the saturation policy comes into play. 
The saturation policy for a ThreadPoolExecutor can be modified by calling setRejectedExecutionHandler.
Several implementations of **RejectedExecutionHandler** are provided, each implementing a different saturation policy: 
**AbortPolicy**, **CallerRunsPolicy**, **DiscardPolicy**, and **DiscardOldestPolicy**.

    ThreadPoolExecutor executor
        = new ThreadPoolExecutor(N_THREADS, N_THREADS,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(CAPACITY));
    executor.setRejectedExecutionHandler(
    new ThreadPoolExecutor.CallerRunsPolicy());

* The **default** policy, **abort**, causes execute to throw the unchecked Rejected-ExecutionException; the caller can catch this exception and implement its own overflow handling as it sees fit. 
* The **discard** policy **silently** discards the newly submitted task
  if it cannot be queued for execution;
* The **discard-oldest** policy discards the task that would otherwise
  be executed next and tries to resubmit the new task.
  
  (If the work queue is a priority queue, this discards the **highest priority** element, so the combination of a discard􏰁oldest saturation policy and a priority queue is not a good one.)
* The **caller-runs** policy implements a form of throttling that neither discards tasks nor throws an exception, but instead tries to **slow down** the flow of new tasks by **pushing** some of the **work back to the caller**. 
  It executes the newly submitted task **not** in a pool thread, but **in the thread that calls** execute. 

  If we modified our WebServer example to use a bounded queue and the caller-runs policy, after all the pool threads were occupied and the work queue filled up the next task would be executed in the **main thread** during the call to execute. Since this would probably take some time, the main thread **cannot submit** any more tasks for at least a little while, giving the worker threads some time to catch up on the backlog. 
  The main thread would also not be calling accept during this time, so incoming requests will **queue up in the TCP layer** instead of in the application. 
  If the overload persisted, eventually the TCP layer would decide it has queued enough connection requests and begin **discarding connection requests** as well. 
  
  As the server becomes overloaded, the overload is gradually pushed outward 􏰁 from the pool threads to the work queue to the application to the TCP layer, and eventually to the client 􏰁 enabling more graceful degradation under load.

##  Customizing ThreadPoolExecutor After Construction
Most of the options passed to the ThreadPoolExecutor constructors can also be **modified after construction** via setters (such as the core thread pool size, maximum thread pool size, keep-alive time, thread factory, and rejected execution handler). 
If the Executor is created through one of the factory methods in Executors (**except** newSingleThreadExecutor), you can cast the result to Thread-PoolExecutor to access the setters as below:
    
    ExecutorService exec = Executors.newCachedThreadPool();
    if (exec instanceof ThreadPoolExecutor)
        ((ThreadPoolExecutor) exec).setCorePoolSize(10);
    else
    throw new AssertionError("Oops, bad assumption");
    
Executors includes a factory method, **unconfigurableExecutorService**, which takes an existing ExecutorService and wraps it with one exposing only the methods of ExecutorService so it **cannot** be further configured. 
Unlike the pooled implementations, newSingleThreadExecutor returns an ExecutorService wrapped in this manner, rather than a raw ThreadPoolExecutor. While a single􏰁threaded executor is actually implemented as a thread pool with one thread, it also promises not to execute tasks concurrently. If some misguided code were to increase the pool size on a single􏰁threaded executor, it would undermine the intended execution semantics.

You can use this technique with your own executors to prevent the execution policy from being modified. If you will be exposing an ExecutorService to code you don't trust not to modify it, you can wrap it with an unconfigurableExecutorService.

## shutdown and shutdownNow
The **shutdown** method initiates a graceful shutdown: **no new** tasks are accepted but **previously submitted tasks** are allowed to complete including those that have not yet begun execution. 

The **shutdownNow** method initiates an abrupt shutdown: it **attempts to cancel** outstanding tasks and does **not** start any tasks that are queued but not begun.

## The lifecycle implied by ExecutorService
ExecutorService has three states: running, shutting down, and terminated

## Result-bearing Tasks: Callable and Future
* Runnable is a fairly limiting abstraction; run **cannot** return a value or throw checked exceptions, although it can have side effects such as writing to a log file or placing a result in a shared data structure.

* Many tasks are effectively deferred computations executing a database query, fetching a resource over the network, or computing a complicated function. For these types of tasks, **Callable** is a better abstraction: it expects that the main entry point, call, will **return a value** and anticipates that it **might throw an exception**.

* Since tasks can take a long time to run, we also want to be able to **cancel** a task. In the Executor framework, tasks that have been submitted but not yet started can always be cancelled, and tasks that have started can sometimes be cancelled if they are responsive to interruption.

  **Future** represents the lifecycle of a task and provides methods to
  test whether the task **has completed** or **been cancelled**,
  **retrieve its result**, and **cancel the task**.
  
  **Future** is that task lifecycle can **only move forwards**, not
  backwards just like the **ExecutorService** lifecycle. Once a task is
  completed, it stays in that state forever.
  
  The behavior of **get** varies depending on the task state (not yet started, running, completed). It returns immediately or throws an Exception if the task has already completed, but if not it blocks until the task completes. If the task completes by throwing an exception, get rethrows it wrapped in an ExecutionException; if it was cancelled, get throws CancellationException. If get throws ExecutionException, the underlying exception can be retrieved with getCause.
  
Runnable, Callable and Future Interfaces:

    public interface Runnable { public abstract void run(); }

    public interface Callable<V> { V call() throws Exception; }
    
    public interface Future<V> {
        boolean cancel(boolean mayInterruptIfRunning);
        boolean isCancelled();
        boolean isDone();
        V get() throws InterruptedException, 
                    ExecutionException,
                       CancellationException;
        V get(long timeout, TimeUnit unit)throws
                       InterruptedException, 
                        ExecutionException,
                        CancellationException, 	
                        TimeoutException;
    }

     