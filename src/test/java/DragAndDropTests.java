import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {
    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1600х900";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void changeNodesTest() {
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
