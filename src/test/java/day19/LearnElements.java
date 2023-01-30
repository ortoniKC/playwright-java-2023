package day19;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;

public class LearnElements {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(setHeadless).newPage();
		page.navigate("https://letcode.in/elements");
		page.getByPlaceholder("Enter your").type("ortonikc");
		page.locator("id=search").click();
		Locator links = page.locator("ol li a");
		links.last().waitFor(new Locator.WaitForOptions()
				.setState(WaitForSelectorState.ATTACHED)
				.setTimeout(20000));
		int count = links.count();
		System.out.println("Count: "+count);
		for (int i = 0; i < count; i++) {
			String textContent = links.nth(i).textContent();
			System.out.println(textContent);
		}
		
			
		playwright.close();

	}

}
