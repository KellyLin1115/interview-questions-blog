:palm_tree: [Interview Questions](https://kellylin1115.github.io/interview-questions-blog/)

# Exception Java Interview Questions

## 1. How many types of exception can occur in a Java program?
There are mainly two types of exceptions: checked and unchecked. Here, an error is considered as the unchecked exception. 
According to Oracle, there are three types of exceptions:

* Checked Exception: Checked exceptions are the one which are checked at **compile-time**. For example, SQLException, ClassNotFoundException, etc.

* Unchecked Exception: Unchecked exceptions are the one which are handled at **runtime** because they can not be checked at compile-time. For example, ArithmaticException, NullPointerException, ArrayIndexOutOfBoundsException, etc.

* Error: Error cause the program to exit since they are **not recoverable**. For Example, OutOfMemoryError, AssertionError, etc.

## 2. Hierarchy of Java Exception classes
The java.lang.Throwable class is the root class of Java Exception hierarchy which is inherited by two subclasses: Exception and Error. A hierarchy of Java Exception classes are given below:

![](../../images/java/throwable.png) 

## 3. Is there any case when finally will not be executed?
Finally block will not be executed if program exits(either by calling System.exit() or by causing a fatal error that causes the process to abort)

## 4. ExceptionHandling with Method Overriding in Java
There are many rules if we talk about method overriding with exception handling. The Rules are as follows:
* If the **superclass** method **does not** declare an exception, **subclass** overridden method **cannot** declare the **checked** exception but it **can declare unchecked exception**.
* If the **superclass** method **declares** an exception, **subclass** overridden method **can** declare **same**, **subclass exception** or **no exception** but **cannot** declare **parent exception**.

[Examples](https://www.javatpoint.com/exception-handling-with-method-overriding)

## 5. 
