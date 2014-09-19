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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Arjun
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private int role_id;
    @Column(nullable = false, name = "Email")
    private String email;
    @Column(nullable = false, name = "FirstName")
    private String firstName;
    @Column(nullable = false, name = "LastName")
    private String lastName;
    @ManyToOne
    private Role userRole;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserExam> userExamList = new ArrayList<UserExam>();

    public User(int role_id, String email, String firstName, String lastName, Role userRole) {
        this.role_id = role_id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
    }

    public User() {
    }

    public int getId() {
        return id;
    }


    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
