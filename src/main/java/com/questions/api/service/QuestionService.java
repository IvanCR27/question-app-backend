package com.questions.api.service;

import com.questions.api.entity.Question;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.Response;
import java.util.List;

public interface QuestionService {

    ResponseEntity<List<Question>> getQuestions();

    ResponseEntity saveResponses(List<Question> questions);

}
