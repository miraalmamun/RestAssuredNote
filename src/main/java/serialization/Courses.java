package serialization;

import java.util.List;

public class Courses {
	
	private List<WebAutomation> webAutomation;
	private List<Api> api;
	private List<Mobile> mobile;
	
	
	public Courses(List<WebAutomation> webAutomation, List<Api> api, List<Mobile> mobile) {
		super();
		this.webAutomation = webAutomation;
		this.api = api;
		this.mobile = mobile;
	}
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<Api> getApi() {
		return api;
	}
	public void setApi(List<Api> api) {
		this.api = api;
	}
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Courses [webAutomation=" + this.webAutomation + ", api=" + this.api + ", mobile=" + this.mobile + "]";
	}
	

}
