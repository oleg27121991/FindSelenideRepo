package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.GitHubMainPage;
import pages.GitHubSearchPage;
import pages.RepositoriesPage;
import pages.WikiPage;

import static com.codeborne.selenide.Condition.text;


public class SelenideGitHubWikiTest extends BaseTest {
    private final static String GITHUB_URL = "https://github.com/";
    private final static String SEARCH_TEXT = "selenide";
    private final static String PAGE_WIKI = "SoftAssertions";
    private final static String EXPECTED_START_OF_CODE =
                         "@ExtendWith({SoftAssertsExtension.class})\n" +
                         "class Tests {\n" +
                         "@Test\n" +
                         "void test() {\n" +
                         "Configuration.assertionMode = SOFT;\n" +
                         "open(\"page.html\");\n" +
                         "$(\"#first\").should(visible).click();\n" +
                         "$(\"#second\").should(visible).click();\n" +
                         "}\n" +
                         "}\n";

    @Test
    public void testSoftAssertionsPageContainsJUnit5Example() {
        GitHubMainPage gitHubMainPage = new GitHubMainPage(GITHUB_URL);
        GitHubSearchPage gitHubSearchPage = new GitHubSearchPage();
        RepositoriesPage repositoriesPage = new RepositoriesPage();
        WikiPage wikiPage = new WikiPage();

        gitHubMainPage.search(SEARCH_TEXT);
        gitHubSearchPage.openRepositories(SEARCH_TEXT);
        repositoriesPage.openWikiPage();
        wikiPage.checkWikiPage(PAGE_WIKI);
        wikiPage.openPage(PAGE_WIKI);

        wikiPage.contentOnPage.shouldHave(text(EXPECTED_START_OF_CODE));
    }
}
