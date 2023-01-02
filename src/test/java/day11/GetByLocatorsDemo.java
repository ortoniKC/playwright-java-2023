package day11;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class GetByLocatorsDemo {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(setHeadless).newPage();
		page.navigate("https://bookcart.azurewebsites.net/");
		
		page.getByText("Login").click();
		page.getByLabel("Username").fill("ortoni");
		page.getByLabel("Password").fill("Pass1234$");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
				.setName("Login")).last().click();
		page.getByPlaceholder("Search books", new Page.GetByPlaceholderOptions()
				.setExact(true)).type("The Hookup");
		page.getByRole(AriaRole.OPTION).first().click();
		page.getByAltText("Book cover image").click();
		System.out.println(page.url());	
		
	
		
		playwright.close();
		
		
		
		

	}

}
