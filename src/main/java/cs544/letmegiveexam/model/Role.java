/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Arjun
 */
@Entity
@Table(name = "Role")
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name="Role.findById", query = "SELECT r FROM Role r WHERE r.id= :id"),
    @NamedQuery(name = "Role.findByRole", query = "SELECT r FROM Role r WHERE r.role= :role"),
    @NamedQuery(name="Role.findByUserList", query = "SELECT r FROM Role r WHERE r.userList= :userList")
    })
public class Role implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String role;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "userRole")
    private List<User> userList = new ArrayList<User>();

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }


}
