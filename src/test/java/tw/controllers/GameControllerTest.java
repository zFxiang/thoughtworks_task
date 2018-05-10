package tw.controllers;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.GameStatus;
import tw.core.generator.AnswerGenerator;
import tw.views.GameView;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {

    private GameController gameController;
    private InputCommand inputCommand;
    private Game game;

    @Before
    public void setUp() throws Exception{
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        game = new Game(answerGenerator);
        gameController = new GameController(game,new GameView());
        inputCommand = mock(InputCommand.class);
    }

    @Test
    public void testPlayOnFail() throws Exception {
        when(inputCommand.input())
                .thenReturn(Answer.createAnswer("1 2 3 5"))
                .thenReturn(Answer.createAnswer("1 2 3 5"))
                .thenReturn(Answer.createAnswer("1 2 3 6"));
        gameController.play(inputCommand);
        assertEquals(GameStatus.FAIL,game.checkStatus());
    }
    @Test
    public void testPlayOnSuccess() throws Exception {
        when(inputCommand.input())
                .thenReturn(Answer.createAnswer("1 2 3 5"))
                .thenReturn(Answer.createAnswer("1 2 3 5"))
                .thenReturn(Answer.createAnswer("1 2 3 4"));
        gameController.play(inputCommand);
        assertEquals(GameStatus.SUCCESS,game.checkStatus());
    }
}