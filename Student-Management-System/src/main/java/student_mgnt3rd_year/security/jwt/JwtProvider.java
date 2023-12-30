package student_mgnt3rd_year.security.jwt;

import org.springframework.security.core.Authentication;
import student_mgnt3rd_year.security.UserPrinciple;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {
    String generateToken(UserPrinciple auth);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
