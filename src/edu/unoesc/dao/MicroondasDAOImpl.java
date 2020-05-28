package edu.unoesc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unoesc.model.Microondas;

@Service(value="MicroondasDAO")
public class MicroondasDAOImpl implements MicroondasDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Microondas getMicroondasById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Microondas p = (Microondas) session.get(Microondas.class, new Integer(id));
		
		//System.out.println("nome: " + p.getNome());
		
		return p;
	}

	@Override
	@Transactional
	public List<Microondas> getMicroondas() {
		
		return this.sessionFactory.getCurrentSession().createQuery("from Microondas").list();
	}

	@Override
	@Transactional
	public boolean deleteMicroondas(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Microondas p = (Microondas) session.load(Microondas.class, new Integer(id));
		if (p!=null) {
			session.delete(p);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean insertMicroondas(Microondas p) {
		
		this.sessionFactory.getCurrentSession().save(p);
		
		return false;
	}

	@Override
	@Transactional
	public boolean updateMicroondas(Microondas p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		return true;
	}

}
