package service;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Student;
import storage.*;

public class StdMng {
    Scanner scn = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();
    Storage storageJSON = new jsonStorage();
    Storage storageTXT = new txtStorage();

    public StdMng() {
        students = storageJSON.load();
        // students = storageTXT.load();
    }

    public void addStd() {
        System.out.printf("\nPlease enter following info:");
        System.out.printf("\nID : ");
        int id = scn.nextInt();
        if (findStd(id) != null) {
            System.out.println("ID already exists");
        }
        System.out.printf("\nName : ");
        String name = scn.next();
        System.out.printf("\nAge : ");
        int age = scn.nextInt();
        Student std = new Student(id, name, age);
        students.add(std);
    }

    public void dltStd() {
        System.out.printf("\nPlease enter ID: ");
        Student s = findStd(scn.nextInt());
        if (s != null) {
            students.remove(s);
            System.out.printf("\nDeleted!");
        } else {
            System.out.printf("\nNo ID found");
        }
    }


    public void edtStd() {
        System.out.printf("\nPlease enter ID: ");
        Student s = findStd(scn.nextInt());
        if (s != null) {
            System.out.printf("\nPlease enter new name:");
            s.setName(scn.next());
            System.out.printf("\nPlease enter new age:");
            s.setAge(scn.nextInt());
            System.out.printf("\nEdited!");
        } else {
            System.out.printf("\nNo ID found");
        }
    }


    public void srchStd() {
        System.out.printf("\nPlease enter ID: ");
        Student s = findStd(scn.nextInt());
        if (s != null) {
            s.display();
        } else {
            System.out.printf("\nNo ID found");
        }
    }

    private Student findStd(int id) {
        for (Student s : students) {
            if (s.getID() == id) {
                return s;
            }
        }
        return null;
    }

    private void DisplayAll() {
        if (students.isEmpty()) {
            System.out.println("No Students!");
            return;
        }
        for (Student s : students) {
            s.display();
        }
    }

    public void exit() {
        storageJSON.save(students);
        storageTXT.save(students);
    }
}

