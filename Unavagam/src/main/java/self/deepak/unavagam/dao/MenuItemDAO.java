package self.deepak.unavagam.dao;

import java.util.List;

import self.deepak.unavagam.model.MenuItem;

public interface MenuItemDAO {

	public void saveOrUpdate(MenuItem menuItem);	
	public List<MenuItem> list();
	public MenuItem get(String id);
	public void delete(String id);

}
