package com.example.redalback.Repository;

import com.example.redalback.login.Communes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunesRepository extends JpaRepository<Communes,Integer> {


    List<Communes> findByQuartier(String quartier);
}
