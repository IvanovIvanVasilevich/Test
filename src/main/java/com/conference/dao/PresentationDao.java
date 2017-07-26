package com.conference.dao;

import java.util.List;

import com.conference.entity.PresentAction;
import com.conference.entity.Presentation;
import com.conference.entity.User;

public interface PresentationDao {
	
	List<Presentation> findAllPresentation();

	List<Presentation> findUserPresent(User user);
	
	void deletePresent(String id);

	void updatePresent(Presentation presentation);
	
	Presentation findById(String id);
	int checkPresent (Presentation presentation);
	void createPresent(Presentation presentation);
	

}
