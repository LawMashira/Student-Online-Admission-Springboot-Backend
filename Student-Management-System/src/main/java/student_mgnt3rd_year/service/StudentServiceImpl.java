package student_mgnt3rd_year.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student_mgnt3rd_year.model.Student;
import student_mgnt3rd_year.repository.StudentRepository;

import java.util.List;

/**
 * Lawson Matutu
 * Zimbabwe Open University 3rd year Project
 **/

@Service
public class StudentServiceImpl  implements  StudentService
{
    @Autowired
    private StudentRepository studentRepository;
@Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student) ;
    }
@Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();

    }
@Override
    public Student getOneStudent(Long id) {
        return studentRepository.findById(id).get();
    }
@Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }




}
