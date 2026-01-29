package com.example.demo.bootstrap;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.MarketEntity;
import com.example.demo.model.Market;
import com.example.demo.repository.MarketJPARepository;

@Component
public class DataLoader implements org.springframework.boot.CommandLineRunner {

    private MarketJPARepository marketJPARepository;

    public DataLoader(MarketJPARepository marketJPARepository) {
        this.marketJPARepository = marketJPARepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        if(marketJPARepository.count() > 0){
            return;
        }
        marketJPARepository.saveAll(List.of(
            new MarketEntity(null, "HSBC", 15000),
            new MarketEntity(null, "UBS", 280000),
            new MarketEntity(null, "Wells Fargo", 30000)
        ));

    }
    
}
