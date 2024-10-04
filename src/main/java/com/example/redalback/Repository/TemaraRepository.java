package com.example.redalback.Repository;

import com.example.redalback.login.Sale;
import com.example.redalback.login.Temara;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemaraRepository extends JpaRepository<Temara,Integer> {
    List<Temara> findByQuartier(String quartier);
}
