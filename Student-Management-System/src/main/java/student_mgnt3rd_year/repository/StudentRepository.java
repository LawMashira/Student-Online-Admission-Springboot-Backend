package student_mgnt3rd_year.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student_mgnt3rd_year.model.Student;

/**
 * Lawson Matutu
 * Zimbabwe Open University 3rd year Project
 **/
@Repository
public interface StudentRepository  extends JpaRepository <Student,Long>
{

}
