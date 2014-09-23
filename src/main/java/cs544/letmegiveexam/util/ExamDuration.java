/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.util;

import java.sql.Timestamp;
import java.util.Date;
import javax.inject.Singleton;
import org.springframework.stereotype.Component;

/**
 *
 * @author bidur
 */
@Component
@Singleton
public class ExamDuration {
    
    public static long get(Date startTimestamp){
        java.util.Date date = new java.util.Date();
        Date currentTimestamp = new Timestamp(date.getTime());
        return (currentTimestamp.getTime() - startTimestamp.getTime())/(60*60);
    }
    
}
