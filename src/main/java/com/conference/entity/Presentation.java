package com.conference.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.conference.entity.User;



@Entity
@Table(name = "\"PRESENTATION\"", schema = "public")
public class Presentation {
	
	@Id 
	@GeneratedValue
    private Long id;
	private String name;
	private String description;
	@PrimaryKeyJoinColumn
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "presentation")
	private Room room;
	@PrimaryKeyJoinColumn
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "presentation")
	private Schedule schedule;
	

	
	@Column(name = "ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "\"USER_PRESENTATION\"", schema = "public", joinColumns = {
			@JoinColumn(name = "USER_ID", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "PRESENTATION_ID",
					nullable = false, updatable = false) })
	
	private Set<User> user;

	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}	
}
