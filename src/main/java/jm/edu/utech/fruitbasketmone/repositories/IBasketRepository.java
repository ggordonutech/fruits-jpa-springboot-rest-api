package jm.edu.utech.fruitbasketmone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import jm.edu.utech.fruitbasketmone.entities.Basket;

public interface IBasketRepository
       extends JpaRepository<Basket,Integer>  {

}
