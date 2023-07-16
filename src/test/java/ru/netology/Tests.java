package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Tests {

    @Test
    public void testByFields() {
        open("http://localhost:9999/");
//        SelenideElement form = $(".App_appContainer");
        SelenideElement form = $(By.id("root"));
        form.$("[data-test-id = name] input").setValue("Александр Александров");
        form.$("[data-test-id = phone] input").setValue("+71111234567");
        form.$("[data-test-id = agreement]").click();
        form.$("button").click();
        $("[data-test-id = order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
