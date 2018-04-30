package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.thoughtworks.FizzBuzzGame.BUZZ;
import static com.thoughtworks.FizzBuzzGame.FIZZ;
import static com.thoughtworks.FizzBuzzGame.WHIZZ;
import static org.junit.Assert.assertEquals;

public class FizzBuzzGameTest {

    private FizzBuzzGame fizzBuzzGame;

    @Before
    public void setUp() throws Exception {
        fizzBuzzGame = new FizzBuzzGame();
    }

    @Test
    public void should_return_1_when_1() {
        assertEquals(fizzBuzzGame.countOff(1),"1");
    }

    @Test
    public void should_return_Fizz_when_have_3() {
        assertEquals(fizzBuzzGame.countOff(3), FIZZ);
    }
    @Test
    public void should_return_Buzz_when_have_5(){
        assertEquals(fizzBuzzGame.countOff(5), BUZZ);
    }
    @Test
    public void should_return_Whizz_when_have_7(){
        assertEquals(fizzBuzzGame.countOff(7), WHIZZ);
    }

    @Test
    public void should_return_Whizz_when_have_3_and_5(){
        assertEquals(fizzBuzzGame.countOff(15), FIZZ + BUZZ);
    }

    @Test
    public void should_return_Whizz_when_have_5_and_7(){
        assertEquals(fizzBuzzGame.countOff(70), BUZZ + WHIZZ);
    }
    @Test
    public void should_return_Whizz_when_have_3_and_7(){
        assertEquals(fizzBuzzGame.countOff(21), FIZZ + WHIZZ);
    }
    @Test
    public void should_return_Whizz_when_have_3_5_and_7(){
        assertEquals(fizzBuzzGame.countOff(105), FIZZ + BUZZ + WHIZZ);
    }

    @Test
    public void should_return_Whizz_when_contain_3(){
        assertEquals(fizzBuzzGame.countOff(35), FIZZ);
    }

    @Test
    public void testRange() {
        String result = "1\n" +
                "2\n" +
                "Fizz\n" +
                "4\n" +
                "Buzz\n" +
                "Fizz\n" +
                "Whizz\n" +
                "8\n" +
                "Fizz\n" +
                "Buzz\n" +
                "11\n" +
                "Fizz\n" +
                "Fizz\n" +
                "Whizz\n" +
                "FizzBuzz\n" +
                "16\n" +
                "17\n" +
                "Fizz\n" +
                "19\n" +
                "Buzz";
        List<String> stringList = Arrays.asList(result.split("\n"));
        fizzBuzzGame.start(20);
        assertEquals(fizzBuzzGame.getResults(),stringList);
    }
}
