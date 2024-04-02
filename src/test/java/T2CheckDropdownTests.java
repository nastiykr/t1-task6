import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class T2CheckDropdownTests extends BaseTest {



    /**
     * Перейти на страницу Dropdown.
     * Выбрать первую опцию, вывести в консоль текущий текст элемента dropdown,
     * выбрать вторую опцию, вывести в консоль текущий текст элемента dropdown.
     * <p>
     * Проверять корректное состояние каждого dropDown после каждого нажатия на него.
     */
    @Test
    public void test2CheckDropdown() {

        SelenideElement dropdown = $(byId("dropdown"));
        SelenideElement dropdownOption1 = $(byValue("1"));
        SelenideElement dropdownOption2 = $(byValue("2"));

        open(BASE_URL + "dropdown");

        dropdown.click();
        dropdownOption1.click();
        dropdownOption1.should(selected);
        dropdownOption2.should(not(selected));
        System.out.println("Text for dropdown - " + dropdown.getText());

        dropdown.click();
        dropdownOption2.click();
        dropdownOption1.should(not(selected));
        dropdownOption2.should(selected);
        System.out.println("Text for dropdown - " + dropdown.getText());
    }
}
