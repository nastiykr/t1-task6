import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class T1CheckboxesTests extends BaseTest {

    private final ElementsCollection checkboxes = $$(byAttribute("type", "checkbox"));

    /**
     * Перейти на страницу Checkboxes.
     * Выделить первый чекбокс, снять выделение со второго чекбокса.
     * Вывести в консоль состояние атрибута checked для каждого чекбокса.
     * <p>
     * Проверять корректное состояние каждого чекбокса после каждого нажатия на него.
     * Запустить тест с помощью @ParametrizedTest, изменяя порядок нажатия на чекбоксы с помощью одного параметра.
     */
    @DisplayName("Check checkboxes.")
    @ParameterizedTest(name = "Check checkboxes #{index}")
    @ValueSource(ints = {0, 1})
    public void test11CheckCheckboxes(int index) {

        open(BASE_URL + "checkboxes");

        boolean currentState = isCheckboxSelected(index);

        checkboxes.get(index).click();

        checkCheckboxSelected(currentState, index);
    }

    @DisplayName("Check checkboxes.")
    @ParameterizedTest(name = "Check checkboxes when natural order is {0}")
    @ValueSource(booleans = {true, false})
    public void test12CheckCheckboxes(boolean isNaturalOrder) {

        open(BASE_URL + "checkboxes");
        checkOrder(isNaturalOrder);

    }

    @Step("Order of passage by element")
    public void checkOrder(boolean isNaturalOrder) {
        if (isNaturalOrder) {
            for (int i = 0; i < checkboxes.size(); i++) {
                boolean currentState = isCheckboxSelected(i);
                checkboxes.get(i).click();
                checkCheckboxSelected(currentState, i);
            }
        } else {
            for (int i = checkboxes.size() - 1; i >= 0; i--) {
                boolean currentState = isCheckboxSelected(i);
                checkboxes.get(i).click();
                checkCheckboxSelected(currentState, i);
            }
        }
    }

    @Step("Check if the checkbox with index is selected {index}")
    public boolean isCheckboxSelected(int index) {
        System.out.println("Element state " + index + " before click - " + checkboxes.get(index).isSelected());
        return checkboxes.get(index).isSelected();
    }

    @Step("Checking the status of the checkbox with index {index}")
    public void checkCheckboxSelected(boolean currentState, int index) {

        System.out.println("Element state" + index + " after click - " + checkboxes.get(index).isSelected());
        System.out.println("------------------------------------------");

        if (currentState) {
            checkboxes.get(index).should(not(selected));
        } else {
            checkboxes.get(index).should(selected);
        }
    }
}

