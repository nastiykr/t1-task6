import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class T1CheckboxesTests extends BaseTest {

    ElementsCollection checkboxes = $$(byAttribute("type", "checkbox"));

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
    public void test11CheckCheckboxes(int index) {

        open(BASE_URL + "checkboxes");

        boolean currentState = isCheckboxSelected(index);

        checkboxes.get(index).click();

        checkCheckboxSelected(currentState, index);
    }

    @ParameterizedTest(name = "Check checkboxes #{index}")
    @ValueSource(booleans = {true, false})
    public void test12CheckCheckboxes(boolean isNaturalOrder) {

        open(BASE_URL + "checkboxes");

        //boolean currentState = isCheckboxSelected(index);

        //checkboxes.get(index).click();

        //checkCheckboxSelected(currentState, index);
    }


    @Step("Проверка, выбран ли чекбокс с индексом {index}")
    public boolean isCheckboxSelected(int index) {
        return checkboxes.get(index).isSelected();
    }

    @Step("Проверка, что состояние чекбокса с индексом {index} изменилось")
    public void checkCheckboxSelected(boolean currentState, int index) {
        if (currentState) {
            checkboxes.get(index).should(not(selected));
        } else {
            checkboxes.get(index).should(selected);
    }
}
}

