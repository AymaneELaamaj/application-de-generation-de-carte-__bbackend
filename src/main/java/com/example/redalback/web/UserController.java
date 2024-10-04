package com.example.redalback.web;


import com.example.redalback.Repository.CommunesRepository;
import com.example.redalback.login.*;
import com.example.redalback.service.UserService;
import com.example.redalback.usersdto.UsersDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")

public class UserController {
    @Autowired
    private  UserService userService;
    @Autowired
    private  CommunesRepository communesRepository;


    @GetMapping("/find")
    public List<Users> findusers(Users users){
        return userService.findall(users);
    }

    @PostMapping("/registre")
        public Users registerUser(@RequestBody Users users) {


        return userService.saveUser(users);
        }
    @GetMapping("/{email}")
    public Users getUserByemail(@PathVariable String email) {
        return userService.findUserByemail(email);
    }
    @GetMapping("/is-admin/{email}")
    public ResponseEntity<Boolean> isAdmin(@PathVariable String email) {
        boolean isAdmin = userService.isAdmin(email);
        return ResponseEntity.ok(isAdmin);
    }
    @Autowired
    private EntityManager entityManager;

    @GetMapping("/carte")
    public ResponseEntity<List<Communes>> getCommunes() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM communes");
        List<Communes> results = query.getResultList();
        return ResponseEntity.ok(results);
    }
    @GetMapping("/sale")
    public ResponseEntity<List<Sale>> getsale() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM Sale");
        List<Sale> results = query.getResultList();
        return ResponseEntity.ok(results);
    }
    @GetMapping("/temara")
    public ResponseEntity<List<Sale>> gettemara() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM temara");
        List<Sale> results = query.getResultList();
        return ResponseEntity.ok(results);
    }
    @GetMapping("/sidi_yahya_Zair")
    public ResponseEntity<List<Temara>> Getsidi_yahya_Zair() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM temara WHERE name = 'Centre sidi yahya Zair'");
        List<Temara> results = query.getResultList();
        return ResponseEntity.ok(results);
    }@GetMapping("/Ain_Atig")
    public ResponseEntity<List<Temara>> GetAin_Atig() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM temara WHERE name = 'Harhoura-Ain Atig'");
        List<Temara> results = query.getResultList();
        return ResponseEntity.ok(results);
    }@GetMapping("/Municipalité_de_Temara")
    public ResponseEntity<List<Sale>> GetMunicipalité_de_Temar() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM temara WHERE name = 'Municipalité de Temara'");
        List<Sale> results = query.getResultList();
        return ResponseEntity.ok(results);
    }@GetMapping("/skhirat")
    public ResponseEntity<List<Temara>> Getskhirat() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM temara WHERE name = 'Skhirat 2'");
        List<Temara> results = query.getResultList();
        return ResponseEntity.ok(results);
    }
    @GetMapping("/bettana")
    public ResponseEntity<List<Sale>> Getbettana() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM sale WHERE name = 'Bettana'");
        List<Sale> results = query.getResultList();
        return ResponseEntity.ok(results);
    }
    @GetMapping("/Laayayda")
    public ResponseEntity<List<Sale>> GetLaayayda() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM sale WHERE name = 'Laayayda'");
        List<Sale> results = query.getResultList();
        return ResponseEntity.ok(results);
    }
    @GetMapping("/Mrissa")
    public ResponseEntity<List<Sale>> GetMrisa() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM sale WHERE name = 'Bab M'Rissa'");
        List<Sale> results = query.getResultList();
        return ResponseEntity.ok(results);
    }
    @GetMapping("/bouknadel")
    public ResponseEntity<List<Sale>> GetBouknadl() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM sale WHERE name = 'Bouknadel'");
        List<Sale> results = query.getResultList();
        return ResponseEntity.ok(results);
    }@GetMapping("/tabriqet")
    public ResponseEntity<List<Sale>> Gettabriquet() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM sale WHERE name = 'Tabriquet'");
        List<Sale> results = query.getResultList();
        return ResponseEntity.ok(results);
    }@GetMapping("/hsaine")
    public ResponseEntity<List<Sale>> Gethsaine() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM sale WHERE name = 'Hsaine'");
        List<Sale> results = query.getResultList();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/Hassan")
    public ResponseEntity<List<Communes>> Gethassan() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM communes WHERE name = 'Hassan'");
        List<Communes> results = query.getResultList();
        return ResponseEntity.ok(results);
    }
    @GetMapping("/Touarga")
    public ResponseEntity<List<Communes>> Gettouarga() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient, dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM communes WHERE name = 'Touarga'");
        List<Communes> results = query.getResultList();
        return ResponseEntity.ok(results);
    }






    @GetMapping("/agdal")
    public ResponseEntity<List<Communes>> Getagdal() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient, dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM communes WHERE name = 'Riad-Agdal'");
        List<Communes> results = query.getResultList();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/yaacoub")
    public ResponseEntity<List<Communes>> Getyaacoub() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM communes WHERE name = 'Yaacoub El Mansour'");
        List<Communes> results = query.getResultList();
        return ResponseEntity.ok(results);
    }
    @GetMapping("/youssoufia")
    public ResponseEntity<List<Communes>> Getyoussoufia() {
        Query query = entityManager.createNativeQuery("SELECT id,  name, nbrclient,  dso_jr, quartier, imp_mdh, ST_AsGeoJSON(geom) as geom FROM communes WHERE name = 'El Youssoufia'");
        List<Communes> results = query.getResultList();
        return ResponseEntity.ok(results);
    }

    @PostMapping("/upload-excel")
    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                userService.updateCommunes(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(message);
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }
        }

        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
    @PostMapping("/upload-excel-sale")
    public ResponseEntity<String> uploadExcelsale(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                userService.updateSale(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(message);
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }
        }

        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
    @PostMapping("/upload-excel-temara")
    public ResponseEntity<String> uploadExceltemara(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                userService.updateTemara(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(message);
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }
        }

        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }





}
