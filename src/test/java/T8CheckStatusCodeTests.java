import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
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
    @ParameterizedTest
    @ValueSource(strings = {"200", "301", "404", "500"})
    public void test8CheckStatusCode(String statusCode) {
        open(BASE_URL + "status_codes");
        $(byLinkText(statusCode)).click();
        System.out.println("Text after going to the status page: " + $(byTagName("p")).getText());
        $(byTagName("p")).shouldHave(Condition.text(statusCode));
    }
}
