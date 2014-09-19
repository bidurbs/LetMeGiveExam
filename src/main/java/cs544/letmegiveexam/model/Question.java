package cs544.letmegiveexam.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ahmadreza
 */
@Entity
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "subject_id")
    @Column(name = "Sub_ID", nullable = false)
    private List<Subject> subjectLists=new ArrayList();
    @ManyToOne
    @JoinColumn(name = "questionoption_id")
    @Column(name="Question_Option_ID",nullable = false)
    private QuestionOption questionOption;
    @Column(name="Difficulty_Level")
    private int difficultyLevel;
    private String question;
    private String correctAnswer;

    public Question() {
    }

    public Question(QuestionOption questionOption, int difficultyLevel, String question, String correctAnswer) {
        this.questionOption = questionOption;
        this.difficultyLevel = difficultyLevel;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public List<Subject> getSubjectLists() {
        return subjectLists;
    }

    public void setSubjectLists(List<Subject> subjectLists) {
        this.subjectLists = subjectLists;
    }

    public QuestionOption getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(QuestionOption questionOption) {
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
