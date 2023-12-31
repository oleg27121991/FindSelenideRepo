package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WikiPage {
    private final ElementsCollection pages = $$("[data-filterable-for='wiki-pages-filter'] li");
    private final SelenideElement linkMorePages = $(".wiki-more-pages-link");
    public final SelenideElement contentOnPage = $(".markdown-body");


    public void checkWikiPage(String pageName) {
        pages.shouldHave(itemWithText(pageName));
    }

    public void openPage(String pageName) {
        linkMorePages.scrollIntoView(true)
                .$("button").click();
        $(byText(pageName)).click();
        linkMorePages.shouldBe(Condition.visible);
    }
}
