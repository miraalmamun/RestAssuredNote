package https.reqres.in.POJO;

public class UsersRequest {
	/*
	 * {
    "name": "morpheus",
    "job": "leader",
    "id": "42",
    "createdAt": "2020-12-26T21:11:55.137Z"
}
	 * 
	 */
	
	private String name;
	private String job;
	private String id;
	private String createdAt;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "UsersRequest [name=" + this.name + ", job=" + this.job + ", id=" + this.id + ", createdAt=" + this.createdAt + "]";
	}
	
	

}
