import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class T5CheckHoversTests extends BaseTest {

    private final ElementsCollection pictures = $$(byClassName("figure"));
    private final ElementsCollection pictureText = $$(byClassName("figcaption"));

    /*
    1) setTimeout(function(){debugger;}, 4000)

    2) вариант с кликом мыши
    document.body.addEventListener('mousedown', () => {
    debugger;
    });

    3) вариант с пробелом
    document.body.addEventListener('keydown', (event) => {
    if (event.code === 'Space') {
    debugger;
    }
    });
    */


    /**
     * Перейти на страницу Hovers.
     * Навести курсор на каждую картинку.
     * Вывести в консоль текст, который появляется при наведении.
     * <p>
     * При каждом наведении курсора, проверить, что отображаемый текст совпадает с ожидаемым.
     * Выполнить тест с помощью @ParametrizedTest, в каждом тесте, указывая на какой элемент наводить курсор
     */
    @DisplayName("Checkboxes.")
    @ParameterizedTest(name = "Check checkboxes #{index}")
    @ValueSource(ints = {0, 1, 2})
    public void test5CheckHovers(int index) {

        open(BASE_URL + "hovers");

        pictures.get(index).hover();
        pictureText.get(index).shouldBe(visible).shouldHave(text("name: user" + (index + 1) + "\nView profile"));
        System.out.println("Text for picture with index " + index + ": \n" + pictures.get(index).hover().getText() + "\n-------------------");
    }
}
