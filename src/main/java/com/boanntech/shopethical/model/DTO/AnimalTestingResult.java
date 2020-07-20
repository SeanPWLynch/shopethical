package com.boanntech.shopethical.model.DTO;

public class AnimalTestingResult extends AnimalTestingsSearchResult{

    private String policy;


    public AnimalTestingResult(String id, String name, String policy) {
        super(id, name);
        this.policy = policy;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }
}
