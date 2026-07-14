package app.controller;

import app.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import app.service.StdMng;

import java.util.ArrayList;

@RestController
public class StudentController {

    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        StdMng obj = new StdMng();
        return obj.getList();
    }
}