package day12;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnLocators {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(setHeadless).newPage();
		page.navigate("https://letcode.in/test");
		page.click("'Click'");
		page.click("text=Click");
		page.locator("button:has-text('Goto Home')").click();
		page.locator("nav :text('Product')").click();		
		page.navigate("http://127.0.0.1:5500/allText/index.html");
		page.locator("//button[@class='btn btn-primary'] visible=true").click();
		page.locator("button").locator("nth=1").click();
		System.out.println(page.locator("#attach").textContent());
		page.locator("button").locator("nth=-1").click();
		Thread.sleep(1000);
		System.out.println(page.locator("#attach").textContent());
		
		page.locator("#innerText, #innerText2").click();
		page.locator("//button[text()='Inner Text'] | //button[text()='Inner Text 1']").click();
		playwright.close();

		

	}

}
