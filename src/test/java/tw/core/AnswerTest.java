package tw.core;

import org.junit.jupiter.api.Test;


import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    @Test
    void testCreateAnswer() {
        Answer answer = Answer.createAnswer("1 2 3");
        assertEquals("1 2 3",answer.toString());
    }

    @Test
    void pass_when_validated() throws OutOfRangeAnswerException {
        Answer answer = Answer.createAnswer("1 2 3");
        answer.validate();
    }

    @Test
    void pass_when_invalidated(){
        Answer answer = Answer.createAnswer("1 2 3 3");
        OutOfRangeAnswerException exception = assertThrows(OutOfRangeAnswerException.class, answer::validate);
        assertEquals("Answer format is incorrect",exception.getMessage());
    }

    @Test
    void testCheck() {
        Answer answer1 = Answer.createAnswer("1 2 3 4");
        Answer answer2 = Answer.createAnswer("5 2 3 1");
        Record record = answer1.check(answer2);
        assertArrayEquals(new int[]{2,1},record.getValue());
    }

    @Test
    void testGetIndexOfNum() {
        Answer answer = Answer.createAnswer("1 2 3 4");
        int index = answer.getIndexOfNum("1");
        assertEquals(0,index);
    }
}