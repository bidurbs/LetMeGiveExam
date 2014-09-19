package cs544.letmegiveexam.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author ahmadreza
 */
@Entity
public class QuestionSet {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "QuestionSet-Question",
            joinColumns = @JoinColumn(name = "questionSet_Id"),
            inverseJoinColumns = @JoinColumn(name = "question_Id")
    )
    
    private List<Question> questionslist = new ArrayList();

    public QuestionSet() {
    }
    
    public long getId() {
        return id;
    }

    public List<Question> getQuestionslist() {
        return questionslist;
    }

    public void setQuestionslist(List<Question> questionslist) {
        this.questionslist = questionslist;
    }
    
}
