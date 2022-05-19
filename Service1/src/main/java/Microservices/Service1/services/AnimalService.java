package Microservices.Service1.services;

import Microservices.Service1.entities.Animal;
import Microservices.Service1.repos.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public void saveAnimal(Animal animal){
        animalRepository.save(animal);
    }

    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    public Animal findById(Long id) {
        return animalRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        animalRepository.deleteById(id);
    }
}


