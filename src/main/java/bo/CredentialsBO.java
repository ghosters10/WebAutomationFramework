package bo;

public class CredentialsBO {
	
	private String username;
	private String password;
	private String expectedError;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getExpectedError() {
		return expectedError;
	}

	public void setExpectedError(String expectedError) {
		this.expectedError = expectedError;
	}

	@Override
	public String toString() {
		return "CredentialsBO [username=" + username + ", password=" + password + ", expectedError=" + expectedError
				+ "]";
	}

}
