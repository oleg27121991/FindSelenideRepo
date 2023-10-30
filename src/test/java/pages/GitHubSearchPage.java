package pages;

import com.codeborne.selenide.ElementsCollection;


import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSearchPage {
    private final ElementsCollection searchResult = $$("div[data-testid='results-list'] div");
    public void openRepositories(String text) {
        searchResult.shouldHave(itemWithText(text));
        searchResult.first().$("a").click();
    }
}
