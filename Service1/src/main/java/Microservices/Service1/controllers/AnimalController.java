package Microservices.Service1.controllers;


import Microservices.Service1.entities.Animal;
import Microservices.Service1.services.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @PostMapping("/animals")
    public ResponseEntity<String> add(@RequestBody Animal animal){
        Optional.ofNullable(animal).orElseThrow(NullPointerException::new);
        animalService.saveAnimal(animal);
        return new ResponseEntity<>("Added successfully", HttpStatus.OK);
    }

    @GetMapping("/animals")
    public List<Animal> getAll(){
        return animalService.getAnimals();
    }

    @GetMapping("/animals/{id}")
    public Animal getAnimalById(@PathVariable Long id){
        return animalService.findById(id);
    }

    @DeleteMapping("/animals/{id}")
    public void deleteById(@PathVariable Long id){
        animalService.deleteById(id);
    }


}
