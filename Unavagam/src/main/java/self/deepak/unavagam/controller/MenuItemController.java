package self.deepak.unavagam.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import self.deepak.unavagam.model.MenuItem;
import self.deepak.unavagam.service.MenuItemService;

@Controller
public class MenuItemController {

	@Autowired
	private MenuItemService menuItemService;
	
	@RequestMapping(value="/menuItem", method=RequestMethod.GET)
	public ModelAndView getMenuItems(){		
		System.out.println("********In MENU ITEM CONTROLLER Get Menu Item Method");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject(new MenuItem());
		modelAndView.addObject("listOfItem", this.menuItemService.list());
		modelAndView.setViewName("items");
		return modelAndView;
	}
	
	//handler to add new menu Item
	@RequestMapping(value = "/addNewMenuItem", method = RequestMethod.POST)
	public ModelAndView addProduct(@Valid @ModelAttribute("menuItem") MenuItem menuItem,BindingResult result) {
		System.out.println("********In MENU ITEM CONTROLLER Add Menu Item Method");
		System.out.println(menuItem);
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {

			modelAndView.setViewName("items");
			modelAndView.addObject("listOfItem", this.menuItemService.list());
			} else {

			menuItemService.saveOrUpdate(menuItem);
			modelAndView.addObject("menuItem",new MenuItem());
			modelAndView.addObject("listOfItem", this.menuItemService.list());
			modelAndView.setViewName("items");
			
		}
		return modelAndView;
	}
	
	//List all the Menu Items
	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public List<MenuItem> listProduct() {
		System.out.println("********In MENU ITEM CONTROLLER List All Item Method");
		List<MenuItem> listOfItem  =  this.menuItemService.list();		
		return listOfItem;
	}
}
