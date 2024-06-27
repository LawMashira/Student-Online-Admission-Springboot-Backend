package student_mgnt3rd_year.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import student_mgnt3rd_year.controller.exception.UserAlreadyExistsException;
import student_mgnt3rd_year.model.User;
import student_mgnt3rd_year.service.AuthenticationService;
import student_mgnt3rd_year.service.UserService;


/**
 * Lawson Matutu
 * Zimbabwe Open University 3rd year Project
 **/



@RestController
@RequestMapping("api/authentication")
public class AuthenticationController
{

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
/*
    public ResponseEntity<?> registerUser(@RequestBody User user){
        try{
            userService.saveUser(user);
            return ResponseEntity.ok("Registration successful!");

        }catch (UserAlreadyExistsException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }*/

    public ResponseEntity<?> signUp(@RequestBody User user )


    {
       if (userService.findByUsername(user.getUsername()).isPresent())
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return  new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);

    }

    @PostMapping("sign-in")
    public  ResponseEntity<?> signIn(@RequestBody User user)
    {
        return  new ResponseEntity<>(authenticationService.signInAndReturnJWT(user),HttpStatus.OK);

    }

    /*{
        try{
            authenticationService.signInAndReturnJWT(user);
            return  ResponseEntity.ok("You have successfully login");

        }catch (Exception e){
         return   ResponseEntity.ok("Wrong username or password")   ;
        }

    }*/


}
