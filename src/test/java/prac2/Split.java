package prac2;

public class Split {

	public static void main(String[] args) {

		String s = "https://rahulshettyacademy.com/getCourse.php?state=mirmamun&code=4%2F0AY0e-g6FqPVLnYKKX5nSrLvZFoBpznOdoSLh6SCqsc9l7aQvI_w6xOQwG51UsNW1dv25Mw&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";

		String code = s.split("code=")[1].split("&scope=")[0];
		System.out.println(code);

	}

}
