/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.aspect;

import cs544.letmegiveexam.model.User;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author nirali_bheda
 */
public interface IEmailAspect {
     public void emailTraceMethod(JoinPoint point, User user);
}
