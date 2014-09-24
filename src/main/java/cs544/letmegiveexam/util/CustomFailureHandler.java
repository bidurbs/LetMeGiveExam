/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.util;

import cs544.letmegiveexam.crudfacade.CRUDEntityFacade;
import cs544.letmegiveexam.model.User;
import cs544.letmegiveexam.service.UserServices;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 *
 * @author nirali_bheda
 */
public class CustomFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    CRUDEntityFacade facade;
    
    @Autowired
    UserServices userServices;
   
    private int attempts = 0;

    @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException ae) throws IOException, ServletException {
//        System.out.println("OIn Failure handler");
        Authentication au=ae.getAuthentication();
        
       String username = (String)ae.getAuthentication().getPrincipal();    

       // System.out.println("Authentication username: " +username);
        
        
        User user = facade.findByUsername(username);
        HttpSession httpSession = req.getSession();
        System.out.println("");
        if (null != user) {
           // System.out.println("User not null : " + user.getFirstName());
            attempts = user.getLockCount()+1;
            
            if (attempts >= 3) {
                user.setLockCount(attempts);
                user.setLockTime(new Date());
                //user.setEnabled(false);
                userServices.updateUser(user);
                httpSession.setAttribute("error", "1");
                res.sendRedirect("login?error=AccountLock");
            } else {
                user.setLockCount(attempts);
                userServices.updateUser(user);
                httpSession.setAttribute("error", "2");
                res.sendRedirect("login?error=InvalidCredentials");
            }
        } else {
            httpSession.setAttribute("error", "2");
            res.sendRedirect("login?error=InvalidCredentials");
        }

    }

   
}
