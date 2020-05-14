package edu.unoesc.dao;

import java.util.List;

import edu.unoesc.model.Corona;

public interface CoronaDAO {

	Corona getCoronaById (int id);
	List<Corona> getCorona();
	boolean deleteCorona(int id);
	boolean insertCorona(Corona p);
	boolean updateCorona(Corona p);
	
}
