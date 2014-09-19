package cs544.letmegiveexam.model;

import java.io.Serializable;
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
public class UserExam implements Serializable {
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
//    @JoinColumn(nullable = false ,name="questionSet_Id")
    private QuestionSet questionSet;

    public UserExam(String startTime, String durateion, int score, User user) {
        this.startTime = startTime;
        this.durateion = durateion;
        this.score = score;
        this.user = user;
    }

    public UserExam() {
    }

    public int getId() {
        return id;
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
