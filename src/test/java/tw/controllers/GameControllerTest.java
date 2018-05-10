package tw.controllers;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @BeforeEach
    void setUp() throws Exception{
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        game = new Game(answerGenerator);
        gameController = new GameController(game,new GameView());
        inputCommand = mock(InputCommand.class);
    }

    @Test
    void testPlayOnFail() throws Exception {
        when(inputCommand.input())
                .thenReturn(Answer.createAnswer("1 2 3 5"))
                .thenReturn(Answer.createAnswer("1 2 3 5"))
                .thenReturn(Answer.createAnswer("1 2 3 6"));
        gameController.play(inputCommand);
        Assertions.assertEquals(GameStatus.FAIL,game.checkStatus());
    }
    @Test
    void testPlayOnSuccess() throws Exception {
        when(inputCommand.input())
                .thenReturn(Answer.createAnswer("1 2 3 5"))
                .thenReturn(Answer.createAnswer("1 2 3 5"))
                .thenReturn(Answer.createAnswer("1 2 3 4"));
        gameController.play(inputCommand);
        Assertions.assertEquals(GameStatus.SUCCESS,game.checkStatus());
    }
}