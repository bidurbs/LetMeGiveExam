/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Arjun
 */
@Entity
@Table(name = "QuestionOption")
@NamedQueries({
    @NamedQuery(name = "QuestionOption.findAll", query = "SELECT qo FROM QuestionOption qo"),
    @NamedQuery(name="QuestionOption.findById", query = "SELECT qo FROM QuestionOption qo WHERE qo.id= :id"),
    @NamedQuery(name = "QuestionOption.findByOption", query = "SELECT qo FROM QuestionOption qo WHERE qo.option= :option"),
    })
public class QuestionOption {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "Option")
    private String option;
    public int getId() {
        return id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public QuestionOption(String option) {
        this.option = option;
    }

    public QuestionOption() {
    }
}
