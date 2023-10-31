package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.GitHubMainPage;
import pages.GitHubSearchPage;
import pages.RepositoriesPage;
import pages.WikiPage;


public class SelenideGitHubWikiTest extends BaseTest {
    private final static String GITHUB_URL = "https://github.com/";
    private final static String SEARCH_TEXT = "selenide";
    private final static String PAGE_WIKI = "SoftAssertions";
    private final static String EXPECTED_START_OF_CODE = "@ExtendWith({SoftAssertsExtension.class})";

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
        String resultSearch = wikiPage.isJUnit5ExamplePresent(EXPECTED_START_OF_CODE);

        Assertions.assertTrue(resultSearch.contains(EXPECTED_START_OF_CODE), "Длинный код JUnit5 не найден на странице.");
    }
}
