package student_mgnt3rd_year.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import student_mgnt3rd_year.model.Role;
import student_mgnt3rd_year.security.UserPrinciple;
import student_mgnt3rd_year.service.UserService;

import java.nio.file.attribute.UserPrincipal;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PutMapping("change/{role}")
    public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrinciple userPrinciple, @PathVariable Role role)
    {

        userService.changeRole(role,userPrinciple.getUsername());
        return ResponseEntity.ok(true);

    }
}
