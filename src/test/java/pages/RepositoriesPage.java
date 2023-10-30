package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class RepositoriesPage {
    private final SelenideElement linkWiki = $("#wiki-tab");

    public void openWikiPage() {
        linkWiki.click();
    }
}
