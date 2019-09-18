:palm_tree: [Interview Questions](https://kellylin1115.github.io/interview-questions-blog/)

# OOPS Java Interview Questions

## 1. What is object-oriented Programming
**Object-Oriented Programming** or **OOPs** refers to languages that use **objects** in programming. Object-oriented programming aims to **implement real-world entities** like inheritance, hiding, polymorphism etc in programming. The main aim of OOP is to **bind together** the **data** and the **functions** that operate on them so that no other part of the code can access this data except that function.

## 2. What are main concepts of OOP in Java
There are **four** main OOP concepts in Java:

1. **Polymorphism**: Polymorphism refers to the ability of OOPs programming languages to differentiate between entities with the same name efficiently. This is done by Java with the help of the signature and declaration of these entities.

    Polymorphism in Java are mainly of 2 types:
    * Overloading in Java
    * Overriding in Java

2. **Inheritance**: It is the mechanism in java by which one class is allowed to inherit the features(fields and methods) of another class.

    Important terminology:
    * **Super Class**: The class whose features are inherited is known as superclass(or a base class or a parent class).
    * **Sub Class**: The class that inherits the other class is known as subclass(or a derived class, extended class, or child class). The subclass can add its own fields and methods in addition to the superclass fields and methods.
    * **Reusability**: Inheritance supports the concept of “reusability”, i.e. when we want to create a new class and there is already a class that includes some of the code that we want, we can derive our new class from the existing class. By doing this, we are reusing the fields and methods of the existing class.

    The keyword used for inheritance is **extends**.

3. **Encapsulation**: Encapsulation is defined as the wrapping up of data under a single unit. It is the mechanism that binds together code and the data it manipulates. The data of a class is hidden from any other class and can be accessed only through any member function of own class in which they are declared.

    Encapsulation can be **achieved** by Declaring all the variables in the class as private and writing public methods in the class to set and get the values of variables.

4. **Abstraction**: Abstraction is a process of hiding the implementation details from the user, only the functionality will be provided to the user. In Java, abstraction is achieved using abstract classes and interfaces.
