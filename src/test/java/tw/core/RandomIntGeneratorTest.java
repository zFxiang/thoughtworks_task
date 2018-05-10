package tw.core;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import tw.core.generator.RandomIntGenerator;


import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {

    private RandomIntGenerator randomIntGenerator;

    @BeforeEach
    public void setUp() throws Exception {
        randomIntGenerator = new RandomIntGenerator();
    }

    @Test
    public void should_throw_exception_when_digitmax_less_than_numbersOfNeed() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> randomIntGenerator.generateNums(1, 2));
        assertEquals("Can't ask for more numbers than are available",exception.getMessage());
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