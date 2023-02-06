package day21;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserContext.StorageStateOptions;

public class SkipLogin {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		BrowserContext context = playwright.chromium().launch(setHeadless).newContext(
				new Browser.NewContextOptions().setStorageStatePath(Paths.get("auth.json"))
				);
		Page page = context.newPage();
		page.navigate("https://bookcart.azurewebsites.net/");
//		page.click("//span[text()='Login']/..");
//		page.locator("input[formcontrolname='username']").type("ortoni");
//		page.locator("input[formcontrolname='password']").type("Pass1234$");
//		page.locator("button[color='primary']").click();
		String userName = page.locator("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]")
				.textContent();
		String user = userName.split(" ")[1].split(" ")[0];
		System.out.println("User: "+user);
		// generate the auth
//		context.storageState(new StorageStateOptions().setPath(Paths.get("auth.json")));
		
		playwright.close();

		
		

	}

}
