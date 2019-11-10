import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import reporting.ReplaceCamelCase;

//@DisplayName("")
@DisplayNameGeneration(ReplaceCamelCase.class)
public class Template {

//    @ParameterizedTest(name = " #{}")
//    @CsvSource({
//            "1, ' ', ' '",
//            "2, ' ', ' '"
//    })
//    @Step("")
//    @Description("")
//    public void signUpPositiveTestWithRegisterButton() {
//
//    }


}
