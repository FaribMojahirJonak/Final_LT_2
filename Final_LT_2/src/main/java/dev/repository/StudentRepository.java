package dev.repository;

import dev.domain.Gender;
import dev.domain.Student;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private DataSource dataSource;

    public StudentRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void create(Student student) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (id, name, email, password, dateOfBirth, gender, quota, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, student.getId());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setString(3, student.getEmail());
        preparedStatement.setString(4, student.getPassword());
        preparedStatement.setDate(5, Date.valueOf(student.getDateOfBirth()));
        preparedStatement.setString(6, student.getGender().name());
        preparedStatement.setString(7, student.getQuota());
        preparedStatement.setString(8, student.getCountry());
        preparedStatement.execute();
    }

    public List<Student> getAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, email, password, dateOfBirth, gender, quota, country FROM students");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Student student = new Student();

            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setEmail(resultSet.getString("email"));
            student.setPassword(resultSet.getString("password"));
            student.setDateOfBirth(LocalDate.parse(resultSet.getString("dateOfBirth")));
            student.setGender(Gender.valueOf(resultSet.getString("gender")));
            student.setQuota(resultSet.getString("quota"));
            student.setCountry(resultSet.getString("country"));
            students.add(student);
        }
        return students;
    }

    public Student get(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, email, password, dateOfBirth, gender, quota, country FROM students WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return new Student(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getDate("dateOfBirth").toLocalDate(), Gender.valueOf(resultSet.getString("gender").toUpperCase()),resultSet.getString("quota"),resultSet.getString("country"));
        }
        return new Student();
    }

    public void update(Student student) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE students set name = ?, email = ?, password = ?, dateOfBirth = ?, gender = ?, quota = ?, country = ? WHERE id = ?");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getEmail());
        preparedStatement.setString(3, student.getPassword());
        preparedStatement.setDate(4, Date.valueOf(student.getDateOfBirth()));
        preparedStatement.setString(5, student.getGender().name());
        preparedStatement.setString(6, student.getQuota());
        preparedStatement.setString(7, student.getCountry());
        preparedStatement.setInt(8, student.getId());
        preparedStatement.execute();
    }

    public void delete(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM students WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public int count() throws SQLException {
        int count = 0;
        List<Student> students = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, email, password, dateOfBirth, gender, quota, country FROM students");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            count++;
        }
        return count;
    }
}
