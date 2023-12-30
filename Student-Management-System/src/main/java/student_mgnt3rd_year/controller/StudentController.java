package student_mgnt3rd_year.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student_mgnt3rd_year.model.Student;
import student_mgnt3rd_year.service.StudentService;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Lawson Matutu
 * Zimbabwe Open University 3rd year Project
 **/

@RestController
@RequestMapping("/api-student")
public class StudentController
{
@Autowired
    private StudentService studentService;


@PostMapping("/adding/students")

    public String addStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New student successfully added ";

    }

    @GetMapping("/getting/all/students")

    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id){
        try {
            Student student = studentService.getOneStudent(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);

        }catch(NoSuchElementException e1) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student  with ID " +id + " successfully deleted " ;
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentInformation(@RequestBody Student student,@PathVariable Long id){
        try {
            studentService.getOneStudent(id);
            studentService.saveStudent(student);
            return  new ResponseEntity<> (HttpStatus.OK);
        }catch(NoSuchElementException e1) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }
















}
