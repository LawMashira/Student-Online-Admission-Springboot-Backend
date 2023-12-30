package student_mgnt3rd_year.service;

import student_mgnt3rd_year.model.Role;
import student_mgnt3rd_year.model.User;

import java.util.Optional;

public interface UserService
{ User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);
}
