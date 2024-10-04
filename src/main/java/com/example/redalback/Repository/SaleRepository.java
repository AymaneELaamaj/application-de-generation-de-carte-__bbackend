package com.example.redalback.Repository;

import com.example.redalback.login.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
    List<Sale> findByQuartier(String quartier);
}
