package com.example.redalback.service;


import com.example.redalback.login.Communes;
import com.example.redalback.login.Sale;
import com.example.redalback.login.Users;
import com.example.redalback.usersdto.UsersDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface Loginserviceimpl  {


    Users saveUser(Users users);


    boolean isAdmin(String email);

    List<Users> findall(Users users);


    List<Communes> getcommunes(Communes communes);

    List<Sale> getsale(Sale sale);

    Users findUserByemail(String email);


    @Transactional
    void updateCommunes(MultipartFile file);

    @Transactional
    void updateSale(MultipartFile file);

    @Transactional
    void updateTemara(MultipartFile file);
}
