package model;
import java.util.Scanner;

public class Student {
    private int numTotal=0;
    private int id;
    private String name;
    private int age;
    Scanner scn = new Scanner(System.in);

    public Student(int id, String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;
        numTotal++;
    }

    public int getID(){
        return id;
    }

    public String getName(){return name;}

    public int getAge(){return age;}

    public void setName(String name){
        this.name=name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public void display(){
        System.out.printf("ID: %d%nName: %s%nAge: %d%n", id,name,age);
    }
}
