/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nirali_bheda
 */
@Controller
public class LoginController {
        @RequestMapping(value="/welcome", method=RequestMethod.GET)
        public String welcome(){
            return "welcome";
        }
//        @ExceptionHandler(value=NoSuchResourceException.class)
//	public ModelAndView handle(Exception e) {
//		ModelAndView mv = new ModelAndView();
//		mv.getModel().put("e", e);
//		mv.setViewName("noSuchResource");
//		return mv;
//	}
        @RequestMapping(value="/loginfailed", method=RequestMethod.GET)
	public String loginfailed(Model model) {
		
		return "loginfailed";
	}
}
