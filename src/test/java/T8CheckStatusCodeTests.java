import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

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
     * Добавить Проверку, что переход был осуществлен на страницу с корректным статусом.
     */
    @Test
    public void test81CheckStatusCode() {
        open(BASE_URL + "status_codes");
        $(byLinkText("200")).click();
        System.out.println("Text after going to the status page: " + $(byTagName("p")).getText());
    }

    /**
     * Перейти на страницу Status Codes.
     * Кликнуть на каждый статус в новом тестовом методе, вывести на экран текст после перехода на страницу статуса.
     * <p>
     * Добавить Проверку, что переход был осуществлен на страницу с корректным статусом.
     */
    @Test
    public void test82CheckStatusCode() {
        open(BASE_URL + "status_codes");
        $(byLinkText("301")).click();
        System.out.println("Text after going to the status page: " + $(byTagName("p")).getText());
    }

    /**
     * Перейти на страницу Status Codes.
     * Кликнуть на каждый статус в новом тестовом методе, вывести на экран текст после перехода на страницу статуса.
     * <p>
     * Добавить Проверку, что переход был осуществлен на страницу с корректным статусом.
     */
    @Test
    public void test83CheckStatusCode() {
        SelenideElement textOnPage = $(byTagName("p"));

        open(BASE_URL + "status_codes");

        $(byLinkText("404")).click();
        textOnPage.should(text("404"));
        System.out.println("Text after going to the status page: " + textOnPage.getText());
    }

    /**
     * Перейти на страницу Status Codes.
     * Кликнуть на каждый статус в новом тестовом методе, вывести на экран текст после перехода на страницу статуса.
     * <p>
     * Добавить Проверку, что переход был осуществлен на страницу с корректным статусом.
     */
    @Test
    public void test84CheckStatusCode() {
        open(BASE_URL + "status_codes");
        $(byLinkText("500")).click();
        System.out.println("Text after going to the status page: " + $(byTagName("p")).getText());
    }

}
