package day20;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.setDefaultAssertionTimeout;


public class LearnAssertion {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(setHeadless).newPage();
		page.navigate("https://letcode.in/edit");
		Locator header = page.locator("h1");
		
		setDefaultAssertionTimeout(10000);
		assertThat(page).hasTitle("Interact with Input fields");
		assertThat(page).hasURL("https://letcode.in/edit");
		assertThat(header).hasText("Input");
		assertThat(page.locator("#join")).hasAttribute("value", "I am good");
		
		assertThat(page.locator("#join")).hasValue("I am good");
		
		page.navigate("https://letcode.in/radio");
		assertThat(page.locator("#notfoo")).isChecked();

		playwright.close();

	}

}
