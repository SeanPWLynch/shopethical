package com.boanntech.shopethical.controller;

import com.boanntech.shopethical.model.DTO.AnimalTestingResult;
import com.boanntech.shopethical.model.DTO.AnimalTestingsSearchResult;
import com.boanntech.shopethical.service.AnimalTestingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collection;

@RestController
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AnimalTestingController {

    private AnimalTestingService animalTestingService;

    public AnimalTestingController(AnimalTestingService animalTestingService) {
        this.animalTestingService = animalTestingService;
    }

    @GetMapping("/animaltesting/product/{term}")
    public Collection<AnimalTestingsSearchResult> getAnimalProduct(@PathVariable String term)
    {
        return animalTestingService.getAnimalProduct(term);
    }

    @GetMapping("/animaltesting/company/{term}")
    public Collection<AnimalTestingsSearchResult> getAnimalCompany(@PathVariable String term)
    {
        return animalTestingService.getAnimalCompany(term);
    }

    @GetMapping("/animaltesting/policy/{id}")
    public AnimalTestingResult getPolicy(@PathVariable String id) throws IOException {
        return animalTestingService.getPolicy(id);
    }
}
