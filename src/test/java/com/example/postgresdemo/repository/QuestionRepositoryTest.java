package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Question;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    @Transactional
    @Rollback(true)
    public void shouldReturnCountOnemoreThanPreviousAfterDBInsertion() {
        final long expectedCount = questionRepository.count() +1;
        Question question = new Question();
        question.setTitle("SomeTitle 2");
        question.setDescription("Some description 2");
        questionRepository.save(question);
        Assert.assertEquals(expectedCount,questionRepository.count());
    }
}