package day9;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RecordVideo {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = browserType.launch(headless);
		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
				.setRecordVideoDir(Paths.get("videos/"))
				.setRecordVideoSize(1280, 720));
		Page page = context.newPage();
		page.navigate("https://bookcart.azurewebsites.net/");
		page.click("//span[text()='Login']/..");
		page.locator("input[formcontrolname='username']").type("ortoni");
		page.locator("input[formcontrolname='password']").type("Pass1234$");
		page.locator("button[color='primary']").click();
		String userName = page.locator("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]").textContent();
		System.out.println(userName.split(" ")[1].split(" ")[0]);
		context.close();
		playwright.close();

	}

}
