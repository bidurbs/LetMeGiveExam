/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Arjun
 */
@Entity
public class UserExam {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String startTime;
    @Column(nullable = false)
    private String durateion;
    @Column(nullable = false)
    private int score;
    @ManyToOne
    private User user;
        
    @OneToOne(cascade = CascadeType.ALL)
    private QuestionSet questionSet;

    public UserExam(String startTime, String durateion, int score, User user) {
        this.startTime = startTime;
        this.durateion = durateion;
        this.score = score;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDurateion() {
        return durateion;
    }

    public void setDurateion(String durateion) {
        this.durateion = durateion;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }        

}
