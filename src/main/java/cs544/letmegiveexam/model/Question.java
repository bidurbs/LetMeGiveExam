package cs544.letmegiveexam.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ahmadreza
 */
@Entity
@Table(name = "Question")
@SecondaryTable(name = "Answers")
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "FROM Question q"),
    @NamedQuery(name = "Question.findById", query = "SELECT q FROM Question q WHERE q.id= :id"),
    @NamedQuery(name = "Question.findBySubject", query = "FROM Question q WHERE q.subject.id= :subjectId"),
    @NamedQuery(name = "Question.findByDifficultyLevel", query = "SELECT q FROM Question q WHERE q.difficultyLevel= :difficultyLevel"),
    @NamedQuery(name = "Question.findByQuestion", query = "SELECT q FROM Question q WHERE q.question= :question"),
    @NamedQuery(name = "Question.findByCorrectAnswer", query = "SELECT q FROM Question q WHERE q.correctAnswer= :correctAnswer")
})
public class Question implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", nullable = false)

    private Subject subject;
    
    @Transient
    private String userAnswer;    

    @Column(name = "Difficulty_Level")
    private String difficultyLevel;

    @Column(name = "Question")
    private String question;

    @Column(name = "CorrectAnswer")
    private String correctAnswer;

    @Column(table = "Answers")
    private String option1;

    @Column(table = "Answers")
    private String option2;

    @Column(table = "Answers")
    private String option3;

    @Column(table = "Answers")
    private String option4;

    public Question() {
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public Question(Subject subject, String difficultyLevel, String question, String correctAnswer) {
        this.subject = subject;
        this.difficultyLevel = difficultyLevel;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public long getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

}
