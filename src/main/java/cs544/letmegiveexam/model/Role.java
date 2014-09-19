/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author Arjun
 */
@Entity
public class Role {

    @Id
    @GeneratedValue
    private int id;
    private String role;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "userRole")
    @JoinTable(name="User_Role")
    private List<User> userList = new ArrayList<User>();

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public Role(String role) {
        this.role = role;
    }

}
