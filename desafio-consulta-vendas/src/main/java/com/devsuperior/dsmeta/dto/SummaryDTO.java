package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

public class SummaryDTO {

    private String name;
    private Double amount;

    public SummaryDTO(String name, Double amount) {
        this.name = name;
        this.amount = amount;
    }

    public SummaryDTO(Sale entity) {
        name = entity.getSeller().getName();
        amount = entity.getAmount();
    }

    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }
}
