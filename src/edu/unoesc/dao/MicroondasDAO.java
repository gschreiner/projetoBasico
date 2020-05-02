package edu.unoesc.dao;

import java.util.List;

import edu.unoesc.model.Microondas;

public interface MicroondasDAO {

	Microondas getMicroondasById (int id);
	List<Microondas> getMicroondas();
	boolean deleteMicroondas(int id);
	boolean insertMicroondas(Microondas p);
	boolean updateMicroondas(Microondas p);
	
}
