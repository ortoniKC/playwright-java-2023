package day16;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.FileChooser;

public class LearnUploads {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(setHeadless).newPage();
		//		page.navigate("https://www.sendgb.com/");
		//		
		//		page.locator("button:has-text('Close') >> visible=true").click();
		//		page.locator("span:has-text('OK') >> visible=true").click();


		//		page.locator("input[type='file']").setInputFiles(new Path[] {
		//				Paths.get("sample.xlsx"),
		//				Paths.get("sec.xlsx")
		//		});

		page.navigate("https://the-internet.herokuapp.com/upload");
		FileChooser fileChooser = page.waitForFileChooser(()->{
			page.locator("id=drag-drop-upload").click();			
		});
		System.out.println(fileChooser.isMultiple());
		if(fileChooser.isMultiple()) {
			fileChooser.setFiles(new Path[] {
					Paths.get("sample.xlsx"),
					Paths.get("sec.xlsx")
			});

		}
		else System.out.println("only one");







	}

}
