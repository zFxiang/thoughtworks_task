package tw.core.generator;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;



/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void right() throws OutOfRangeAnswerException {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9,4))
                .thenReturn("1 2 3 4");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        Answer answer = answerGenerator.generate();
        assertEquals("1 2 3 4",answer.toString());
    }

    @Test
    public void should_throw_exception_when_validated() throws OutOfRangeAnswerException {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9,4))
                .thenReturn("1 2 2 4");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        thrown.expect(OutOfRangeAnswerException.class);
        thrown.expectMessage("Answer format is incorrect");
        answerGenerator.generate();
    }
}

