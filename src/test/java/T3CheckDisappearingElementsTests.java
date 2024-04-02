import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class T3CheckDisappearingElementsTests extends  BaseTest{

    private final ElementsCollection elements = $$(byCssSelector("li a"));

    /**
     * Перейти на страницу Disappearing Elements.
     * Добиться отображения 5 элементов, максимум за 10 попыток, если нет, провалить тест с ошибкой.
     * <p>
     * Для каждого обновления страницы проверять наличие 5 элементов.
     * @RepeatedTest.
     */

    @DisplayName("Disappearing elements.")
    @RepeatedTest(value = 10, name = "Search 5 elements. Repetition {currentRepetition} of {totalRepetitions}")
    public void test3CheckDisappearingElements() {

        open(BASE_URL + "disappearing_elements");

        elements.should(CollectionCondition.size(5));
    }
}
