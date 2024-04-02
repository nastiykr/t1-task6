import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class T1CheckboxesTests extends BaseTest {

    /**
     * Перейти на страницу Checkboxes.
     * Выделить первый чекбокс, снять выделение со второго чекбокса.
     * Вывести в консоль состояние атрибута checked для каждого чекбокса.
     * <p>
     * Проверять корректное состояние каждого чекбокса после каждого нажатия на него.
     * Запустить тест с помощью @ParametrizedTest, изменяя порядок нажатия на чекбоксы с помощью одного параметра.
     */
    @ParameterizedTest(name = "Check checkboxes #{index}")
    @ValueSource(ints = {0, 1})
    public void test1CheckCheckboxes(int indicator) {

        ElementsCollection checkboxes = $$(byAttribute("type", "checkbox"));

        open(BASE_URL + "checkboxes");

        if (indicator == 0) {
            checkboxes.get(0).click();
            checkboxes.get(0).should(selected);

            checkboxes.get(1).should(selected);
        } else {
            checkboxes.get(1).click();
            checkboxes.get(1).should(not(selected));

            checkboxes.get(0).should(not(selected));
        }
    }
}
