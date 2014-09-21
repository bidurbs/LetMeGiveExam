/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.service;

import cs544.letmegiveexam.crudfacade.EntityFacade;
import cs544.letmegiveexam.model.Subject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bidur
 */
public class TestService {
    @Autowired
    private EntityFacade crudfacade;
    
    public List<Subject> getSubjects() {

        try {
            //Map<String, String> paramaters = new HashMap<>(1);
            return crudfacade.findWithNamedQuery("Subject.getAll");
        } catch (Exception ex) {
            return null;

        }
    }

    
}
