package com.stroer.assessment.amazon.search.model;

public class ItemPrice {

    private String currency;

    private Double value;

    public ItemPrice(String itemCost){
       this.currency = itemCost.substring(0,1);
       this.value = Double.valueOf(itemCost.substring(1));
    }

    public String getCurrency() {
        return currency;
    }

    public Double getValue() {
        return value;
    }

}
