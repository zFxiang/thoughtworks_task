package tw.core.generator;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    @Test
    void right() throws OutOfRangeAnswerException {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9,4))
                .thenReturn("1 2 3 4");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        Answer answer = answerGenerator.generate();
        assertEquals("1 2 3 4",answer.toString());
    }

    @Test
    void should_throw_exception_when_validated() {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9,4))
                .thenReturn("1 2 2 4");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        OutOfRangeAnswerException exception = assertThrows(OutOfRangeAnswerException.class, answerGenerator::generate);
        assertEquals("Answer format is incorrect",exception.getMessage());
    }
}

