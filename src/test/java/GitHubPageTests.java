import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubPageTests {
    @BeforeAll
    static void configuration() {
        Configuration.browserSize = "1600х900";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void enterpriseTest() {
        open("https://github.com/");
        $("ul.d-lg-flex.list-style-none").$(byText("Solutions")).hover();
        $("a[href='/enterprise']").click();
        $("#hero-section-brand-heading").shouldHave(text("""
                The AI-powered
                developer platform.
                """));
    }
}
