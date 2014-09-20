package cs544.letmegiveexam.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ahmadreza
 */
@Entity
@Table(name = "Question")
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name="Question.findById", query = "SELECT q FROM Question q WHERE q.id= :id"),
    @NamedQuery(name = "Question.findBySubject", query = "SELECT q FROM Question q WHERE Q.question= :subject"),
    @NamedQuery(name="Question.findByQuestionOption", query = "SELECT q FROM Question q WHERE q.questionOption= :questionOption"),
    @NamedQuery(name="Question.findByDifficultyLevel", query = "SELECT q FROM Question q WHERE q.difficultyLevel= :difficultyLevel"),
    @NamedQuery(name="Question.findByQuestion", query = "SELECT q FROM Question q WHERE q.question= :question"),
    @NamedQuery(name="Question.findByCorrectAnswer", query = "SELECT q FROM Question q WHERE q.correctAnswer= :correctAnswer")
})
public class Question implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    
    private Subject subject;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Question_Answer")    
    
    private List<QuestionOption> questionOption =new ArrayList<>();
    
    @Column(name="Difficulty_Level")        
    private int difficultyLevel;
    
    @Column(name="Question")    
    private String question;
    
    @Column(name="CorrectAnswer")    
    private String correctAnswer;

    public Question() {        
    }

    public Question(Subject subject, int difficultyLevel, String question, String correctAnswer) {
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

    public List<QuestionOption> getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(List<QuestionOption> questionOption) {
        this.questionOption = questionOption;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
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

   
}
