package storage;

import model.Student;

import java.util.ArrayList;

public interface Storage{
    static final String FILE_TXT = "students.txt";
    static final String FILE_JSON = "students.json";
    void save(ArrayList<Student> students);
    ArrayList<Student> load();
        }