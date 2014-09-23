

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.controller;

import cs544.letmegiveexam.model.User;
import cs544.letmegiveexam.service.UserServices;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nirali_bheda
 */
@Controller
public class UserController {
    
    private UserServices userServices;
    
    
    
   @RequestMapping(value = "/register", method = RequestMethod.GET)
   public String register(ModelMap model) {
       model.addAttribute("user", new User());
      return "register";
   }
       @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addStudent(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        } else {
            user.setEnabled(true);
            user.setLockCount(0);
            user.setLockTime(null);
            user.setRole_id(1);
            userServices.createUser(user);
            
            return "registerSuccess";
        }
    }

    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }
    @RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
    public String viewprofile(ModelMap model, HttpSession session) {
      if(session.getAttribute("user")!=null){
           model.addAttribute("user",(User) session.getAttribute("user") );
         
      }else{
          model.addAttribute("user", new User());
      }
        return "viewProfile";
      
    }
    

    
   
   
}
