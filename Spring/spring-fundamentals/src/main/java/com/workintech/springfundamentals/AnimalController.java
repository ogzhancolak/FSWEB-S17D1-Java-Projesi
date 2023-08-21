package com.workintech.springfundamentals;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {
    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("/animal")
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/animal/{id}")
    public Animal getAnimalId(@PathVariable int id) {
        return animals.get(id);
    }

    @PostMapping("/animal")
    public void addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
    }

    @PutMapping("/animal/{id}")
    public void updatedAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal) {
        animals.put(id, updatedAnimal);
    }

    @DeleteMapping("/animal/{id}")
    public void deleteAnimal(@PathVariable int id){
        animals.remove(id);
    }
}
