package com.ssce.ssceocjp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="questions")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private String question;
    private int numberOfAnswers;
    private int numberOfCorrectAnswers;
    private String explanation;
    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Answer> answers;
    

}
