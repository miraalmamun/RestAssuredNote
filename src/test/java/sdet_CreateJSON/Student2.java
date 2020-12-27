package sdet_CreateJSON;

import java.util.List;

public class Student2 {

	/**
	 * Serialization and Deserialization
	 */

	/**
	 * { "id": 1, "firstName": "Mir", "lastName": "Mamun", "email": "abc@gmail.com",
	 * "programme": "Manager", "courses": [ "Java", "Selenium" ]
	 * 
	 * }
	 */

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String programme;
	private List<String> courses;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public String getStudentRecord() {
		return (this.id + " " + this.firstName + " " + this.lastName + " " + this.email + " " + this.programme + " "
				+ this.courses);
	}

	@Override
	public String toString() {
		return "Student2 [id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", email=" + this.email
				+ ", programme=" + this.programme + ", courses=" + this.courses + "]";
	}

}
