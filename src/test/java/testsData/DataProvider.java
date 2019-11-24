package testsData;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DataProvider {

    public static Stream<Arguments> signUpPositiveTest() {
        return Stream.of(
                arguments(1, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(6)),
                        RandomStringUtils.randomAlphanumeric(10), "free100"),
                arguments(2, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(10)).toUpperCase(),
                        RandomStringUtils.randomAlphanumeric(10), ""),
                arguments(3, String.format("%s@americanexpress.com", RandomStringUtils.randomAlphabetic(10)),
                        RandomStringUtils.randomAlphanumeric(10), ""),
                arguments(4, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(30)),
                        RandomStringUtils.randomAlphanumeric(10), ""),
                arguments(5, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(63)),
                        RandomStringUtils.randomAlphanumeric(10), ""),
                arguments(6, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(10)),
                        RandomStringUtils.randomAlphanumeric(6), ""),
                arguments(7, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(10)),
                        RandomStringUtils.randomAlphanumeric(20), "")
        );
    }

    //1,2,7,10,11,12,15,18
    public static Stream<Arguments> signUpInvalidCredentialsNegTest() {
        String email;
        String password;
        return Stream.of(
                arguments(1, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(5)),
                        password = RandomStringUtils.randomAlphanumeric(10), password, "", "alert"),
                arguments(2, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(64)),
                        password = RandomStringUtils.randomAlphanumeric(10), password, "", "alert"),
                arguments(3, "@gmail.com", password = RandomStringUtils.randomAlphanumeric(10), password, "",
                        SignInUpAlertMessages.EMAIL_INVALID.getMessage()),
                arguments(4, String.format("%s.gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        password = RandomStringUtils.randomAlphanumeric(10), password, "",
                        SignInUpAlertMessages.EMAIL_INVALID.getMessage()),
                arguments(5, String.format("%s@@gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        password = RandomStringUtils.randomAlphanumeric(10), password, "",
                        SignInUpAlertMessages.EMAIL_INVALID.getMessage()),
                arguments(6, String.format("%s@com", RandomStringUtils.randomAlphabetic(8)),
                        password = RandomStringUtils.randomAlphanumeric(10), password, "",
                        SignInUpAlertMessages.EMAIL_INVALID.getMessage()),
                arguments(7, String.format("%s_-test@gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        password = RandomStringUtils.randomAlphanumeric(10), password, "", "alert"),
                arguments(8, "admin", password = RandomStringUtils.randomAlphanumeric(10), password, "",
                        SignInUpAlertMessages.EMAIL_INVALID.getMessage()),
                arguments(9, String.format(" %s @gmail.com ", RandomStringUtils.randomAlphabetic(8)),
                        password = RandomStringUtils.randomAlphanumeric(10), password, "",
                        SignInUpAlertMessages.EMAIL_INVALID.getMessage()),
                arguments(10, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        password = RandomStringUtils.randomAlphanumeric(5), password, "", "alert"),
                arguments(11, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(10)),
                        password = RandomStringUtils.randomAlphanumeric(100), password, "", "alert"),
                arguments(12, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        password = String.format("  %s  ", RandomStringUtils.randomAlphabetic(8)), password,
                        "", "alert"),
                arguments(13, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(6)),
                        password = RandomStringUtils.randomAlphanumeric(10), password, "!free100@",
                        SignInUpAlertMessages.PROMOCODE_INVALID.getMessage()),
                arguments(14, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(6)),
                        password = RandomStringUtils.randomAlphanumeric(10), password, "promocode",
                        SignInUpAlertMessages.PROMOCODE_INVALID.getMessage()),
                arguments(15, email = String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        email, email, "", "alert"),
                arguments(16, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        password = RandomStringUtils.randomAlphanumeric(8), password.toUpperCase(), "",
                        SignInUpAlertMessages.PASSWORD_NOT_MATCH.getMessage()),
                arguments(17, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        password = RandomStringUtils.randomAlphanumeric(8), password.toLowerCase(), "",
                        SignInUpAlertMessages.PASSWORD_NOT_MATCH.getMessage()),
                arguments(18, "geraseva@tut.by", password = "vfhf1234", password, "", "alert")
        );
    }

    public static Stream<Arguments> signUpNotAllowedRegistrationTest() {
        String password;
        return Stream.of(
                arguments(1, "", password = RandomStringUtils.randomAlphanumeric(10), password, ""),
                arguments(2, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        password = "", password, ""),
                arguments(3, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        RandomStringUtils.randomAlphanumeric(8), "", "")
        );
    }

    //
    public static Stream<Arguments> signInInvalidCredentialsNegTest() {
        String email = "englishchenglish@gmail.com";
        String password = "testMenu777";
        return Stream.of(
                arguments(1, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(5)),
                        RandomStringUtils.randomAlphanumeric(10), "alert"),
                arguments(2, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(64)),
                       RandomStringUtils.randomAlphanumeric(10), "alert"),
                arguments(3, "@gmail.com", password = RandomStringUtils.randomAlphanumeric(10),
                        SignInUpAlertMessages.EMAIL_INVALID.getMessage()),
                arguments(4, String.format("%s.gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        RandomStringUtils.randomAlphanumeric(10), SignInUpAlertMessages.EMAIL_INVALID.getMessage()),
                arguments(5, String.format("%s@@gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        RandomStringUtils.randomAlphanumeric(10), SignInUpAlertMessages.EMAIL_INVALID.getMessage()),
                arguments(6, String.format("%s@com", RandomStringUtils.randomAlphabetic(8)),
                        RandomStringUtils.randomAlphanumeric(10), SignInUpAlertMessages.EMAIL_INVALID.getMessage()),
                arguments(7, String.format("%s_-test@gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        RandomStringUtils.randomAlphanumeric(10), "alert"),
                arguments(8, "admin", "admin", SignInUpAlertMessages.EMAIL_INVALID.getMessage()),
                arguments(9, String.format("%s @gmail.com ", RandomStringUtils.randomAlphabetic(8)),
                        RandomStringUtils.randomAlphanumeric(10), SignInUpAlertMessages.EMAIL_INVALID.getMessage()),
                arguments(10, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        RandomStringUtils.randomAlphanumeric(5), "alert"),
                arguments(11, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(10)),
                        RandomStringUtils.randomAlphanumeric(100), "alert"),
//                arguments(12, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(8)),
//                        String.format("  %s  ", RandomStringUtils.randomAlphabetic(8)), password,
//                        "", "alert"),
                arguments(15, email = String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        email, email, "", "alert"),
                arguments(16, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        password = RandomStringUtils.randomAlphanumeric(8), password.toUpperCase(), "",
                        SignInUpAlertMessages.PASSWORD_NOT_MATCH.getMessage()),
                arguments(17, String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(8)),
                        password = RandomStringUtils.randomAlphanumeric(8), password.toLowerCase(), "",
                        SignInUpAlertMessages.PASSWORD_NOT_MATCH.getMessage())
        );
    }
}
