import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class T7CheckAddRemoveElementsTests extends BaseTest{

    /**
     * Перейти на страницу Add/Remove Elements.
     * <p>
     * Запустить тест три раза,используя @TestFactory,
     * меняя количество созданий (кнопка Add Element) и удалений (нажимать на разные кнопки Delete) на 2:1, 5:2, 1:3 соответственно.
     * <p>
     * Проверять, что на каждом шагу остается видимым ожидаемое количество элементов.
     */
    @TestFactory
    @DisplayName("Check inputs positive cases")
    public void test7CheckAddRemoveElements() {

        SelenideElement addElementButton = $(byText("Add Element"));
        ElementsCollection deleteButtons = $$(byClassName("added-manually"));

        open(BASE_URL + "add_remove_elements/");

        int attempts = 0;

        while (attempts < 5) {
            addElementButton.click();
            attempts++;
        }

        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            $(byClassName("added-manually"), rand.nextInt(attempts - i)).click();

            deleteButtons.forEach(deleteButton -> {
                System.out.println("Text for picture: " + deleteButton.getText());
            });
        }
    }

    private List<String> testDataCollectorForPositiveCases(int size) {
        Random rand = new Random();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            result.add(String.valueOf(rand.nextInt(10000) + 1));
        }

        return result;
    }
}
