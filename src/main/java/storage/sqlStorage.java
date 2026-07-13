package storage;

import model.Student;
import java.sql.*;


import java.util.ArrayList;

public class sqlStorage implements Storage {

    private Connection con;

    public sqlStorage(){
        String url = "jdbc:sqlite:students.db";
        try{con = DriverManager.getConnection(url);}
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void save(ArrayList<Student> students) {
        for(Student s : students){
            try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO student (id,name,age) VALUES (?,?,?)");
                ps.setInt(1, s.getID());
                ps.setString(2, s.getName());
                ps.setInt(3, s.getAge());
                ps.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        try {
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public ArrayList<Student> load(){
        ArrayList<Student> students = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROMT student");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
                students.add(s);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }
}