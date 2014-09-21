/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.service;

import cs544.letmegiveexam.crudfacade.EntityFacade;
import cs544.letmegiveexam.model.Role;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Arjun
 */
public class RoleService {
    @Autowired
    private EntityFacade crudfasade;
    
    public void updateRole(Role role) {
        crudfasade.update(role);
    }
 
    public Role getRoleById(Long Id) {
        return (Role) crudfasade.read(Id, Role.class);
    }

    public void deleteRole(Role role) {
        crudfasade.delete(role);        
    }

	public void saveRole(Role role) {
        crudfasade.save(role);
    }
}
