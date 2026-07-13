package storage;

import model.Student;

import java.io.*;
import java.util.ArrayList;

public class txtStorage implements Storage{
    @Override
    public void save(ArrayList<Student> students){
        try (BufferedWriter br = new BufferedWriter(new FileWriter(FILE_TXT))){
            for(Student s : students){
                String data = (String.valueOf(s.getID())+","+s.getName()+","+String.valueOf(s.getAge()));
                br.write(data);
                br.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
    @Override
    public ArrayList<Student> load(){
        ArrayList<Student> students = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_TXT))){
            String data;
            while((data = br.readLine()) != null){
                String[] parts = data.split(",");
                Student std = new Student(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]));
                students.add(std);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return students;
    }



}