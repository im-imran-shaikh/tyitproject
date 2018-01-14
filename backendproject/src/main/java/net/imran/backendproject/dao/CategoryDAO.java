package net.imran.backendproject.dao;

import java.util.List;

import net.imran.backendproject.dto.Category;

public interface CategoryDAO {
	
	 List<Category> list();
	Category get(int id);

}
