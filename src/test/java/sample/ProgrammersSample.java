package sample;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

public class ProgrammersSample {

    @DisplayName("테스트1")
    @ParameterizedTest(name = "{index} ==> param1=''{0}'', param2=''{1}'', param3=''{2}'', expect=''{3}''")
    @CsvSource(value = {
            "'119','97674223','1195524421', false",
            "'123','456','789', false",
            "'12','123','1235', false"
    })
    public void test1(String param1, String param2, String param3, boolean expect) {

        final String[] params = {param1, param2, param3};

        final Solution solution = new Solution();
        final boolean result = solution.solution(params);

        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("테스트2")
    public void test2() {

    }

    class Solution {
        public boolean solution(String[] participant) {
            System.out.println("participant = " + Arrays.toString(participant));
            String answer = "";
            return false;
        }
    }

}



