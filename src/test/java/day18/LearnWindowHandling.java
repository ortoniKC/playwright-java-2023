package day18;

import java.util.List;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnWindowHandling {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(setHeadless).newPage();
		page.navigate("https://letcode.in/windows");
		
		
//		Page popup = page.waitForPopup(()->{
//			page.locator("id=home").click();
//		});
//		popup.waitForLoadState();
//		System.out.println("new tab: "+popup.title());
//		System.out.println("new tab: "+popup.url());
//		
//		popup.close();
//		page.close();
//		
//		playwright.close();
		
		page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(
				p-> p.context().pages().size() == 3
				), ()->{
			page.locator("id=multi").click();			
		});
		
		
		List<Page> pages = page.context().pages();
		for (Page tabs : pages) {
			tabs.waitForLoadState();
			System.out.println(tabs.url());
		}
		Page alertPage = pages.get(1);
		Page dropdownPage = pages.get(2);
		
		System.out.println("Alert page: "+alertPage.textContent("h1"));
		System.out.println("Dropdown page: "+dropdownPage.textContent("h1"));
		
		
		playwright.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
