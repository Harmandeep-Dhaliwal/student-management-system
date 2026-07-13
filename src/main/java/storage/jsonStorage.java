package storage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Student;

import java.io.*;
import java.util.ArrayList;

public class jsonStorage implements Storage{
    @Override
    public void save(ArrayList<Student> students){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(FILE_JSON), students);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public ArrayList<Student> load(){
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Student> students = new ArrayList<>();
        try{
            students.clear();
            students.addAll(mapper.readValue(new File(FILE_JSON), new TypeReference<ArrayList<Student>>() {}));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

}
