package tw.core;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void testCreateAnswer() {
        Answer answer = Answer.createAnswer("1 2 3");
        assertEquals("1 2 3",answer.toString());
    }

    @Test
    public void pass_when_validated() throws OutOfRangeAnswerException {
        Answer answer = Answer.createAnswer("1 2 3");
        answer.validate();
    }

    @Test
    public void pass_when_invalidated() throws OutOfRangeAnswerException {
        thrown.expect(OutOfRangeAnswerException.class);
        thrown.expectMessage("Answer format is incorrect");
        Answer answer = Answer.createAnswer("1 2 3 3");
        answer.validate();
    }

    @Test
    public void testCheck() {
        Answer answer1 = Answer.createAnswer("1 2 3 4");
        Answer answer2 = Answer.createAnswer("5 2 3 1");
        Record record = answer1.check(answer2);
        assertArrayEquals(new int[]{2,1},record.getValue());
    }

    @Test
    public void testGetIndexOfNum() {
        Answer answer = Answer.createAnswer("1 2 3 4");
        int index = answer.getIndexOfNum("1");
        assertEquals(0,index);
    }
}