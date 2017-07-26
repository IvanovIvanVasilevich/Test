package com.conference.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "\"ROOM\"", schema = "public")
public class Room {
	
	
	@Id
	@GeneratedValue
    private Long roomId;
	private Integer number;
	private String description;
	
	@OneToOne
	@JoinColumn(name = "presentation_id")
	private Presentation presentation;
	
	
	
//	public Long getRoomId() {
//		return roomId;
//	}
//	public void setRoomId(Long roomId) {
//		this.roomId = roomId;
//	}
	@Column(name = "NUMBER")
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Presentation getPresentation() {
		return presentation;
	}
	public void setPresentation(Presentation presentation) {
		this.presentation = presentation;
	}
	

}
