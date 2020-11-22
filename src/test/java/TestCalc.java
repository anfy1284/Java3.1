import Lesson_6.Calc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestCalc {
    Calc calc;

    @BeforeEach
    public void init(){
        calc = new Calc();
    }

    @Test
    public void testSubArr1(){
        Integer[]tmp = calc.subArr(new Integer[]{1,3,5,7,4,4,6,7}, 4);
        Assertions.assertArrayEquals(new Integer[]{6,7}, tmp);
    }

    @Test()
    public void testSubArr2(){
        Integer[]tmp = calc.subArr(new Integer[]{5,6,4,7,4,4,1,2}, 4);
        Assertions.assertArrayEquals(new Integer[]{1,2}, tmp);
    }

    @Test()
    public void testSubArr3(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            calc.subArr(new Integer[]{5,6,7,1,2}, 4);
        });
    }


    //А теперь попробуем параметризацию
    @ParameterizedTest
    @MethodSource("dataForSearch")
    public void testSearch(Integer[] a, Integer[] b, boolean result) {
        Assertions.assertEquals(result, calc.search(a, b));
    }

    public static Stream<Arguments> dataForSearch() {
        List<Arguments> out = new ArrayList<>();

        out.add(Arguments.arguments(new Integer[]{3,5,6},new Integer[]{1,4}, false));
        out.add(Arguments.arguments(new Integer[]{5,3,1},new Integer[]{1,4}, true));
        out.add(Arguments.arguments(new Integer[]{8,7,4},new Integer[]{1,4}, true));

        return out.stream();
    }

}
