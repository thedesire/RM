package self.deepak.unavagam.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import self.deepak.unavagam.dao.MenuItemDAO;
import self.deepak.unavagam.model.MenuItem;
import self.deepak.unavagam.service.MenuItemService;

@Service
public class MenuItemServiceImpl implements MenuItemService {

	@Autowired
	private MenuItemDAO menuItemDAO;
	
	
	@Transactional
	public void saveOrUpdate(MenuItem menuItem) {
		menuItemDAO.saveOrUpdate(menuItem);
	}


	@Override
	public List<MenuItem> list() {
		return menuItemDAO.list();
	}


	@Override
	public MenuItem get(String id) {
		return menuItemDAO.get(id);
	}


	@Override
	public void delete(String id) {
		menuItemDAO.delete(id);
		
	}
}
