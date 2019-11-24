package common;

import assertions.ExtendedAssertions;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import reporting.LogInstance;
import reporting.TestListener;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@ExtendWith(TestListener.class)
@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {

    public ExtendedAssertions assertions;
    public Logger log = LogInstance.getLogger();

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        Configuration.timeout = 12000;
        Configuration.startMaximized = true;
        log = LogInstance.setContext(testInfo);
        assertions = new ExtendedAssertions();
        log.info(String.format("%s setUp", testInfo.getDisplayName()));
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        log.info(String.format("%s tearDown", testInfo.getDisplayName()));
    }
}
