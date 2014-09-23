package cs544.letmegiveexam.aspect;


import cs544.letmegiveexam.model.User;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author nirali_bheda
 */
@Aspect
public class LogAdvice {
    @Autowired
    Logger logger;
    
    @After("execution (* cs544.letmegiveexam.controller.LoginController.welcome(..))&& args(model,session) ")
    public void logMethodCalls(JoinPoint point, Model model,HttpSession session) {
        User user=(User)session.getAttribute("user");
        logger.log("at "+new Date()+"the user: "+user.getUsername()+"login on system");
        System.out.println("at "+new Date()+"the user: "+user.getUsername()+"login on system");
    }
    
    @After("execution (* cs544.letmegiveexam.controller.UserController.addStudent(..))&& args(user,result) ")
    public void logRegister(JoinPoint point, User user, BindingResult result) {
        logger.log("at "+new Date()+"the user: "+user.getUsername()+"Register on system");
        System.out.println("at "+new Date()+"the user: "+user.getUsername()+"Register on system");
    }
   

}
