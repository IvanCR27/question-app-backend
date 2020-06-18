package com.questions.api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "question")
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer order;

    private String question;

    private String response;

}
