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
    private final static String CHECK_TEXT = "JUnit5";
    @Test
    public void testSoftAssertionsPageContainsJUnit5Example() {
        GitHubMainPage gitHubMainPage = new GitHubMainPage(GITHUB_URL);
        gitHubMainPage.search(SEARCH_TEXT);
        GitHubSearchPage gitHubSearchPage = new GitHubSearchPage();
        gitHubSearchPage.openRepositories(SEARCH_TEXT);
        RepositoriesPage repositoriesPage = new RepositoriesPage();
        repositoriesPage.openWikiPage();
        WikiPage wikiPage = new WikiPage();
        wikiPage.checkWikiPage(PAGE_WIKI);
        wikiPage.openPage(PAGE_WIKI);
        String result = wikiPage.checkHaveExample();

        Assertions.assertTrue(result.contains(CHECK_TEXT));
    }
}
