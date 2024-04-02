import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class T4CheckInputsTests extends BaseTest {

    private final SelenideElement input = $(byAttribute("type", "number"));

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

        List<DynamicTest> result = new ArrayList<>();
        List<String> testData = testDataCollectorForPositiveCases(10);

        for (int i = 0; i < testData.size(); i++) {
            open(BASE_URL + "inputs");
            final int index = i;
            result.add(
                    DynamicTest.dynamicTest(
                            "Dynamic test with value [" + testData.get(index) + "]",
                            () -> {
                                System.out.println("Value for input element - [" + testData.get(index) + "]");
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
    public Stream<DynamicTest> test4CheckInputsNegativeCases() {

        List<String> testData = testDataCollectorForNegativeCases();

        Stream<DynamicTest> result = testData.stream().map(value ->
            DynamicTest.dynamicTest(
                    "Dynamic test with value [" + value + "]",
                    () -> {
                        open(BASE_URL + "inputs");

                        System.out.println("Value for input element - [" + value + "]");
                        input.type(value);

                        if (value.trim().matches("\\d+")) {
                            input.should(value(value.trim()));
                        } else {
                            input.should(empty);
                        }
                    }
            ));

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

        return result;
    }
}
