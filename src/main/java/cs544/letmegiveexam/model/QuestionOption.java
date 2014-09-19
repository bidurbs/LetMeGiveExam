package cs544.letmegiveexam.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ahmadreza
 */
@Entity
@Table(name = "Question_Option")
public class QuestionOption implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String option;

    public QuestionOption() {
    }

    public QuestionOption(String option) {
        this.option = option;
    }

    public long getId() {
        return id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    
    
}
