package com.example.lab22;

public class Stock {
    public String getStockName() {
        return stockName;
    }

    public String getStockPrice() {
        return stockPrice;
    }

    String stockName;
    String stockPrice;

    public Stock(String stockName, String stockPrice){
        this.stockName=stockName;
        this.stockPrice=stockPrice;
    }

}
