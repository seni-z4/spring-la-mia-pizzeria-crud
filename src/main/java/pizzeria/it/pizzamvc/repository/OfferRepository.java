package pizzeria.it.pizzamvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzeria.it.pizzamvc.model.Offer;

public interface OfferRepository extends JpaRepository<Offer, Integer> {

}
