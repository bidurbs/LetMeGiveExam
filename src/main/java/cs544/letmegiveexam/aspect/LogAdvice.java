/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * @author nirali_bheda
 */
@Aspect
public class LogAdvice {
    

    @After("execution (* cs544.letmegiveexam.controller.LoginController.*(..))")
    public void logMethodCalls(JoinPoint point) {
            System.out.println("*******Logs... ");

    }
   

}
