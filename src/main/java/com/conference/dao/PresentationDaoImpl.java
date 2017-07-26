package com.conference.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.conference.entity.PresentAction;
import com.conference.entity.Presentation;
import com.conference.entity.User;
import com.conference.dao.AbstractDao;

@Repository
@Transactional
public class PresentationDaoImpl  implements PresentationDao {

	@PersistenceContext
	private EntityManager emf;
	
	
	@Override
	public List<Presentation> findAllPresentation() {
		List<Presentation> presentation = (List<Presentation>) emf.createQuery("select c from Presentation c").getResultList();	
		
		return presentation;
	}
	@Override
	public List<Presentation> findUserPresent(User user) {
		// TODO Auto-generated method stub
		
		List<Presentation> presentation = (List<Presentation>) emf.createQuery("select c from Presentation c  join c.user u where u.login= :login").setParameter("login", user.getLogin()).getResultList();	
				
		return presentation;
	}
	
	@Override
	public void deletePresent(String id) {
		emf.createQuery("delete c from Presentation c where c.id=:id").setParameter("id", Integer.parseInt(id));
		
	}
	@Override
	public void updatePresent(Presentation presentation) {				
			
		emf.merge(presentation);
		
	}
	@Override
	public Presentation findById(String id) {
		return (Presentation) emf.createQuery("select c from Presentation c where c.id=:id").setParameter("id", Integer.parseInt(id)).getSingleResult();
	}
	
	@Override
	public int checkPresent(Presentation presentation) {
		return emf.createQuery("select c from Presentation c  where c.schedule.start <= :start and c.schedule.enddt >= :end and c.room.number =:room ").setParameter("start", presentation.getSchedule().getStart()).setParameter("end", presentation.getSchedule().getEnd()).setParameter("room", presentation.getRoom().getNumber()).getResultList().size();	
	}
	@Override
	public void createPresent(Presentation presentation) {
		Presentation newPresentation=new Presentation();
		newPresentation.setName(presentation.getName());
		newPresentation.setDescription(presentation.getDescription());
		newPresentation.setUser(presentation.getUser());
		newPresentation.setSchedule(presentation.getSchedule());
		newPresentation.setRoom(presentation.getRoom());
		emf.persist(newPresentation);
		
	}


}
