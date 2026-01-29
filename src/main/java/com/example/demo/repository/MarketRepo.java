package com.example.demo.repository;

import com.example.demo.model.Market;

import java.util.List;

public interface MarketRepo {

    List<Market> getAllEquities();

    Market getEquityByid(long id);

    Market saveEquity(Market saveEquity);


}
