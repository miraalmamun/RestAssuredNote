package https.reqres.in.POJO;

public class Details {
	
	
	private String companyName;
	private String emailId;
	
	
	public Details(String companyName, String emailId) {
		super();
		this.companyName = companyName;
		this.emailId = emailId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Details [companyName=" + this.companyName + ", emailId=" + this.emailId + "]";
	}

}
