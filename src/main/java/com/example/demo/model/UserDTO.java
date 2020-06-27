package com.example.demo.model;

public class UserDTO {

    private String username;
    
    private String email;
    
    private String name;
    
	private String password;

	public String getUsername() {
		return username;
    }
    
    public String getEmail() {
		return email;
    }

    public String getName() {
		return name;
    }
    

    public void setName(String username) {
		this.name = username;
    }
    
    public void setEmail(String username) {
		this.email = username;
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
}