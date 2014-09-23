/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.aspect;


import cs544.letmegiveexam.model.User;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

/**
 *
 * @author nirali_bheda
 */
@Aspect
public class LogAdvice {
    
    private ILogger logger;
    @After("execution (* cs544.letmegiveexam.controller.LoginController.welcome(..))&& args(model,session) ")
    public void logMethodCalls(JoinPoint point, Model model,HttpSession session) {
        User user=(User)session.getAttribute("user");
        logger.log("username...."+user.getUsername());

    }
   

}
