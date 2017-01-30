package self.deepak.unavagam.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import self.deepak.unavagam.dao.MenuItemDAO;
import self.deepak.unavagam.model.MenuItem;

@Repository
public class MenuItemDAOImpl implements MenuItemDAO {

	@Autowired
	public SessionFactory sessionFactory;
	
	public MenuItemDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void saveOrUpdate(MenuItem menuItem) {
		System.out.println("********In Menu Item DAO SaveOrUpdate Method");
		sessionFactory.getCurrentSession().saveOrUpdate(menuItem);
	}
	
	@Transactional
	public List<MenuItem> list() {
		
		@SuppressWarnings("unchecked")
		List<MenuItem> listOfItem =(List<MenuItem>) sessionFactory.getCurrentSession().createCriteria(MenuItem.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		System.out.println("********In Menu Item DAO List Method");
		return listOfItem;
	}
	
	@Transactional
	public MenuItem get(String id) {
		System.out.println("********In Menu Item DAO get Method");
		String hql="FROM MenuItem WHERE id = " + "'" + id + "'";
		Query query=(Query) sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<MenuItem> listOfItem = query.list();
		if(listOfItem!= null && !listOfItem.isEmpty()) {
			return listOfItem.get(0);
		}
		
		return null;
	}
	
	@Transactional
	public void delete(String id) {
		System.out.println("********In Menu Item DAO delete Method");
		MenuItem itemToDelete = new MenuItem();
		itemToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(itemToDelete);
		
	}
	
/*		
	@Transactional
	public List <MenuItem> getByCategoryId(String category)
	{
		String hql="from MenuItem where category  =" + "'" + category + "'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);				
		List<MenuItem> listOfItem = query.list();
		
		if(listOfItem!= null && !listOfItem.isEmpty()) {
			return listOfItem;
			
		}
		return null;
	}

	
	*/

}
