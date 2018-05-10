package tw.core;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {

    @Test
    public void testGuess() throws OutOfRangeAnswerException {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        Mockito.when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        Game game = new Game(answerGenerator);
        Answer inputAnswer = Answer.createAnswer("5 2 3 1");
        GuessResult guessResult = game.guess(inputAnswer);
        assertEquals("2A1B",guessResult.getResult());
        assertEquals(inputAnswer.toString(),guessResult.getInputAnswer().toString());
    }

    @Test
    public void should_return_status_continue() throws OutOfRangeAnswerException {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        Mockito.when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        Game game = new Game(answerGenerator);
        game.guess(Answer.createAnswer("5 2 3 1"));
        assertEquals(GameStatus.CONTINUE,game.checkStatus());
    }
    @Test
    public void should_return_status_success() throws OutOfRangeAnswerException {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        Mockito.when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        Game game = new Game(answerGenerator);
        game.guess(Answer.createAnswer("1 2 3 4"));
        assertEquals(GameStatus.SUCCESS,game.checkStatus());
    }
    @Test
    public void should_return_status_fail() throws OutOfRangeAnswerException {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        Mockito.when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        Game game = new Game(answerGenerator);
        game.guess(Answer.createAnswer("1 2 3 4"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        assertEquals(GameStatus.FAIL,game.checkStatus());
    }
}
