package dad.javafx.dogs.client.message;

public class Message {

	private String status;
	private String code;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public boolean isSuccess() {
		return getStatus().equals("success");
	}

}
