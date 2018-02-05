package net.imran.backendproject.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.imran.backendproject.dao.CategoryDAO;
import net.imran.backendproject.dto.Category;

@Repository("CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// adding some dummy data for testing purpose
	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();
		// Adding first category
		category.setId(1);
		category.setName("smartphone");
		category.setDescription("this is some discription for smartphone");
		category.setImageURL("CAT_1.png");
		categories.add(category);

		// adding second category

		category = new Category();
		category.setId(2);
		category.setName("laptop");
		category.setDescription("this is some discription for laptop");
		category.setImageURL("CAT_2.png");
		categories.add(category);

		// adding third category
		category = new Category();
		category.setId(3);
		category.setName("tablet");
		category.setDescription("this is some discription for tablet");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// enchance for loop
		for (Category category : categories) {
			if (category.getId() == id)
				return category;
		}
		return null;
	}

	@Override
	public boolean add(Category category) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
