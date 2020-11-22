package oAuth2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Oauth2_Test {

	@Test
	public void simple() throws Exception {
    /*
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(
				"https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
		driver.findElement(By.cssSelector("")).sendKeys("miralmamuna", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("")).sendKeys("Chanchal@Pabna00?", Keys.ENTER);
		String url = driver.getCurrentUrl();
*/
		 String url = "https://rahulshettyacademy.com/getCourse.php?state=mirmamun&code=4%2F0AY0e-g6FqPVLnYKKX5nSrLvZFoBpznOdoSLh6SCqsc9l7aQvI_w6xOQwG51UsNW1dv25Mw&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";
		String partialcode = url.split("code=")[1];
		String code = partialcode.split("&scope")[0];
		System.out.println(code);

		String accessTokenResponse = given().urlEncodingEnabled(false).log().all().queryParam("code", code)
				.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParam("grant_type", "authorization_code").when()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();
		System.out.println("=========  " + accessTokenResponse);
		JsonPath jsp = new JsonPath(accessTokenResponse);
		String accessToken = jsp.getString("access_token");

		String responseBody = given().queryParam("access_token", accessToken).when()
				.get("https://rahulshettyacademy.com/getCourse.php").asString();
		System.out.println(responseBody);

	}

}
