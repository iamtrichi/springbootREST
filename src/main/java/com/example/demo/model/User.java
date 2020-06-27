package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
    private String username;
    
    @Column
    private String email;
    
    @Column
    private String name;
    
	@Column
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