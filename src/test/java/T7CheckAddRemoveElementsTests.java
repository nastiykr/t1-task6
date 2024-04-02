import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class T7CheckAddRemoveElementsTests extends BaseTest{

    SelenideElement addElementButton = $(byText("Add Element"));
    ElementsCollection deleteButtons = $$(byClassName("added-manually"));

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
    public List<DynamicTest> test7CheckAddRemoveElements() {

        List<DynamicTest> result = new ArrayList<>();
        List<Integer> countClickAddList = Arrays.asList(2, 5, 1);
        List<Integer> countClickDeleteList = Arrays.asList(1, 2, 3);

        for (int i = 0; i < countClickAddList.size(); i++) {
            final int index = i;
            result.add(
                    DynamicTest.dynamicTest(
                            "Dynamic test #" + i,
                            () -> {
                                open(BASE_URL + "add_remove_elements/");
                                System.out.println("count click add - " + countClickAddList.get(index));
                                System.out.println("------------------------------------------------------ ");
                                clickAddButton(countClickAddList.get(index));
                                System.out.println("------------------------------------------------------ ");
                                System.out.println("count click delete - " + countClickDeleteList.get(index));
                                System.out.println("------------------------------------------------------ ");
                                clickDeleteButton(countClickDeleteList.get(index));
                                checkCountElementsAfterAddAndDelete(countClickAddList.get(index), countClickDeleteList.get(index));
                            }
                    )
            );
        }

        return result;
    }

    @Step("Click Add button")
    private void clickAddButton(int countClickAdd) {
        for (int i = 1; i <= countClickAdd; i++) {
            System.out.println("click add number - " + i);
            addElementButton.click();
        }
        deleteButtons.should(size(countClickAdd));
    }

    @Step("Click delete button")
    private void clickDeleteButton(int countClickDelete) {
        for (int i = 1; i <= countClickDelete; i++) {
            Random rand = new Random();
            System.out.println("click delete number - " + i);
            deleteButtons.get(rand.nextInt(deleteButtons.size() - i)).click();
        }
    }

    @Step("Check count elements after add and delete")
    private void checkCountElementsAfterAddAndDelete(int countClickAdd, int countClickDelete) {
        try {
            deleteButtons.should(size(countClickAdd - countClickDelete));
        } catch (AssertionError e) {
            throw new AssertionError("Количество оставшихся элементов после добавления и удаления не соответствует ожидаемому");
        }
    }
}
