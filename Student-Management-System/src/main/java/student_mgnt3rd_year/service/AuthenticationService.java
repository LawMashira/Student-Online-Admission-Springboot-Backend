package student_mgnt3rd_year.service;

import student_mgnt3rd_year.model.User;

public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
