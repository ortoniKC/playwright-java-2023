package day4;

import java.util.List;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.SelectOptionOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class LearnDropdown {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(headless).newPage();
		page.navigate("https://letcode.in/dropdowns");
//		page.selectOption("#fruits", "3");
		Locator fruitsDD = page.locator("#fruits");
//		fruitsDD.selectOption("1");
//		fruitsDD.selectOption(new SelectOption().setLabel("Apple"));
		fruitsDD.selectOption(new SelectOption().setIndex(4), 
				new SelectOptionOptions().setForce(false));
		String textContent = page.locator("p.subtitle").textContent();
		System.out.println(textContent);
		
		Locator heros = page.locator("id=superheros");
		heros.selectOption(new String[] {"ta", "bp", "am"});
		
		
		Locator langDD = page.locator("#lang");
		Locator options = langDD.locator("option");
		List<String> allInnerTexts = options.allInnerTexts();
		allInnerTexts.forEach(i-> System.out.println(i));
		int count = options.count();
		System.out.println("len: "+count);
		langDD.selectOption(new SelectOption().setIndex(count-1));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		playwright.close();
		

	}

}
