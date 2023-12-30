package student_mgnt3rd_year.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import student_mgnt3rd_year.model.Role;
import student_mgnt3rd_year.model.User;

import java.util.Optional;

/**
 * Lawson Matutu
 * Zimbabwe Open University 3rd year Project
 **/

public interface UserRepository  extends JpaRepository <User,Long>
{

    //findBy + fieldName
    Optional<User> findByUsername(String username);

    @Modifying
    @Query("update User set role = :role where username = :username")
    void updateUserRole(@Param("username") String username, @Param("role")Role role);

    boolean existsByUsername(String username);
}

