/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.controller;

import cs544.letmegiveexam.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author bidur
 */
public class TestController {
    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String subjects(){
        TestService testService = new TestService();
        System.out.println(testService.getSubjects().toString());
        return "welcome";
    }
    
}
