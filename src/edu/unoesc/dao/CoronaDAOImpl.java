package edu.unoesc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unoesc.model.Corona;

@Service(value="CoronaDAO")
public class CoronaDAOImpl implements CoronaDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Corona getCoronaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Corona p = (Corona) session.get(Corona.class, new Integer(id));
		
		//System.out.println("nome: " + p.getNome());
		
		return p;
	}

	@Override
	@Transactional
	public List<Corona> getCoronas() {
		
		return this.sessionFactory.getCurrentSession().createQuery("from Corona").list();
	}

	@Override
	@Transactional
	public boolean deleteCorona(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Corona p = (Corona) session.load(Corona.class, new Integer(id));
		if (p!=null) {
			session.delete(p);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean insertCorona(Corona p) {
		
		this.sessionFactory.getCurrentSession().save(p);
		
		return false;
	}

	@Override
	@Transactional
	public boolean updateCorona(Corona p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		return true;
	}

}
