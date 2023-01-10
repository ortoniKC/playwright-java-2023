package day14;

import java.util.List;
import java.util.regex.Pattern;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnFrames {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(setHeadless).newPage();
		page.navigate("https://letcode.in/frame");
		
		FrameLocator frameLocator = page.frameLocator("#firstFr");
		frameLocator.getByPlaceholder("Enter name").type("Koushik");
		frameLocator.getByPlaceholder("Enter email").type("jasondans");
		FrameLocator childFrame = frameLocator.frameLocator("iframe.has-background-white");
		childFrame.getByPlaceholder("Enter email").type("koushik244");
		
//		List<Frame> frames = page.frames();
//		System.out.println(frames.size());
//		
//		Frame frame = page.frame("firstFr");
//		frame.getByPlaceholder("Enter name").type("Koushik");
//		frame.getByPlaceholder("Enter email").type("Chatterjee");
//		
//		List<Frame> childFrames = frame.childFrames();
//		System.out.println(childFrames.size());
//		childFrames.forEach(f->{
//			System.out.println(f.url());
//		});
//		
////		Frame innerFrame = page.frameByUrl("https://letcode.in/innerFrame");
//		Frame innerFrame = page.frameByUrl(Pattern.compile("innerFrame"));
//		innerFrame.getByPlaceholder("Enter email").type("koushik@mail.com");
//		frame.getByPlaceholder("Enter email").fill("letcode");
//		
		Thread.sleep(5000);
		playwright.close();
		
	}

}
