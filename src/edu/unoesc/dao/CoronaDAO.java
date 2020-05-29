package edu.unoesc.dao;

import java.util.List;

import edu.unoesc.model.Corona;
import edu.unoesc.model.Pessoa;

public interface CoronaDAO {

	Corona getCoronaById (int id);
	List<Corona> getCoronas();
	boolean deleteCorona(int id);
	boolean insertCorona(Corona p);
	boolean updateCorona(Corona p);
	
}
