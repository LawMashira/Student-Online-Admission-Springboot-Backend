package student_mgnt3rd_year.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Lawson Matutu
 * Zimbabwe Open University 3rd year Project
 **/
@Data
@Entity
@Table(name="students_table")
public class Student
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long ID;


    @Column(name = "name",nullable = false)
    private  String studentName;

    @Column(name = "contact_number",nullable = false)
    private  String contactNumber;

    @Column(name = "nationalID",nullable = false)
    private  String nationalID;
    @Column(name = "gender",nullable = false)
    private  String gender;
    @Column(name = "email",nullable = false)
    private  String email;
    @Column(name = "course",nullable = false)
    private  String course;

    @Column(name = "faculty",nullable = false)
    private  String  faculty;







}
