package pojo2;

public class Api {
	
	private String courseTitle;
	private String price;
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Api [courseTitle=" + this.courseTitle + ", price=" + this.price + "]";
	}

	
}
