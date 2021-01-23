package in.coder.foodplaza.pojo;

public class Login {
	private String email;
	private String pwd;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + pwd + "]";
	}
	
	
}
