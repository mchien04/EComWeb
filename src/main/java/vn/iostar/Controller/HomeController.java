package vn.iostar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iostar.model.Category;
import vn.iostar.model.Product;
import vn.iostar.repository.ProductRepository;
import vn.iostar.service.CategoryService;
import vn.iostar.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/products")
	public String products(Model m) {
		List<Category> categories = categoryService.getAllActiveCategory();
		List<Product> products = productService.getAllActiveProducts();
		m.addAttribute("categories", categories);
		m.addAttribute("products", products);
		return "product";
	}
	
	@GetMapping("/product")
	public String product() {
		return "view_product";
	}
}
