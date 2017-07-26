package com.conference.entity;

import java.sql.Timestamp;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "\"SCHEDULE\"", schema = "public")
public class Schedule {
	
	@Id 
	@GeneratedValue
    private Long scheduleId;
	private String name;
	private String description;
	
	@OneToOne
	@JoinColumn(name = "presentation_id")
	private Presentation presentation;
	
	private Timestamp start;
	private Timestamp enddt;
	
	@Column(name = "SCHEDULE_ID")
	public Long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
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
	
		
	@Column(name="\"START\"", insertable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public  Timestamp  getStart() {
		return start;
	}
	public void setStart(Timestamp start) {
		this.start = start;
	}
	
	@Column(name="\"END\"", insertable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getEnd() {
		return enddt;
	}
	public void setEnd(Timestamp enddt) {
		this.enddt = enddt;
	}
	
	
	

}
