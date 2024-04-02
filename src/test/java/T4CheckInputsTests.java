import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class T4CheckInputsTests extends BaseTest {

    /**
     * Перейти на страницу Inputs.
     * Ввести любое случайное число от 1 до 10 000.
     * Вывести в консоль значение элемента Input.
     * <p>
     * Проверить, что в поле ввода отображается именно то число, которое было введено.
     * Повторить тест 10 раз, используя @TestFactory, с разными значениями, вводимыми в поле ввода.
     * Создать проверку негативных кейсов (попытка ввести в поле латинские буквы, спецсимволы, пробел до и после числа).
     */

    @TestFactory
    @DisplayName("Check inputs positive cases")
    public List<DynamicTest> test4CheckInputsPositiveCases() {

        SelenideElement input = $(byAttribute("type", "number"));
        List<DynamicTest> result = new ArrayList<>();
        List<String> testData = testDataCollectorForPositiveCases(10);

        open(BASE_URL + "inputs");

        for (int i = 0; i < testData.size(); i++) {
            final int index = i;
            result.add(
                    DynamicTest.dynamicTest(
                            "Dynamic test #" + i,
                            () -> {
                                System.out.println("Value for input element - " + testData.get(index));
                                input.val(testData.get(index));
                                input.should(value(testData.get(index)));
                            }
                    )
            );
        }

        return result;
    }

    @TestFactory
    @DisplayName("Check inputs negative cases")
    public List<DynamicTest> test4CheckInputsNegativeCases() {

        SelenideElement input = $(byAttribute("type", "number"));
        List<DynamicTest> result = new ArrayList<>();
        List<String> testData = testDataCollectorForNegativeCases();

        open(BASE_URL + "inputs");

        for (int i = 0; i < testData.size(); i++) {
            final int index = i;
            result.add(
                    DynamicTest.dynamicTest(
                            "Dynamic test #" + i,
                            () -> {
                                System.out.println("Value for input element - " + testData.get(index));
                                input.sendKeys(testData.get(index));

                                if ((testData.get(index)).matches("^d+$")) {
                                    input.should(value(testData.get(index)));
                                } else {
                                    input.should(empty);
                                }
                            }
                    )
            );
        }

        return result;
    }

    private List<String> testDataCollectorForPositiveCases(int size) {
        Random rand = new Random();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            result.add(String.valueOf(rand.nextInt(10000) + 1));
        }

        return result;
    }

    private List<String> testDataCollectorForNegativeCases() {
        List<String> result = new ArrayList<>();

        result.add("abc");
        result.add("!@#");
        result.add(" 123");
        result.add("123 ");
        result.add("   ");
        result.add("");
        result.add(null);

        return result;
    }
}
