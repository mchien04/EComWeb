package vn.iostar.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import vn.iostar.model.Cart;
import vn.iostar.model.Category;
import vn.iostar.model.UserDtls;
import vn.iostar.service.CartService;
import vn.iostar.service.CategoryService;
import vn.iostar.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/")
	public String home() {
		return "user/home";
	}
	
	@ModelAttribute
	public void getUserDetails(Principal p, Model m) {
		if (p != null) {
			String email = p.getName();
			UserDtls userDtls = userService.getUserByEmail(email);
			m.addAttribute("user", userDtls);
		}
		List<Category> allActiveCategory = categoryService.getAllActiveCategory();
		m.addAttribute("categorys", allActiveCategory);
	}
	
	@GetMapping("/addCart")
	public String addToCart(@RequestParam Integer pid, @RequestParam Integer uid,HttpSession session) {
		Cart saveCart = cartService.saveCart(pid, uid);
		
		if (ObjectUtils.isEmpty(saveCart)) {
			session.setAttribute("errorMsg", "Product add to cart failed");
		}else {
			session.setAttribute("succMsg", "Product added to cart");
		}
		return "redirect:/product/" + pid;
	}
}
