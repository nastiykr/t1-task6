import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class T6CheckNotificationMessageTests extends BaseTest {

    /**
     * Перейти на страницу Notification Message.
     * После каждого неудачного клика закрывать всплывающее уведомление.
     * <p>
     * Добавить проверку, что всплывающее уведомление должно быть Successfull.
     * Если нет – провалить тест.
     *  @RepeatedTest. Выполнить тест 5 раз
     */
    @Test
    public void test6CheckNotificationMessage() {

        SelenideElement link = $(byLinkText("Click here"));
        SelenideElement message = $(byId("flash"));
        SelenideElement messageCloseButton = $(byClassName("close"));

        open(BASE_URL + "notification_message_rendered");

        link.click();
        while (!message.getText().contains("Action successful")) {
            messageCloseButton.click();
            link.click();
        }
    }
}
