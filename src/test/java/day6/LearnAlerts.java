package day6;

import java.util.function.Consumer;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

//
//class MyDialog implements Consumer<Dialog>{
//
//	@Override
//	public void accept(Dialog dialog) {
//		System.out.println(dialog.message());
//		String defaultValue = dialog.defaultValue();
//		System.out.println(defaultValue);
//		dialog.accept("Koushik");	
//	}
//	
//}

public class LearnAlerts {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Page page = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setHeadless(false)).newPage();
		page.navigate("https://letcode.in/alert");

		Consumer<Dialog> alert = new Consumer<Dialog>() {
			public void accept(Dialog dialog) {
				System.out.println(dialog.message());
				String defaultValue = dialog.defaultValue();
				System.out.println(defaultValue);
				dialog.dismiss();
				page.offDialog(this);
			}
		};
		page.onDialog(alert);


		//		Consumer<Dialog> alert = dialog-> {
		//				System.out.println(dialog.message());
		//				String defaultValue = dialog.defaultValue();
		//				System.out.println(defaultValue);
		//				dialog.accept("Koushik");	
		//			};

//		page.onDialog(dialog-> {
//			System.out.println(dialog.message());
//			dialog.dismiss();
//			//			page.offDialog(this);
//		});

		page.locator("#accept").click();

		page.onDialog(a->{
			String defaultValue = a.message();
			System.out.println(defaultValue);
			a.accept("Koushik");	
		});
		page.locator("id=prompt").click();
		System.out.println(page.locator("#myName").textContent());

	}

}
