package cs544.letmegiveexam.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ahmadreza
 */
@Entity
@Table(name = "Question_Option")
public class QuestionOption {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "question")
    @Column(name = "Question_ID", nullable = false)
    private List<Question> questionList=new ArrayList();
    private String option;

    public QuestionOption() {
    }

    public QuestionOption(String option) {
        this.option = option;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    
    
}
