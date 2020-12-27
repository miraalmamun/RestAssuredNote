package sdet_CreateJSON;

import java.util.List;

public class Stdnt {
	/*
	 * { "id": 101, "firstName": "Vernon", "lastName": "Harper", "email":
	 * "egestas.rhoncus.Proin@massaQuisqueporttitor.org", "programme":
	 * "Financial Analysis", "courses": [ "Accounting", "Statistics" ] }
	 */

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String programme;
	private List<String> courses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Stdnt() {
		// super();

	}

	public Stdnt(int id, String firstName, String lastName, String email, String programme, List<String> courses) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.programme = programme;
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Stdnt [id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", email="
				+ this.email + ", programme=" + this.programme + ", courses=" + this.courses + "]";
	}

}
