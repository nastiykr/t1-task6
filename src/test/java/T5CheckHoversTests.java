import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class T5CheckHoversTests extends BaseTest{

    /**
     * Перейти на страницу Hovers.
     * Навести курсор на каждую картинку.
     * Вывести в консоль текст, который появляется при наведении.
     * <p>
     * При каждом наведении курсора, проверить, что отображаемый текст совпадает с ожидаемым.
     * Выполнить тест с помощью @ParametrizedTest, в каждом тесте, указывая на какой элемент наводить курсор
     */
    @Test
    public void test5CheckHovers() {
        ElementsCollection pictures = $$(byClassName("figure"));

        open(BASE_URL + "hovers");

        pictures.forEach(picture -> {
            picture.hover().should(text(" "));
            System.out.println("Text for picture: \n" + picture.hover().getText() + "\n-------------------");
        });
    }
}
