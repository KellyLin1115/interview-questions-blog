:palm_tree: [Interview Questions](https://kellylin1115.github.io/interview-questions-blog/)

# Garbage Collection Interview Questions

## 1.  What is Garbage Collection?
Garbage collection is a process of reclaiming the unused runtime objects. It is performed for memory management.

## 2. How is garbage collection controlled?
Garbage collection is managed by JVM. It is performed when there is not enough space in the memory and memory is running low. We can externally call the System.gc() for the garbage collection. However, it depends upon the JVM whether to perform it or not.

## 3. What is the purpose of the finalize() method?
The finalize() method is invoked just before the object is garbage collected. It is used to perform **cleanup** processing. The Garbage collector of **JVM** collects **only** those objects that are **created by new keyword**. So if you have created an object without new, you can use the finalize method to perform cleanup processing (destroying remaining objects). The cleanup processing is the process to free up all the resources, network which was previously used and no longer needed. Here, we must note that neither finalization nor garbage collection is **guaranteed**.

## 4. Can an unreferenced object be referenced again?
Yes, use finalize() method

## 5. What is the purpose of the Runtime class?
Java Runtime class is used to interact with a java runtime environment. Java Runtime class provides methods to execute a process, invoke GC, get total and free memory, etc. There is only one instance of java.lang.Runtime class is available for one java application. The Runtime.getRuntime() method returns the singleton instance of Runtime class.

## 6. How will you invoke any external process in Java?
By Runtime.getRuntime().exec(?) method. Consider the following example.

    public class Runtime1{  
     public static void main(String args[])throws Exception{  
      Runtime.getRuntime().exec("notepad");//will open a new notepad  
     }  
    }  
    
