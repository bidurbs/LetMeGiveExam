/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.controller;

import cs544.letmegiveexam.model.User;
import cs544.letmegiveexam.service.UserServices;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
   public String student(ModelMap model) {
       model.addAttribute("user", new User());
      return "register";
   }
   
   @RequestMapping(value = "/addUser", method = RequestMethod.POST)
   public String addStudent(User user) {
       user.setEnabled(true);
       user.setLockCount(0);
       user.setLockTime(new java.util.Date());
       user.setRole_id(1);              
        userServices.createUser(user);                 
        System.out.println(user.getFirstName() + " " + user.getLastName());
      return "registerSuccess";
   }

    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }
    
   
   
}
