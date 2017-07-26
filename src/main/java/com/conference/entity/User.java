package com.conference.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;
import com.conference.entity.Presentation;

@Entity
@Table(name = "\"USER\"", schema = "public")
public class User {
	
	@Id 
	@GeneratedValue
	private Long id;
    private String login;
    private String name;
    private String role;
    private String password;
    
    @ManyToMany(mappedBy = "user")
    private Set<Presentation> presentation;
   
    
	
    @Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "login")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "role")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Presentation> getPresentation() {
		return presentation;
	}
	public void setPresentation(Set<Presentation> presentation) {
		this.presentation = presentation;
	}
	
}
