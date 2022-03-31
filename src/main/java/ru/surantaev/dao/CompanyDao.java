package ru.surantaev.dao;

import ru.surantaev.entity.Company;

import java.util.List;

public interface CompanyDao {

    List<Company> getAllCompany();
    void saveCompany(Company company);
    void deleteCompany(Long id);
    Company getCompanyById(Long id);
    void updateCompany(Company company, Long id);
}
