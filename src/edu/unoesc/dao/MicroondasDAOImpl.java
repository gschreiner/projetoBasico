package edu.unoesc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.unoesc.model.Microondas;

@Repository
public class MicroondasDAOImpl implements MicroondasDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Microondas getMicroondasById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		
		Microondas micro = session.get(Microondas.class, id);
		
		return micro;
	}

	@Override
	@Transactional
	public List<Microondas> getMicroondas() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Microondas").list();
	}

	@Override
	@Transactional
	public boolean deleteMicroondas(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		
		Microondas micro = session.load(Microondas.class, id);
		if (micro != null) {
			session.delete(micro);
			return true;
		}
		
		return false;
	}

	@Override
	@Transactional
	public boolean insertMicroondas(Microondas p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(p);
		return true;
	}

	@Override
	@Transactional
	public boolean updateMicroondas(Microondas p) {
		Session session = this.sessionFactory.getCurrentSession();
		if (p != null) {
			session.update(p);
			return true;
		}
		return false;
	}

}
