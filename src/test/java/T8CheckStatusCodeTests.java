import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class T8CheckStatusCodeTests extends BaseTest {

    /**
     * Перейти на страницу Status Codes.
     * Кликнуть на каждый статус в новом тестовом методе, вывести на экран текст после перехода на страницу статуса.
     * <p>
     * Добавить роверку, что переход был осуществлен на страницу с корректным статусом.
     */

    @DisplayName("Status code.")
    @ParameterizedTest
    @ValueSource(strings = {"200", "301", "404", "500"})
    public void test8CheckStatusCode(String statusCode) {
        open(BASE_URL + "status_codes");

        $(byLinkText(statusCode)).click();

        $(byTagName("p")).shouldHave(Condition.text(statusCode));
        System.out.println("Text after going to the status page: " + $(byTagName("p")).getText());
    }
}
