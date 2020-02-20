package com.gorila.cdi.restservice;

import java.util.List;

public class Response {
    public Response(List<Price> prices) {
        this.prices = prices;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    private List<Price> prices;

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Response{");
        for (Price p :prices){
            buffer.append(p.getDate()+":"+p.getPrice());
            buffer.append(";\n");
        }
        buffer.append("}");
        return buffer.toString();
    }
}
