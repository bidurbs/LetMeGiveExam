package cs544.letmegiveexam.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Arjun
 */
@Entity
@Table(name = "UserExam")
@NamedQueries({
    @NamedQuery(name = "UserExam.findAll", query = "SELECT ue FROM UserExam ue"),
    @NamedQuery(name = "UserExam.findById", query = "SELECT ue FROM UserExam ue WHERE ue.id= :id"),
    @NamedQuery(name = "UserExam.findByStartTime", query = "SELECT ue FROM UserExam ue WHERE ue.startTime= :startTime"),
    @NamedQuery(name = "UserExam.findByDurateion", query = "SELECT ue FROM UserExam ue WHERE ue.durateion= :durateion"),
    @NamedQuery(name = "UserExam.findByScore", query = "SELECT ue FROM UserExam ue WHERE ue.score= :score"),
    @NamedQuery(name = "UserExam.findByUser", query = "SELECT ue FROM UserExam ue WHERE ue.user= :user")
})
public class UserExam implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date startTime;
    
    @Column(nullable = false)
    private String durateion;
    @Column(nullable = false)
    private int score;
    @ManyToOne
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(nullable = false ,name="questionSet_Id")
    private QuestionSet questionSet;

    public UserExam(Date startTime, String durateion, int score, User user) {
        this.startTime = startTime;
        this.durateion = durateion;
        this.score = score;
        this.user = user;
    }

    public UserExam() {
    }

    public UserExam(Date startTime, User user, QuestionSet questionSet) {
        this.startTime = startTime;
        this.user = user;
        this.questionSet = questionSet;
    }
    

    public int getId() {
        return id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
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

    public QuestionSet getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(QuestionSet questionSet) {
        this.questionSet = questionSet;
    }
    
    

}
