package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.MarketEntity;

@Repository
public interface MarketJPARepository extends JpaRepository<MarketEntity, Long> {
    
}
