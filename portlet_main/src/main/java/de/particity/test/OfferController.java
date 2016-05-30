package de.particity.test;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.liferay.portal.kernel.transaction.Transactional;

import de.particity.model.Offer;

@Repository
//@Named
@Transactional(readOnly=true)
public class OfferController implements Serializable {

	@PersistenceContext
    private EntityManager entityManager;
	
	//@Inject 
	//private SessionFactory sessionFactory;
	 
    public List<Offer> getOffers() {
    	
    	//Criteria crit = sessionFactory.getCurrentSession().createCriteria(Offer.class);
    	//return crit.list();
    	//} else
    	//	return null;
		Query q = entityManager.createQuery("SELECT o from Offer o");
		return (List<Offer>) q.getResultList();
    }
 
    @Transactional
    public void delete(Offer offer) {
        //sessionFactory.getCurrentSession().delete(offer);
    }
    
    @Transactional
    public void create(Offer offer) {
        //sessionFactory.getCurrentSession().save(offer);
    }
    
    @Transactional
    public void update(Offer offer) {
        //sessionFactory.getCurrentSession().update(offer);
    }
    
    //@Autowired
    //public void setSessionFactory(SessionFactory factory) {
    //	this.sessionFactory = sessionFactory;
    //}
	
}
