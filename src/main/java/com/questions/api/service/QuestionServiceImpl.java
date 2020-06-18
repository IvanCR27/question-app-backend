package com.questions.api.service;

import com.questions.api.entity.Question;
import com.questions.api.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public ResponseEntity<List<Question>> getQuestions() {
        List<Question> questions = questionRepository.findAll();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @Override
    public ResponseEntity saveResponses(List<Question> questions) {
        if(Objects.isNull(questions) || questions.isEmpty()) {
            log.error("Los datos de entrada son nulos o vacios");
            throw new IllegalArgumentException("Los datos de entrada son nulos o vacios");
        }

        for(Question item: questions) {
            if(!Objects.isNull(item) || !StringUtils.isBlank(item.getResponse())) {
                questionRepository.save(item);
            }
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
