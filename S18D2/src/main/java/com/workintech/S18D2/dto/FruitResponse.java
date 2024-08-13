package com.workintech.S18D2.dto;

import com.workintech.S18D2.entity.Fruit;

public record FruitResponse(String message, Fruit fruit) {
}
