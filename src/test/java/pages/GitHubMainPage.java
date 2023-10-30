package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class GitHubMainPage {
    private final SelenideElement buttonOpenSearchField = $(".header-search-button");
    private final SelenideElement inputSearchField = $("input[name='query-builder-test']");

    public GitHubMainPage(String url) {
        open(url);
    }

    public void search(String text) {
        buttonOpenSearchField.click();
        inputSearchField.setValue(text);
        inputSearchField.pressEnter();
    }
}
