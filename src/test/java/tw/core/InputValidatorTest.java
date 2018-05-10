package tw.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tw.validator.InputValidator;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    void return_true_when_validated() {
        Boolean validate = inputValidator.validate("1 2 3 4");
        assertEquals(true,validate);
    }

    @Test
    void return_false_when_invalidated() {
        assertEquals(false,inputValidator.validate("1 2 3"));
        assertEquals(false,inputValidator.validate("1 2 3 3"));
        assertEquals(false,inputValidator.validate("1 2 3 4 5"));
    }
}
