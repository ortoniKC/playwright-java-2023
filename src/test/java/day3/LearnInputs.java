package day3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnInputs {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
					new BrowserType.LaunchOptions()
					.setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://letcode.in/edit");
		page.locator("#fullName").type("Koushik C");
		Locator locator = page.locator("#join");
		locator.press("End");
		locator.type(" man");
		locator.press("Tab");
		page.type("#fullName", "Koushik C");
		String value = page.locator("id=getMe").getAttribute("value");
		System.out.println(value);
		page.locator("(//label[text()='Clear the text']/following::input)[1")
		.clear();
	}

}
