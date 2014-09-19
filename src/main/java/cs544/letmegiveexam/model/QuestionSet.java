/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Question> getQuestionslist() {
        return questionslist;
    }

    public void setQuestionslist(List<Question> questionslist) {
        this.questionslist = questionslist;
    }
    @Id
    @GeneratedValue
    private int id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "QuestionSet-Question",
            joinColumns = @JoinColumn(name = "questionSet_Id"),
            inverseJoinColumns = @JoinColumn(name = "question_Id")
    )
    private List<Question> questionslist = new ArrayList();
}
