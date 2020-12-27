package serialization;

public class Api {

	private String courseTitle;
	private int price;
	public Api(String courseTitle, int price) {
		super();
		this.courseTitle = courseTitle;
		this.price = price;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Api [courseTitle=" + this.courseTitle + ", price=" + this.price + "]";
	}
	

}
