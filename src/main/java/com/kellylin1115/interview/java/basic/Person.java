package com.kellylin1115.interview.java.basic;

import java.io.*;

public class Person implements Externalizable {

    private String name;
    private int age;
    /**
     * 必须有无参数的构造器
     */
    public Person() {
        System.out.println("Constructor with no parameter invoked");
    }
    public Person(String name,int age) {
        System.out.println("Constructor with parameters invoked");
        this.name=name;
        this.age=age;
    }
    @Override
    public String toString() {
        return "name: "+name+" age: "+age;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        this.name=(String)in.readObject();
        this.age= in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = System.getProperty("user.dir") + "/src/main/java/com/kellylin1115/interview/java/basic/output.txt";

        FileOutputStream out = new FileOutputStream(path);
        ObjectOutputStream bos = new ObjectOutputStream(out);
        Person person = new Person("Tony", 8);
        person.writeExternal(bos);
        bos.flush();
        bos.close();
        out.close();

        System.out.println("Output to file");

        FileInputStream in = new FileInputStream(path);
        ObjectInputStream bis = new ObjectInputStream(in);
        Person person1 = new Person();
        person1.readExternal(bis);
        bis.close();
        in.close();

        System.out.println("Restore form file");
        System.out.println(person1);
    }
}