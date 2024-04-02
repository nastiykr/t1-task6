import org.junit.jupiter.api.AfterEach;

import static com.codeborne.selenide.Selenide.closeWindow;

public class BaseTest {
    public static final String BASE_URL = "https://the-internet.herokuapp.com/";


    @AfterEach
    public void tearDown() {
        closeWindow();
    }
}
