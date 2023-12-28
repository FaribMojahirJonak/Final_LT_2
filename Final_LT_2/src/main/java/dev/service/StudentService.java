package dev.service;

import dev.domain.Student;
import dev.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(Student student) throws SQLException {
        student.setName(student.getName().toUpperCase());
        studentRepository.create(student);
    }

    public List<Student> getAllStudents() throws SQLException {
        return studentRepository.getAll();
    }
    public Student get(int id) throws SQLException {
        return studentRepository.get(id);
    }

    public void update(Student student) throws  SQLException {
        studentRepository.update(student);
    }

    public void delete(int id) throws SQLException {
        studentRepository.delete(id);
    }

    public int count() throws SQLException {
        return studentRepository.count();
    }
}
