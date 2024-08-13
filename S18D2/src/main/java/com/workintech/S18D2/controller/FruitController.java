package com.workintech.S18D2.controller;

import com.workintech.S18D2.dto.FruitResponse;
import com.workintech.S18D2.entity.Fruit;
import com.workintech.S18D2.service.FruitService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fruit")

public class FruitController {

    private final FruitService fruitService;

     @GetMapping
     public List<Fruit> get() {
         return fruitService.getByPriceAsc();
     }

    @GetMapping("/desc")
    public List<Fruit> getDesc() {
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public Fruit get(@Positive @PathVariable long id) {
        return new FruitResponse("get by id succeed!",fruitService.getById(id)).fruit();
    }

    @GetMapping("/name/{name}")
    public List<Fruit> get(@Size(min = 2, max = 45,message = "name size must be between 2 to 45") @PathVariable String name) {
        return fruitService.searchByName(name);
    }


    @PostMapping
    public Fruit save(@Validated @RequestBody Fruit fruit){
         return fruitService.save(fruit);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@Positive @PathVariable Long id){
         return fruitService.delete(id);
    }


}
