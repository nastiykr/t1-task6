import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class T6CheckNotificationMessageTests extends BaseTest {

    private final SelenideElement link = $(byLinkText("Click here"));
    private final SelenideElement message = $(byId("flash"));

    /**
     * Перейти на страницу Notification Message.
     * После каждого неудачного клика закрывать всплывающее уведомление.
     * <p>
     * Добавить проверку, что всплывающее уведомление должно быть Successfull.
     * Если нет – провалить тест.
     *  @RepeatedTest. Выполнить тест 5 раз
     */
    @DisplayName("Notification message.")
    @RepeatedTest(value = 5, name = "Check successfull notification message. Repetition {currentRepetition} of {totalRepetitions}")
    public void test6CheckSuccessfullNotificationMessage() {

        open(BASE_URL + "notification_message_rendered");

        link.click();

        message.shouldHave(text("Action successful"));
        }
}
