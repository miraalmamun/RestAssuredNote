package pojo2;

public class GetCourse {
	
	/**
	 * instructor	:	RahulShetty
               url	:	rahulshettycademy.com
         services	:	projectSupport
       expertise	:	Automation
	   courses		{3}
	             webAutomation		[3]
	             api		[2]
	             mobile		[1]
       linkedIn	
	 */
	
	
	private String instructor;
	private String url;
	private String services;
	private String expertise;
	private Courses courses;
	private String linkedIn;

	
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public Courses getCourses() {
		return courses;
	}
	public void setCourses(Courses courses) {
		this.courses = courses;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	@Override
	public String toString() {
		return "GetCourse [instructor=" + this.instructor + ", url=" + this.url + ", services=" + this.services + ", expertise="
				+ this.expertise + ", courses=" + this.courses + ", linkedIn=" + this.linkedIn + "]";
	}
	
	
	
}
