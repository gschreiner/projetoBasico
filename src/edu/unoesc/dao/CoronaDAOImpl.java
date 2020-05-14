package edu.unoesc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import edu.unoesc.model.Corona;

public class CoronaDAOImpl implements CoronaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Corona getCoronaById(int id) {

		return sessionFactory.getCurrentSession().get(Corona.class, id);
	}

	@Override
	@Transactional
	public List<Corona> getCorona() {
		return sessionFactory.getCurrentSession().createQuery("FROM Corona").list();
	}

	@Override
	public boolean deleteCorona(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean insertCorona(Corona p) {
		if (p == null)
			return false;

		sessionFactory.getCurrentSession().save(p);
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@Transactional
	public boolean updateCorona(Corona p) {
		sessionFactory.getCurrentSession().update(p);

		return true;
	}

}
