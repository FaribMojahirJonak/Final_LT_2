package dev.rest;

import dev.domain.Student;
import dev.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class StudentRestController {

    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/users")
    public List<Student> getAllStudents() throws SQLException {
        return studentService.getAllStudents();
    }

    @GetMapping("/users/{id}")
    public Student get(@PathVariable("id") Integer id) throws SQLException {
        return studentService.get(id);
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") Integer id) throws SQLException {
        studentService.delete(id);
        return "Successful";
    }

    @PostMapping("/users")
    public String create(@RequestBody Student student) throws SQLException {
        studentService.create(student);
        return "successful";
    }

    @PutMapping("/users")
    public String update(@PathVariable("id") Integer id, @RequestBody Student student) throws SQLException {
        student.setId(id);
        studentService.update(student);
        return "Successfully updated";
    }

    @GetMapping("/users/count")
    public int count() throws SQLException {

        return studentService.count();
    }
}