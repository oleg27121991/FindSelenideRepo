package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WikiPage {
    private final ElementsCollection pages = $$("[data-filterable-for='wiki-pages-filter'] li");
    private final SelenideElement linkMorePages = $(".wiki-more-pages-link");
    private final SelenideElement contentOnPage = $(".markdown-body");


    public void checkWikiPage(String pageName) {
        pages.shouldHave(itemWithText(pageName));
    }

    public void openPage(String pageName) {
        linkMorePages.scrollIntoView(true)
                .$("button").click();
        $(byText(pageName)).click();
        linkMorePages.shouldBe(Condition.visible);
    }

    public String isJUnit5ExamplePresent(String text) {
        String pageText = contentOnPage.getText();
        int codeStartIndex = pageText.indexOf(text);

        if (codeStartIndex != -1) {
            int codeEndIndex = pageText.indexOf("\n}", codeStartIndex) + 2;

            if (codeEndIndex != -1) {
                String code = pageText.substring(codeStartIndex, codeEndIndex);
                System.out.println(code);
                String xpath = ".//*[contains(text(), 'ExtendWith')]";
                contentOnPage.$x(xpath).scrollIntoView("{block: 'center'}");
                return code;
            }
        }

        Assertions.fail("Ожидаемое начало кода не найдено на странице.");
        return "";
    }
}
