package pizzeria.it.pizzamvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzeria.it.pizzamvc.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

  List<Pizza> findBynomeContaining(String nome);

}
