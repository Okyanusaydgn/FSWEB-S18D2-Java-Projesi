package com.workintech.S18D2.repository;

import com.workintech.S18D2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable,Long> {
    @Query(value = "SELECT * FROM fsweb.vegetable f order by f.price desc",nativeQuery = true)
    List<Vegetable> getByPriceDesc();

    @Query(value = "SELECT * FROM fsweb.vegetable f order by f.price asc",nativeQuery = true)
    List<Vegetable> getByPriceAsc();

    @Query(value = "SELECT f FROM Vegetable f WHERE f.name ILIKE %:name%", nativeQuery = false)
    List<Vegetable> searchByName(String name);
}
