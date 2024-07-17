package pizzera.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzera.model.PizzaModel;


public interface pizzaRepository  extends JpaRepository<PizzaModel, Integer>{

}
