package tw.core;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import tw.core.generator.RandomIntGenerator;


/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private RandomIntGenerator randomIntGenerator;

    @Before
    public void setUp() throws Exception {
        randomIntGenerator = new RandomIntGenerator();
    }

    @Test
    public void should_throw_exception_when_digitmax_less_than_numbersOfNeed() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Can't ask for more numbers than are available");
        randomIntGenerator.generateNums(1, 2);
    }

    @Test
    public void should_return_right_str() {
        String nums = randomIntGenerator.generateNums(9, 4);
        long count = Arrays.stream(nums.split(" "))
                .map(Integer::parseInt)
                .distinct()
                .filter((num) -> num >= 0 && num < 9)
                .count();
        assertEquals(4,count);
    }
}