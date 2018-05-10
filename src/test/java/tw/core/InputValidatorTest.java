package tw.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tw.validator.InputValidator;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    private InputValidator inputValidator;

    @Before
    public void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    public void return_true_when_validated() {
        Boolean validate = inputValidator.validate("1 2 3 4");
        assertEquals(true,validate);
    }

    @Test
    public void return_false_when_invalidated() {
        assertEquals(false,inputValidator.validate("1 2 3"));
        assertEquals(false,inputValidator.validate("1 2 3 3"));
        assertEquals(false,inputValidator.validate("1 2 3 4 5"));
    }
}
