
:palm_tree: [Interview Questions](https://kellylin1115.github.io/interview-questions-blog/)

# Java Multithreading Interview Questions

## [Question List](https://www.javatpoint.com/java-multithreading-interview-questions)

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

There are several ways to **create a Future** to describe a task:
* The **submit** methods in ExecutorService all **return a Future**, so that you can **submit a Runnable or a Callable** to an executor and **get back a Future** that can be used to retrieve the result or cancel the task. 
* You can also **explicitly instantiate a FutureTask** for a given Runnable or Callable. (Because FutureTask implements Runnable, it can be submitted to an Executor for execution or executed directly by calling its run method.)
* As of Java 6, ExecutorService implementations can override **newTaskFor**
  in AbstractExecutorService to control instantiation of the Future
  corresponding to a submitted Callable or Runnable. The default
  implementation just creates a new FutureTask as below
  
    Default Implementation of newTaskFor in ThreadPoolExecutor.
    
      protected <T> RunnableFuture<T> newTaskFor(Callable<T> task) {
        return new FutureTask<T>(task);
      }
      
## CountDownLatch
CountDownLatch allows **one or more threads** to **wait** for **a set of events** to occur. 
The latch state consists of a **counter** initialized to a positive number, representing the number of events to wait for. 
The **countDown** method **decrements the counter**, indicating that an event has occurred, 
and the **await** methods wait for the counter to **reach zero**, which happens when all the events have occurred. 
If the counter is nonzero on entry, await blocks until the counter reaches zero, the waiting thread is interrupted, or the wait times out.

**TestHarness** illustrates two common uses for latches. 

TestHarness
creates a number of threads that run a given task concurrently. 
It uses two latches, a "**starting gate**" and an "**ending gate**". 
The
starting gate is initialized with a count of one; 
the ending gate is
initialized with a count equal to the number of worker threads. 
The
first thing each worker thread does is wait on the starting gate; this
ensures that none of them starts working until they all are ready to
start. The last thing each does is count down on the ending gate; this
allows the master thread to wait efficiently until the last of the
worker threads has finished, so it can calculate the elapsed time.
                     
:pencil:[TestHarness.java](../../../../java/com/kellylin1115/interview/java/multithreading/TestHarness.java)

## CyclicBarrier
 **Latches** are** single-use** objects; once a latch enters the terminal state, it cannot be reset.

 **Latches** are for waiting for events; **barriers** are for waiting for other threads. 

CyclicBarrier allows a **fixed number of parties** to rendezvous **repeatedly** at a barrier point and is useful in parallel iterative algorithms that break down a problem into a fixed number of independent subproblems. Threads call **await** when they reach the **barrier point**, and await blocks until **all the threads have reached** the barrier point. If all threads meet at the barrier point, the barrier has been successfully passed, in which case all threads are released and the barrier is **reset** so it can be used again. If a call to await times out or a thread blocked in await is interrupted, then the barrier is considered broken and all outstanding calls to await terminate with **BrokenBarrierException**. If the barrier is successfully passed, await returns a unique arrival index for each thread, which can be used to "elect" a leader that takes some special action in the next iteration. CyclicBarrier also lets you pass a **barrier action** to the constructor; this is a Runnable that is executed (in one of the subtask threads) when the barrier is successfully passed but before the blocked threads are released.

**CellularAutomata** demonstrates using a barrier to compute a cellular automata simulation.
When parallelizing a simulation, it is generally impractical to assign a separate thread to each element (in the case of Life, a cell); this would require too many threads, and the overhead of coordinating them would dwarf the computation. Instead, it makes sense to partition the problem into a number of subparts, let each thread solve a subpart, and then merge the results.

:pencil:[CyclicBarrierTest.java](../../../../java/com/kellylin1115/interview/java/multithreading/CyclicBarrierTest.java)

## Semaphore
Counting semaphores are used to control the number of activities that can access a certain resource or perform a given action at the same time. 
Counting semaphores can be used to implement resource pools or to impose a bound on a collection.

A **Semaphore** manages a set of virtual permits: 

* the initial number of **permits** is passed to the Semaphore **constructor**. 
* Activities can **acquire** permits (as long as some remain) and **release** permits when they are done with them. 
* If **no permit** is available, acquire **blocks** until one is released(or until interrupted or the operation times out). 

You can use a **Semaphore** to **turn** any collection into a **blocking bounded collection**, as illustrated by **BoundedHashSet**.

The semaphore is initialized to the desired maximum size of the collection. The add operation acquires a permit before adding the item into the underlying collection. If the underlying add operation does not actually add anything, it releases the permit immediately. Similarly, a successful remove operation releases a permit, enabling more elements to be added. The underlying Set implementation knows nothing about the bound;

:pencil:[BoundedHashSet.java](../../../../java/com/kellylin1115/interview/java/multithreading/BoundedHashSet.java)

## Thread Factory
Whenever a thread pool needs to create a thread, it does so through a **thread factory**
    
    public interface ThreadFactory {
        Thread newThread(Runnable r);
    }
    
The **default** thread factory creates a new, nondaemon thread with no special configuration. 
Specifying a **thread factory** allows you to **customize** the configuration of **pool threads**. 
ThreadFactory has a single method, newThread, that is called whenever a thread pool needs to create a new thread.

There are a number of **reasons** to use a **custom thread factory**. 
* You might want to specify an UncaughtExceptionHandler for pool threads, or instantiate an instance of a custom Thread class, such as one that performs debug logging. 
* You might want to modify the priority (generally not a very good idea; see Section 10.3.1) or set the daemon status (again, not all that good an idea; see Section 7.4.2) of pool threads. 
* Or maybe you just want to give pool threads more meaningful names to simplify interpreting thread dumps and error logs.


**MyThreadFactory** illustrates a custom thread factory. It instantiates a new MyAppThread, passing a pool􏰁 specific name to the constructor so that threads from each pool can be distinguished in thread dumps and error logs.

:pencil:[MyThreadFactory.java](../../../../java/com/kellylin1115/interview/java/multithreading/MyThreadFactory.java)
   
**MyAppThread**:
* lets you provide a thread name, 
* sets a custom UncaughtException-Handler that writes a message to a Logger, 
* maintains statistics on how many threads have been created and destroyed, 
* and optionally writes a debug message to the log when a thread is created or terminates.
    
:pencil:[MyAppThread.java](../../../../java/com/kellylin1115/interview/java/multithreading/MyAppThread.java)

If your application takes advantage of security policies to grant permissions to particular codebases, you may want to use the **privilegedThreadFactory** factory method in Executors to construct your thread factory. It creates pool threads that have the same permissions, AccessControlContext, and contextClassLoader as the **thread creating the privilegedThreadFactory**. Otherwise, threads created by the thread pool inherit permissions from whatever client happens to be calling execute or submit at the time a new thread is needed, which could cause confusing security related exceptions.

