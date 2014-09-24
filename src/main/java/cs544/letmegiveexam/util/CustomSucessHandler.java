package cs544.letmegiveexam.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import cs544.letmegiveexam.crudfacade.CRUDEntityFacade;

import cs544.letmegiveexam.service.UserServices;
import cs544.letmegiveexam.model.User;

/**
 * @author nirali Class used to handle a successful user authentication.
 */
public class CustomSucessHandler implements AuthenticationSuccessHandler {

    @Autowired
    CRUDEntityFacade facade;

    @Autowired
    UserServices userServices;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication auth)
            throws IOException, ServletException {

        Object obj =  auth.getPrincipal();
        //String username=userAuth.getUsername();
      String uname=((org.springframework.security.core.userdetails.User)obj).getUsername();
        
        //System.out.println("Authentication success username: " + uname);

        User user = facade.findByUsername(uname);

        if (user.getLockTime() != null) {

            if ((System.currentTimeMillis() - user.getLockTime().getTime()) >= 300000) {
               // System.out.println("Unlocking Userr");
                user.setLockCount(0);
                user.setLockTime(null);
                user.setEnabled(true);
                userServices.updateUser(user);
                response.sendRedirect("welcome");
            } else {
               // System.out.println("Success but lock time not exceed.. ");
               response.sendRedirect("login?error=AccountLock");

            }
        } else {
         //   System.out.println("Lock time null.. ");
           response.sendRedirect("welcome");
        }

    }
}
