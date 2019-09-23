:palm_tree: [Interview Questions](https://kellylin1115.github.io/interview-questions-blog/)

# Java Interview Basic

## 1. Explain JDK, JRE and JVM?

JDK | JRE | JVM
------ | ------ | ------
It stands for Java Development Kit | It stands for Java Runtime Environment | It stands for Java Virtual Machine
It is the tool necessary to compile, document and package Java programs | JRE refers to a runtime environment in which Java bytecode can be executed | It is an abstract machine. It is a specification that provides a run-time environment in which Java bytecode can be executed
It contains JRE + development tools | It’s an implementation of the JVM which physically exists | JVM follows three notations: Specification, Implementation, and Runtime Instance

## 2. Explain public static void main(String[] args) in Java.
main() in Java is the entry point for any Java program. It is always written as **public static void main(String[] args)**.

* **public**: Public is an access modifier, which is used to specify who can access this method. Public means that this Method will be accessible by any Class.
* **static**: It is a keyword in java which identifies it is class-based. main() is made static in Java so that it can be accessed without creating the instance of a Class. In case, main is not made static then the compiler will throw an error as main() is called by the JVM before any objects are made and only static methods can be directly invoked via the class. 
* **void**: It is the return type of the method. Void defines the method which will not return any value.
* **main**: It is the name of the method which is searched by JVM as a starting point for an application with a particular signature only. It is the method where the main execution occurs.
* **String[] args**: It is the parameter passed to the main method.


## 3.  Why Java is platform independent?
Java is called platform independent because of its byte codes which can run on any system irrespective of its underlying operating system.

## 4.  Why Java is not 100% Object-oriented?
Java is not 100% Object-oriented because it makes use of eight primitive data types such as boolean, byte, char, int, float, double, long, short which are not objects.

## 5. What are wrapper classes in Java?
Wrapper classes convert the Java primitives into the reference types (objects). Every primitive data type has a wrapper class dedicated to it. 

## 6. What are constructors in Java?
In Java, constructor refers to a block of code which is used to initialize an object. It must have the same name as that of the class. Also, it has no return type and it is automatically called when an object is created.

There are two types of constructors:

**Default Constructor**: In Java, a default constructor is the one which does not take any inputs. In other words, default constructors are the no argument constructors which will be created by default in case no other constructor is defined by the user. Its main purpose is to initialize the instance variables with the default values. Also, it is majorly used for object creation. 

**Parameterized Constructor**: The parameterized constructor in Java, is the constructor which is capable of initializing the instance variables with the provided values. In other words, the constructors which take the arguments are called parameterized constructors.

## 7. What is singleton class in Java and how can we make a class singleton?
Singleton class is a class whose only one instance can be created at any given time, in one JVM. A class can be made singleton by making its constructor private.

## 8. What is the difference between Array list and vector in Java?

ArrayList |	Vector
---------- | ----------
Array List is not synchronized.	| Vector is synchronized.
Array List is fast as it’s non-synchronized.	| Vector is slow as it is thread safe.
If an element is inserted into the Array List, it increases its Array size by 50%.	| Vector defaults to doubling size of its array.
Array List does not define the increment size.	| Vector defines the increment size.
Array List can only use Iterator for traversing an Array List.	| Vector can use both Enumeration and Iterator for traversing.

## 9. What is the difference between equals() and == in Java?
Equals() method is defined in Object class in Java and used for checking equality of two objects defined by business logic.

“==” or equality operator in Java is a binary operator provided by Java programming language and used to compare primitives and objects. public boolean equals(Object o) is the method provided by the Object class. The default implementation uses == operator to compare two objects. For example: method can be overridden like String class. equals() method is used to compare the values of two objects.

## 10. What are the differences between Heap and Stack Memory in Java?

Feature	| Stack	| Heap
-------- | ------ | ------
**Memory**	| Stack memory is used only by one thread of execution.	| Heap memory is used by all the parts of the application.
**Access** | Stack memory can’t be accessed by other threads.	| Objects stored in the heap are globally accessible.
**Memory Management**	| Follows LIFO manner to free memory. |	Memory management is based on the generation associated with each object.
**Lifetime** | Exists until the end of execution of the thread.	| Heap memory lives from the start till the end of application execution.
**Usage**	| Stack memory only contains local primitive and reference variables to objects in heap space.	| Whenever an object is created, it’s always stored in the Heap space.

## 11. What is a package in Java? List down various advantages of packages.
Packages in Java, are the collection of related classes and interfaces which are bundled together. By using packages, developers can easily modularize the code and optimize its reuse. Also, the code within the packages can be imported by other classes and reused. Below I have listed down a few of its advantages:

* Packages help in avoiding name clashes
* They provide easier access control on the code
* Packages can also contain hidden classes which are not visible to the outer classes and only used within the package
* Creates a proper hierarchical structure which makes it easier to locate the related classes

## 12. Why pointers are not used in Java?
Java doesn’t use pointers because they are unsafe and increases the complexity of the program. Since, Java is known for its simplicity of code, adding the concept of pointers will be contradicting. Moreover, since JVM is responsible for implicit memory allocation, thus in order to avoid direct access to memory by the user,  pointers are discouraged in Java.

## 13. What is JIT compiler in Java?
JIT stands for Just-In-Time compiler in Java. It is a program that helps in converting the Java bytecode into instructions that are sent directly to the processor. By default, the JIT compiler is enabled in Java and is activated whenever a Java method is invoked. The JIT compiler then compiles the bytecode of the invoked method into native machine code, compiling it “just in time” to execute. Once the method has been compiled, the JVM summons the compiled code of that method directly rather than interpreting it. This is why it is often responsible for the performance optimization of Java applications at the run time.

## 14. What are access modifiers in Java?
In Java, access modifiers are special keywords which are used to restrict the access of a class, constructor, data member and method in another class. Java supports four types of access modifiers:

1. Private
2. Default
3. Protected
4. Public

**Modifier** | **Private** | **Default** | **Protected** |	**Public**
------------ | ----------- | ----------- | ------------- | -----------
Same class |	YES |	YES |	YES |	YES
Same Package subclass	| NO	| YES	| YES |	YES
Same Package non-subclass |	NO	| YES | YES | YES
Different package subclass | NO |	NO | YES | YES
Different package non-subclass | NO |	NO | NO |	YES

## 15. What is an object in Java and how is it created?
An object is a real-world entity that has a state and behavior. An object has three characteristics:

1. State
2. Behavior
3. Identity

An object is created using the ‘new’ keyword. For example:

ClassName obj = new ClassName();

## 16. What is Object Oriented Programming?
Object-oriented programming or popularly known as OOPs is a programming model or approach where the programs are organized around objects rather than logic and functions. In other words, OOP mainly focuses on the objects that are required to be manipulated instead of logic. This approach is ideal for the programs large and complex codes and needs to be actively updated or maintained.

## 17.  What are the main concepts of OOPs in Java?
Object-Oriented Programming or OOPs is a programming style that is associated with concepts like:
1. Inheritance: Inheritance is a process where one class acquires the properties of another.
2. Encapsulation: Encapsulation in Java is a mechanism of wrapping up the data and code together as a single unit.
3. Abstraction: Abstraction is the methodology of hiding the implementation details from the user and only providing the functionality to the users. 
4. Polymorphism: Polymorphism is the ability of a variable, function or object to take multiple forms.

## 18. What is the difference between a local variable and an instance variable?
In Java, a local variable is typically used inside a method, constructor, or a block and has only local scope. Thus, this variable can be used only within the scope of a block. The best benefit of having a local variable is that other methods in the class won’t be even aware of that variable.

An instance variable is bounded to its object itself. These variables are declared within a class, but outside a method. Every object of that class will create it’s own copy of the variable while using it. Thus, any changes made to the variable won’t reflect in any other instances of that class and will be bound to that particular instance only.

## 19. Differentiate between the constructors and methods in Java?

Methods |	Constructors
------- | ------------
Used to represent the behavior of an object	| Used to initialize the state of an object
Must have a return type	| Do not have any return type
Needs to be invoked explicitly	| Is invoked implicitly
No default method is provided by the compiler	| A default constructor is provided by the compiler if the class has none
Method name may or may not be same as class name	| Constructor name must always be the same as the class name

## 20. What is final keyword in Java?
final is a special keyword in Java that is used as a non-access modifier. A final variable can be used in different contexts such as:

**final variable**:
When the final keyword is used with a variable then its value can’t be changed once assigned. In case the no value has been assigned to the final variable then using only the class constructor a value can be assigned to it.

**final method**:
When a method is declared final then it can’t be overridden by the inheriting class.

**final class**:
When a class is declared as final in Java, it can’t be extended by any subclass class but it can extend other class.

## 21. What is the difference between break and continue statements?

break |	continue
------ | --------
Can be used in switch and loop (for, while, do while) statements	| Can be only used with loop statements
It causes the switch or loop statements to terminate the moment it is executed	| It doesn’t terminate the loop but causes the loop to jump to the next iteration

## 22. What is the difference between this() and super() in Java?
In Java, super() and this(), both are special keywords that are used to call the constructor. 

this()	| super()
------- | -------
this() represents the current instance of a class	| super() represents the current instance of a parent class
Used to call the default constructor of the same class and must be the first statement in constructor body | Used to call the default constructor of the parent class must be the first statement in constructor body
Used to access methods of the current class	| Used to access methods of the parent class

## 23. What is Java String Pool?
Java String pool refers to a collection of Strings which are stored in heap memory. Whenever a new object is created, String pool first checks whether the object is already present in the pool or not. If it is present, then the same object is returned to the variable else new object will be created in the String pool and the respective reference will be returned.

![](images/String-pool.png)

* String s1 = "Apple";
* String s2 = new String("Apple");
* String s3 = new String("Apple");
* s1 == s3: false
* s2 == s3: false

## 24. What is constructor chaining in Java?
In Java, constructor chaining is the process of calling one constructor from another with respect to the current object. Constructor chaining is possible only through legacy where a subclass constructor is responsible for invoking the superclass’ constructor first. There could be any number of classes in the constructor chain. Constructor chaining can be achieved in two ways:

1. Within the same class using this()
2. From base class using super()

## 25. Difference between String, String Builder, and String Buffer.

Factor |	String | String Builder | String Buffer
------ | ------- | ------------- | -------------
Storage Area |	Constant String Pool|	Heap Area	| Heap Area
Mutability	| Immutable	| Mutable |	Mutable |
Thread Safety |	Yes	| No	| Yes
Performance	| Fast | Fast	| Slow

## 26. What is a classloader in Java?
The **Java ClassLoader** is a subset of JVM (Java Virtual Machine) that is responsible for loading the class files. Whenever a Java program is executed it is first loaded by the classloader. Java provides three built-in classloaders:

1. **Bootstrap ClassLoader**: This is the first classloader which is the superclass of Extension classloader. It loads the rt.jar file which contains all class files of Java Standard Edition like java.lang package classes, java.net package classes, java.util package classes, java.io package classes, java.sql package classes, etc.
2. **Extension ClassLoader**: This is the child classloader of Bootstrap and parent classloader of System classloader. It loads the jar files located inside $JAVA_HOME/jre/lib/ext directory.
3. **System/Application ClassLoader**: This is the child classloader of Extension classloader. It loads the class files from the classpath. By default, the classpath is set to the current directory. You can change the classpath using "-cp" or "-classpath" switch. It is also known as Application classloader.

## 27. Why Java Strings are immutable in nature?
In Java, string objects are immutable in nature which simply means once the String object is created its state cannot be modified. Whenever you try to update the value of that object instead of updating the values of that particular object, Java creates a new string object. Java String objects are immutable as String objects are generally cached in the String pool. Since String literals are usually shared between multiple clients, action from one client might affect the rest. It enhances security, caching, synchronization, and performance of the application. 

## 28. What is the difference between an array and an array list?

Array | ArrayList
----- | --------- 
Cannot contain values of different data types	| Can contain values of different data types.
Size must be defined at the time of declaration	| Size can be dynamically changed
Need to specify the index in order to add data	| No need to specify the index
Arrays are not type parameterized | Arraylists are type parameterized
Arrays can contain primitive data types as well as objects | Arraylists can contain only objects, no primitive data types are allowed

## 29. How many types of memory areas are allocated by JVM?

**Method Area**: Method Area stores per-class structures such as the runtime constant pool, field, method data, and the code for methods.

**Heap**: It is the runtime data area in which the memory is allocated to the objects

**Stack**: Java Stack stores frames. It holds local variables and partial results, and plays a part in method invocation and return. Each thread has a private JVM stack, created at the same time as the thread. A new frame is created each time a method is invoked. A frame is destroyed when its method invocation completes.

**Program Counter Register**: PC (program counter) register contains the address of the Java virtual machine instruction currently being executed.

**Native Method Stack**: It contains all the native methods used in the application.

## 30. What is JIT compiler?
Just-In-Time (JIT) compiler compiles the byte code of that method into native machine code to improve the performance of Java applications at run time. When a method has been compiled, the JVM calls the compiled code of that method directly instead of interpreting it.

![](../../images/java/jvm-interpreter-jit.png) 

**解释器与编译器**：
* 当程序需要迅速启动和执行的时候，解释器可以省去编译的时间， 立即执行。
* 当程序运行后，随着时间的推移， 编译器把越来越多的代码编译成本地代码后， 可以获得更高的执行效率。
* 当程序运行环境中内存资源限制较大， 可以使用解释执行节约内存， 反之可以使用编译执行提升效率。
* 解释器还可以作为编译器激进优化时的一个"逃生门"， 让编译器根据概率选择一些大多数都能提升运行速度的优化手段， 当激进优化的假设不成立，如加载了新类后类型继承结构出现变化，出现"罕见陷阱"（Uncommon Trap）时可以通过逆优化（Deoptimization）退回到解释状态继续执行。

![](../../images/java/compiler-types-1.png) 

![](../../images/java/compiler-types-2.png) 

## 31. Can we make the abstract methods static in Java?
In Java, if we make the abstract methods static, It will become the part of the class, and we can directly call it which is unnecessary. Calling an undefined method is completely useless therefore it is not allowed.

## 32. Can we declare the static variables and methods in an abstract class?
Yes, we can declare static variables and methods in an abstract method. As we know that there is no requirement to make the object to access the static context, therefore, we can access the static context declared inside the abstract class by using the name of the abstract class.

## 33. Can we assign the reference to this variable?
No, this cannot be assigned to any value because it always points to the current class object and this is the **final** reference in Java. However, if we try to do so, the compiler error will be shown.

## 34.  What is aggregation?
Aggregation can be defined as the relationship between two classes where the aggregate class **contains a reference** to the class it owns. Aggregation is best described as a **has-a** relationship. 

## 35. What is composition?
Holding the reference of a class within some other class is known as composition. When an object contains the other object, if the contained object **cannot** exist without the existence of container object, then it is called composition. In other words, we can say that composition is the **particular case of aggregation** which represents a **stronger** relationship between two objects. 

## 36. What is the difference between aggregation and composition?
Aggregation represents the weak relationship whereas composition represents the strong relationship. For example, the bike has an indicator (aggregation), but the bike has an engine (composition).

## 37. Can you use this() and super() both in a constructor?
No, because this() and super() must be the **first** statement in the class constructor.

## 38. Can we override the private methods?
No, we cannot override the private methods because the scope of private methods is limited to the class and we cannot access them outside of the class.

## 39. Can we change the scope of the overridden method in the subclass?
Yes, we can change the scope of the overridden method in the subclass. However, we must notice that we **cannot decrease** the accessibility of the method. The following point must be taken care of while changing the accessibility of the method.

* The private can be changed to protected, public, or default.
* The protected can be changed to public or default.
* The default can be changed to public.
* The public will always remain public.

## 40. Can we modify the throws clause of the superclass method while overriding it in the subclass?
Yes, we can modify the throws clause of the superclass method while overriding it in the subclass. However, there are some rules which are to be followed while overriding in case of exception handling.

* If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception, but it can declare the unchecked exception.
* If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception.

## 41. What is the abstract class?
A class that is declared as **abstract** is known as an abstract class. It needs to be extended and its method implemented. It **cannot** be instantiated. It can **have** abstract methods, non-abstract methods, **constructors**, and static methods.

## 42. Can you use abstract and final both with a method?
No, because we need to override the abstract method to provide its implementation, whereas we can't override the final method.

## 43.  What is the interface?
The interface is a blueprint for a class that has **static constants** and **abstract methods**. It can be used to achieve **full abstraction** and **multiple inheritance**. It is a mechanism to achieve abstraction. There can be only abstract methods in the Java interface, not method body. It **cannot be instantiated** just like the abstract class. However, we need to implement it to define its methods. Since Java 8, we can have the default, static, and private methods in an interface.

## 44. Can you declare an interface method static?
No, because methods of an interface are abstract by default, and we can not use static and abstract together.

## 45. Can the Interface be final?
No, because an interface needs to be implemented by the other class and if it is final, it can't be implemented by any class.

