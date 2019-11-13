import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DataProvider {

    public static Stream<Arguments> signUpPositiveTest() {
        return Stream.of(
                arguments(1, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(6)),
                        RandomStringUtils.randomAlphanumeric(10), "free100"),
                arguments(2, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(6)),
                        RandomStringUtils.randomAlphanumeric(10), "")
        );
    }
}
