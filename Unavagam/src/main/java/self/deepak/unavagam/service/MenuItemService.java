package self.deepak.unavagam.service;

import java.util.List;

import self.deepak.unavagam.model.MenuItem;


public interface MenuItemService {

	public void saveOrUpdate(MenuItem menuItem);	
	public List<MenuItem> list();
	public MenuItem get(String id);
	public void delete(String id);
}
