package com.company.first_jobappproject.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getallCompanies();

    Company findByid(Long id);

    boolean updatecompany(Long id,Company com);

    void createcompany(Company company);

    boolean deletecompany(Long id);
}
