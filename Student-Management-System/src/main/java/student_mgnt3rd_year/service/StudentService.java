package student_mgnt3rd_year.service;

import student_mgnt3rd_year.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudents();


    Student getOneStudent(Long id);

    void deleteStudent(Long id);
}
