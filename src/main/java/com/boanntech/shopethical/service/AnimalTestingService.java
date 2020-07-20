package com.boanntech.shopethical.service;

import com.boanntech.shopethical.model.DTO.AnimalTestingResult;
import com.boanntech.shopethical.model.DTO.AnimalTestingsSearchResult;
import com.boanntech.shopethical.model.templates.peta.PetaSearchResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class AnimalTestingService {

    private final WebClient petaCrueltyFree;


    public AnimalTestingService() {
        this.petaCrueltyFree = WebClient.builder().baseUrl("https://crueltyfree.peta.org/wp-json")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "https://crueltyfree.peta.org/wp-json"))
                .build();
    }

    public Collection<AnimalTestingsSearchResult> getAnimalProduct(String term){

        Collection<AnimalTestingsSearchResult> productList = new ArrayList<>();

        Collection<PetaSearchResult> results = getSearchResults(term).stream().filter(item -> "product".equals(item.getType())).collect(Collectors.toList());

        for(PetaSearchResult company : results)
        {
            productList.add(new AnimalTestingsSearchResult(String.valueOf(company.getId()),company.getValue()));
        }

        return productList;
    }

    public Collection<AnimalTestingsSearchResult> getAnimalCompany(String term){
        Collection<AnimalTestingsSearchResult> companyList = new ArrayList<>();

        Collection<PetaSearchResult> results = getSearchResults(term).stream().filter(item -> "company".equals(item.getType())).collect(Collectors.toList());

        for(PetaSearchResult company : results)
        {
            companyList.add(new AnimalTestingsSearchResult(String.valueOf(company.getId()),company.getValue()));
        }

        return companyList;
    }

    public AnimalTestingResult getPolicy(String id) throws IOException {
        String petaURL = "https://crueltyfree.peta.org/company/?p=";

        Document doc = Jsoup.connect(petaURL.concat(id)).get();

        String companyName = doc.select("#post-"+id+" > header > h2").select("span").last().text();
        String policy = doc.select("#post-"+id+" > header > div.testing-policy-text").text();



        return new AnimalTestingResult(id, companyName, policy);
    }

    public Collection<PetaSearchResult> getSearchResults(String term)
    {
        return this.petaCrueltyFree.get().uri(uriBuilder -> uriBuilder.path("/esearch/suggestions/")
                .queryParam("term", term).build())
                .retrieve().bodyToFlux(PetaSearchResult.class).collectList().block();
    }
}
