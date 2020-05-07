package edu.unoesc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.unoesc.model.Carro;

@Repository
public class CarrosDAOImpl implements CarrosDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Carro getCarrosById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Carro> getCarros() {
		return sessionFactory.getCurrentSession().createQuery("from Carro").list();
	}

	@Override
	@Transactional
	public boolean deleteCarros(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean insertCarros(Carro p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(p);
		return true;
	}

	@Override
	@Transactional
	public boolean updateCarros(Carro p) {
		// TODO Auto-generated method stub
		return false;
	}

}
