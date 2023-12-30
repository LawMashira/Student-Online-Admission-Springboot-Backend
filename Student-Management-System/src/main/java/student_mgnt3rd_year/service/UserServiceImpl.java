package student_mgnt3rd_year.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import student_mgnt3rd_year.controller.exception.UserAlreadyExistsException;
import student_mgnt3rd_year.model.Role;
import student_mgnt3rd_year.model.User;
import student_mgnt3rd_year.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Lawson Matutu
 * Zimbabwe Open University 3rd year Project
 **/

@Service
public class UserServiceImpl  implements  UserService
{
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(User user)
    {
        if (userRepository.existsByUsername(user.getUsername())){
            throw new UserAlreadyExistsException(user.getUsername() + " already exists");
        }


        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional //Transactional is required when executing an update/delete query.
    public void changeRole(Role newRole, String username)
    {
        userRepository.updateUserRole(username, newRole);
    }
}
