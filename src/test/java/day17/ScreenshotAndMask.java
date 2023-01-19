package day17;

import java.nio.file.Paths;
import java.util.Arrays;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ScreenshotCaret;

public class ScreenshotAndMask {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(setHeadless).newPage();
		page.navigate("https://github.com/ortoniKC/playwright-java-2023");
//		byte[] screenshot = page.screenshot();
		page.screenshot(new ScreenshotOptions().setPath(Paths.get("./snaps/img.png")));
		page.screenshot(new ScreenshotOptions().setPath(Paths.get("./snaps/full.png"))
				.setFullPage(true));
		Locator searchLocator = page.getByPlaceholder("Search");
		searchLocator.click();
		searchLocator.screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get("./snaps/initial.png"))
				.setCaret(ScreenshotCaret.INITIAL));
		searchLocator.screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get("./snaps/hide.png"))
				.setCaret(ScreenshotCaret.HIDE));
//		searchLocator.screenshot(new Locator.ScreenshotOptions()
//				.setPath(Paths.get("./snaps/hide.png"))
//				.setCaret(ScreenshotCaret.HIDE)
//				.setMask(Arrays.asList(searchLocator)));
		page.screenshot(new ScreenshotOptions()
				.setPath(Paths.get("./snaps/initial.png"))
				.setCaret(ScreenshotCaret.INITIAL)
				.setMask(Arrays.asList(searchLocator)));
		
		
		playwright.close();

	}

}
