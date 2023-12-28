/*
package dev.controller;

import dev.domain.Student;
import dev.service.StudentService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @InitBinder
    public void intiBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/create")
    public String fourth(Model model) {
        model.addAttribute("student", new Student());
        return "registration";
    }

    @RequestMapping("/store")
    public String fifth(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        else {
            studentService.create(student);
            return "confirm";
        }
    }

    @RequestMapping("/students")
    public String showStudents(Model model) throws SQLException {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student";
    }


    @RequestMapping("/students/{id}")
    public String sixth(@PathVariable ("id") int id, Model model) throws SQLException {
        Student student = studentService.get(id);
        model.addAttribute("student", student);
        return "details";
    }

    @RequestMapping("/students/{id}/edit")
    public String edit(@PathVariable ("id") int id, Model model) throws SQLException {
        Student student = studentService.get(id);
        model.addAttribute("student", student);
        return "update";
    }

    @RequestMapping("/students/{id}/edit/update")
    public String update(@Valid @PathVariable ("id") int id, @ModelAttribute("student") Student student, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "/students/{id}/edit/update";
        }
        else {
            studentService.update(student);
            return "redirect:/students/{id}";
        }
    }

    @RequestMapping("/students/{id}/delete")
    public String delete(@PathVariable("id") int id) throws SQLException {
        studentService.delete(id);
        return "redirect:/students";
    }
}
*/
