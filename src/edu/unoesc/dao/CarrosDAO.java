package edu.unoesc.dao;

import java.util.List;

import edu.unoesc.model.Carro;

public interface CarrosDAO {

	Carro getCarrosById (int id);
	List<Carro> getCarros();
	boolean deleteCarros(int id);
	boolean insertCarros(Carro p);
	boolean updateCarros(Carro p);
	
}
