package com.company.first_jobappproject.Company;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity <List<Company>> getallCompanies(){
        return new ResponseEntity<>(companyService.getallCompanies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
 public   ResponseEntity <Company> findByid(@PathVariable Long id){
        Company company=companyService.findByid(id);
        if(company==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(company, HttpStatus.OK);
    }


    @PutMapping("/{id}")
   public ResponseEntity <String> updatecompany(@PathVariable Long id,@RequestBody Company company){
        boolean update=companyService.updatecompany(id,company);
        if(update){
            return new ResponseEntity<>("updated company ",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<String > createcompany(@RequestBody  Company company){
        companyService.createcompany(company);
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletecompany(@PathVariable Long id){
        boolean deleted=companyService.deletecompany(id);
        if(deleted){
            return new ResponseEntity<>("deleted",HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }







}
