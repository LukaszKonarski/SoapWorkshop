package pl.soapworkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.soapworkshop.repository.CategoryRepository;

@Controller
public class HomeController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public HomeController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    //Navbar resources
    @ModelAttribute
    public void addCategories(Model model) {
        model.addAttribute("categories", this.categoryRepository.findAllByIdGreaterThan(1));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String indexLoggedIn(Model model) {
        model.addAttribute("categories", this.categoryRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("categories", this.categoryRepository.findAll());
        return "login";
    }


}
