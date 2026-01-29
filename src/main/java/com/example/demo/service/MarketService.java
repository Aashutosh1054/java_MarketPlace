package com.example.demo.service;

import com.example.demo.model.Market;

import java.util.List;

public interface MarketService {
    List<Market> getAllEquities();

    Market getEquityByid(long id);

    Market saveEquity(Market saveEquity);


}
