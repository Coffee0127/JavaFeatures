import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JUnit5Test {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t"})
    @DisplayName("Should return true if input is blank string")
    void isBlank_ShouldReturnTrueForBlankStrings(String input) {
        assertTrue(StringUtils.isBlank(input));
    }

}
