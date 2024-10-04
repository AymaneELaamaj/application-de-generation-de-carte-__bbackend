package com.example.redalback.service;

import com.example.redalback.Repository.CommunesRepository;
import com.example.redalback.Repository.SaleRepository;
import com.example.redalback.Repository.TemaraRepository;
import com.example.redalback.Repository.UserRepository;
import com.example.redalback.login.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
@NoArgsConstructor
@Transactional

public class UserService implements Loginserviceimpl{
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private CommunesRepository communesRepository;
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private TemaraRepository temaraRepository;

    @Override
    public Users saveUser(Users users) {
        return userRepository.save(users);
    }
    @Override
    public boolean isAdmin(String email) {
        Users user = findUserByemail(email);
        return user != null && "Admin".equalsIgnoreCase(user.getRole());
    }

    @Override
    public List<Users> findall(Users users) {

        return userRepository.findAll();

    }
    @Override
    public List<Communes> getcommunes(Communes communes) {

        return communesRepository.findAll();

    }
    @Override
    public List<Sale> getsale(Sale sale) {

        return saleRepository.findAll();

    }



    @Override
    public Users findUserByemail(String email) {
        return userRepository.findByemail(email);

    }





    @Override
    @Transactional
    public void updateCommunes(MultipartFile file) {
        try {
            List<Communes> newCommunesList = ExcelHelper.excelToCommunes(file.getInputStream());

            for (Communes newCommune : newCommunesList) {
                List<Communes> existingCommunesList = Optional.ofNullable(communesRepository.findByQuartier(newCommune.getQuartier())).orElse(new ArrayList<>());

                if (!existingCommunesList.isEmpty()) {
                    for (Communes existingCommune : existingCommunesList) {
                        existingCommune.setNbrclient(newCommune.getNbrclient());
                        existingCommune.setDso_jr(newCommune.getDso_jr());
                        existingCommune.setImp_mdh(newCommune.getImp_mdh());
                        communesRepository.save(existingCommune);
                    }
                } else {
                    communesRepository.save(newCommune);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("fail to update communes: " + e.getMessage());
        }
    }
    @Override
    @Transactional
    public void updateSale(MultipartFile file) {
        try {
            List<Sale> newCommunesList = ExcelHelperSale.excelToSales(file.getInputStream());

            for (Sale newCommune : newCommunesList) {
                List<Sale> existingCommunesList = Optional.ofNullable(saleRepository.findByQuartier(newCommune.getQuartier())).orElse(new ArrayList<>());

                if (!existingCommunesList.isEmpty()) {
                    for (Sale existingCommune : existingCommunesList) {
                        existingCommune.setNbrclient(newCommune.getNbrclient());
                        existingCommune.setDso_jr(newCommune.getDso_jr());
                        existingCommune.setImp_mdh(newCommune.getImp_mdh());
                        saleRepository.save(existingCommune);
                    }
                } else {
                   saleRepository.save(newCommune);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("fail to update communes: " + e.getMessage());
        }
    }
    @Override
    @Transactional
    public void updateTemara(MultipartFile file) {
        try {
            List<Temara> newCommunesList = ExcelHelperTemara.excelToTemara(file.getInputStream());

            for (Temara newCommune : newCommunesList) {
                List<Temara> existingCommunesList = Optional.ofNullable(temaraRepository.findByQuartier(newCommune.getQuartier())).orElse(new ArrayList<>());

                if (!existingCommunesList.isEmpty()) {
                    for (Temara existingCommune : existingCommunesList) {
                        existingCommune.setNbrclient(newCommune.getNbrclient());
                        existingCommune.setDso_jr(newCommune.getDso_jr());
                        existingCommune.setImp_mdh(newCommune.getImp_mdh());
                        temaraRepository.save(existingCommune);
                    }
                } else {
                    temaraRepository.save(newCommune);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("fail to update communes: " + e.getMessage());
        }
    }





}
