package com.conference.service;

import java.util.List;

import com.conference.entity.PresentAction;
import com.conference.entity.Presentation;
import com.conference.entity.User;

public interface PresentationService {
	
	List<Presentation> findAllPresentation();
	List<Presentation> findUserPresent(User user);
	void deletePresent(String id);
	void updatePresent(Presentation presentation);
	void createPresent(Presentation presentation);
}
