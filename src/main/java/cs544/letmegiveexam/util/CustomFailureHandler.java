/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.util;

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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author nirali_bheda
 */
public class CustomFailureHandler implements AuthenticationFailureHandler{
    @Autowired
    private UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter;
    
    @Autowired
    UserServices userServices;
    
     private int attempts=0;
  
   @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException ae) throws IOException, ServletException {
        System.out.println("OIn Failure handler");
         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName();
        User user= userServices.getUserByUsername(name);
        HttpSession httpSession=req.getSession();
        if(null!=user){
                System.out.println("User not null : " + user.getFirstName());
                attempts=user.getLockCount();
                if (attempts>=3) {
                    user.setLockCount(attempts);
                    user.setLockTime(new Date());
                    user.setEnabled(false);
                    userServices.updateUser(user);
                    httpSession.setAttribute("error", "1");
                    res.sendRedirect("/login.html");
                }else{
                    user.setLockCount(attempts);
                    userServices.updateUser(user);
                    httpSession.setAttribute("error", "2");
                    res.sendRedirect("/login.html");
                }
            }else{
                httpSession.setAttribute("error", "2");
                res.sendRedirect("/login.html");
            }
 
        
    }

}
