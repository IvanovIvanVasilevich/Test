package com.conference.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conference.dao.PresentationDao;
import com.conference.entity.PresentAction;
import com.conference.entity.Presentation;
import com.conference.entity.User;

@Service
public class PresentationServiceImpl implements PresentationService {
	
	@Autowired
	PresentationDao presentationDao;


	@Override
	public List<Presentation> findAllPresentation() {
		// TODO Auto-generated method stub
		return presentationDao.findAllPresentation();
	}

	@Override
	public List<Presentation> findUserPresent(User user) {
		// TODO Auto-generated method stub
		return presentationDao.findUserPresent(user);
	}

	@Override
	public void deletePresent(String id) {
		presentationDao.deletePresent(id);
		
	}

	@Override
	public void updatePresent(Presentation presentation) {
		
		if(presentation.getSchedule()!=null&&presentation.getRoom()!=null)
		presentationDao.checkPresent(presentation);
		
		presentationDao.updatePresent(presentation);
		
	}

	@Override
	public void createPresent(Presentation presentation) {
		// TODO Auto-generated method stub
		if(presentation.getSchedule().getStart()!=null&&presentation.getSchedule().getEnd()!=null&&presentation.getRoom().getNumber()!=null)		
			if (presentationDao.checkPresent(presentation)!=0);
					presentationDao.createPresent(presentation);
	}

}
