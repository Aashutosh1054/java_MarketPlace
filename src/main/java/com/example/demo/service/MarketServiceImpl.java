package com.example.demo.service;

import com.example.demo.entity.MarketEntity;
import com.example.demo.model.Market;
import com.example.demo.repository.MarketJPARepository;
import com.example.demo.repository.MarketRepoImpl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.ArrayList;

@Service
public class MarketServiceImpl implements MarketService {

    // private final MarketRepoImpl repository;
    private final MarketJPARepository repository;

    public MarketServiceImpl(MarketJPARepository repository) {
        this.repository = repository;
    }

    public static Market toModel(MarketEntity me){
       return new Market(me.id, me.equity, me.price);
    }

    public static MarketEntity toEntity(Market m){
       return new MarketEntity(m.id, m.equity, m.price);
    }

    @Override
    public List<Market> getAllEquities() {
        //return repository.getAllEquities();
       List<MarketEntity> marketEntities = repository.findAll();
       List<Market> markets = new ArrayList<Market>();
    //    return marketEntities.stream().map(MarketEntity::toMarket).toList();
        for(MarketEntity me: marketEntities){
            Market m = toModel(me);
            markets.add(m);
        }
        return markets;
    }

    @Override
    public Market getEquityByid(long id) {
        MarketEntity marketEntity = repository.findById(id).orElseThrow(null);
        return toModel(marketEntity);
    }

    @Override
    public Market saveEquity(Market saveEquity) {
        MarketEntity me = new MarketEntity();
        me.setEquity(saveEquity.equity);
        me.setPrice(saveEquity.price);
        MarketEntity savedEntity = repository.save(me);
        return toModel(savedEntity);
    }

    @Override
    public Market updateEquity(long id, Market market) {
        // TODO Auto-generated method stub
        //if(repository.existsById(id))

        MarketEntity marketEntity = repository.findById(id).orElseThrow(null);
        marketEntity.setEquity(market.equity);
        marketEntity.setPrice(market.price);
        MarketEntity updatedEntity = repository.save(marketEntity);
        return toModel(updatedEntity);

    }

    @Override   
    public void deleteEquityById(long id) {
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Equity Not found. ");
        }
        repository.deleteById(id);
    }
}
