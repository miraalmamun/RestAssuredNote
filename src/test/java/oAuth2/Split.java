package oAuth2;

public class Split {

	public static void main(String[] args) {
		

		String url2 = "https://www.googleapis.com/oauth2/v4/token?code=4%2F0AfDhmriOcTyZYfiPKzGMTj9YDJJrnAcH55fXDFWKT7foe6Krgs8ffomMKz01CW5aA3duvA&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&client_secret=erZOWM9g3UtwNRj340YYaK_W&redirect_uri=https://rahulshettyacademy.com/getCourse.php&grant_type=authorization_code";
		String split[] = url2.split("code=");
		System.out.println(split.length);
		System.out.println(split[0]);
		System.out.println(split[1]);
		

	}

}
