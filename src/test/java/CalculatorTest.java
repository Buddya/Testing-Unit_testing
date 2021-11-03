import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CalculatorTest {
    Calculator sut;

    @BeforeEach
    void getInstance() {
        sut = new Calculator();
    }

    //standard JUnit and parameterizedTest
    @ParameterizedTest
    @MethodSource("data")
    void multiply(int a, int b, int expected) {

        int result = sut.multiply.apply(a, b);

        Assertions.assertEquals(result, expected);

    }

    static Stream<Arguments> data() {
        return Stream.of(
                arguments(2, 2, 4),
                arguments(2, -2, -4),
                arguments(2, 0, 0)
        );
    }

    @Test
    public void plusTest() {
        //given
        int a = 10, b = 5, expected = 15;

        //when
        int result = sut.plus.apply(a, b);

        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void divideThrowsExceptionTest() {
        //given
        int a = 4, b = 0;

        //when
        Throwable exception = assertThrows(ArithmeticException.class, () -> sut.divide.apply(a, b));

        //then
        assertNotNull(exception.getMessage());
    }

    //JUnit with Hamster
    @Test
    public void absTest() {
        //given
        int a = -4;
        int b = 4;

        //then
        assertThat(sut.abs.apply(a), greaterThan(0));
        assertThat(sut.abs.apply(b), greaterThan(0));
    }

    @Test
    public void powTest() {
        //given
        int a = 8;

        //then
        assertThat(sut.pow.apply(a), is(a * a));
    }

}
