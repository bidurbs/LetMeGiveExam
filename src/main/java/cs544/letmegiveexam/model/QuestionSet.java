package cs544.letmegiveexam.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ahmadreza
 */
@Entity
@Table(name = "QuestionSet")
@NamedQueries({
    @NamedQuery(name = "QuestionSet.findAll", query = "SELECT qs FROM QuestionSet qs"),
    @NamedQuery(name="QuestionSet.findById", query = "SELECT qs FROM QuestionSet qs WHERE qs.id= :id"),
    @NamedQuery(name = "QuestionSet.findByQuestionslist", query = "SELECT qs FROM QuestionSet qs WHERE qs.questionslist= :questionslist"),
    })
public class QuestionSet implements Serializable {
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
