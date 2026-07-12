package service;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.Student;

public class StdMng {
    Scanner scn = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "students.txt";

    public StdMng(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = br.readLine()) != null){
                readData(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeJSON(){
        ObjectMapper mapper = new ObjectMapper();
        try {
                mapper.writeValue(new File("students.json"), students);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readJSON(){
        ObjectMapper mapper = new ObjectMapper();
        try{
            students.clear();
            students.addAll(mapper.readValue(new File("students.json"), new TypeReference<ArrayList<Student>>() {}));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readData(String data){
        String[] parts = data.split(",");
        Student std = new Student(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]));
        students.add(std);
    }

    public void writeData(){
        try (BufferedWriter br = new BufferedWriter(new FileWriter(FILE_NAME))){
            for(Student s : students){
                String data = (String.valueOf(s.getID())+","+s.getName()+","+String.valueOf(s.getAge()));
                br.write(data);
                br.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();;
        }
    }

    public void addStd(){
        System.out.printf("\nPlease enter following info:");
        System.out.printf("\nID : ");
        int id = scn.nextInt();
        if(findStd(id)!=null){
            System.out.println("ID already exists");
        }
        System.out.printf("\nName : ");
        String name = scn.next();
        System.out.printf("\nAge : ");
        int age = scn.nextInt();
        Student std = new Student(id,name,age);
        students.add(std);
    }

    public void dltStd(){
        System.out.printf("\nPlease enter ID: ");
        Student s = findStd(scn.nextInt());
        if(s!=null) {
            students.remove(s);
            System.out.printf("\nDeleted!");
        }else{
            System.out.printf("\nNo ID found");}
    }


    public void edtStd(){
        System.out.printf("\nPlease enter ID: ");
        Student s = findStd(scn.nextInt());
        if(s!=null) {
            System.out.printf("\nPlease enter new name:");
            s.setName(scn.next());
            System.out.printf("\nPlease enter new age:");
            s.setAge(scn.nextInt());
            System.out.printf("\nEdited!");
        }else{
            System.out.printf("\nNo ID found");}
    }



    public void srchStd(){
        System.out.printf("\nPlease enter ID: ");
        Student s = findStd(scn.nextInt());
        if(s!=null) {
            s.display();
        }else{
            System.out.printf("\nNo ID found");}
    }

    private Student findStd(int id){
        for(Student s : students){
            if(s.getID()==id){
                return s;
            }
        }
        return null;
    }

    private void DisplayAll(){
        if(students.isEmpty()){
            System.out.println("No Students!");
            return;
        }
        for(Student s : students) {
            s.display();
        }
    }
}

