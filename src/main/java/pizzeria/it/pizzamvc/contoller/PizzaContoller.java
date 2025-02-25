package pizzeria.it.pizzamvc.contoller;

import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import pizzeria.it.pizzamvc.model.Pizza;
import pizzeria.it.pizzamvc.repository.PizzaRepository;

@Controller
public class PizzaContoller {

  @Autowired
  private PizzaRepository pizzaRepo;

  @GetMapping("/pizza")
  public String index(Model model) {
    List<Pizza> pizzeria = pizzaRepo.findAll();
    model.addAttribute("pizza", pizzeria);
    return "index";
  }

  @GetMapping("/pizza/{id}")
  public String show(@PathVariable("id") Integer id, Model model) {
    model.addAttribute("pizza", pizzaRepo.findById(id).get());
    return "show";
  }

  @GetMapping("/pizza/filted-by")
  public String findbynome(@RequestParam(name = "nome") String name, Model model) {
    model.addAttribute("pizza", pizzaRepo.findBynomeContaining(name));
    return "index";
  }

  @GetMapping("/pizza/create")
  public String create(Model model) {
    model.addAttribute("pizza", new Pizza());
    return "/create";
  }

  @PostMapping("/pizza/create")
  public String store(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors()) {
      return "create";
    }

    pizzaRepo.save(pizza);

    return "redirect:/pizza";
  }

  @GetMapping("pizza/edit/{id}")
  public String update(@PathVariable("id") Integer id, Model model) {
    model.addAttribute("pizza", pizzaRepo.findById(id).get());
    return "update";

  }

  @PostMapping("/pizza/edit/{id}")
  public String updateEdit(@Valid @ModelAttribute("pizza") Pizza pizza,
      BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors()) {
      return "create";
    }

    pizzaRepo.save(pizza);

    return "redirect:/pizza";
  }

  @PostMapping("/pizza/delete/{id}")
  public String delete(@PathVariable("id") Integer id) {
    Pizza pizza = pizzaRepo.findById(id).get();

    pizzaRepo.delete(pizza);
    return "redirect:/pizza";
  }

}
