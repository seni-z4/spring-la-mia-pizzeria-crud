package pizzera.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

//import com.example.demo.model.PizzaModel;
import pizzera.model.PizzaModel;

import jakarta.validation.Valid;
import pizzera.model.PizzaModel;
import pizzera.repository.pizzaRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/pizzeria")
public class pizzaController {

    private static final Logger logger = LoggerFactory.getLogger(pizzaController.class);

	@Autowired
	private pizzaRepository pizzaRepo;

	@GetMapping("/menu")
	public String Index(Model model) {

		List<PizzaModel> pizze = pizzaRepo.findAll();

		model.addAttribute("pizze", pizzaRepo.findAll());

		return "/pizzeria/index";
	}

	@GetMapping("/dettaglio/{id}")
	public String dettaglioPizza(@PathVariable("id") Integer id, Model model) {

		model.addAttribute("dettaglio", pizzaRepo.getReferenceById(id));

		return "/pizzeria/dettaglio";
	}

	@GetMapping("/create")
	public String create(Model model) {

		model.addAttribute("pizza", new PizzaModel());

		return "pizzeria/create";
	}

	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("pizza") PizzaModel pizza, BindingResult bindingresult, Model model) {
		// TODO: process POST request

		if (bindingresult.hasErrors()) {
			return "pizzeria/create";
		}
		pizzaRepo.save(pizza);

		return "redirect:/pizzeria/menu";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {

		model.addAttribute("pizza", pizzaRepo.findById(id).get());

		return "/pizzeria/edit";
	}


    @PostMapping("/edit/{id}")
    public String update(
            @Valid @ModelAttribute("pizza") PizzaModel pizza,
            BindingResult bindingResult,
            @PathVariable("id") Integer id,
            Model model) {

//        logger.info("Entering update method for pizza id: " + id);

        if (bindingResult.hasErrors()) {
//            logger.error("Binding errors occurred: " + bindingResult.getAllErrors());
            return "/pizzeria/edit";
        }

//        pizza.setId(id); // Ensure the ID is set correctly
//        logger.info("Saving pizza: " + pizza);
        pizzaRepo.save(pizza);
//        logger.info("Pizza saved successfully: " + pizza);

        return "redirect:/pizzeria/menu";
    }
    
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        //TODO: process POST request
    	
        pizzaRepo.deleteById(id);
        
    	return "redirect:/pizzeria/menu";
    }
    

}
