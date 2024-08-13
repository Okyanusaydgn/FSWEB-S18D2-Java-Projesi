package com.workintech.S18D2.repository;

import com.workintech.S18D2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository  extends JpaRepository<Fruit, Long> {

    @Query(value = "SELECT f.id, f.name, f.price, f.fruit_type FROM fsweb.fruit f order by f.price desc",nativeQuery = true)
    List<Fruit> getByPriceDesc();

    @Query(value = "SELECT f.id, f.name, f.price, f.fruit_type FROM fsweb.fruit f order by f.price asc",nativeQuery = true)
    List<Fruit> getByPriceAsc();

    @Query(value = "SELECT f FROM Fruit f WHERE f.name ILIKE %:name%", nativeQuery = false)
    List<Fruit> searchByName(String name);
}

