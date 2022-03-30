package ru.surantaev.dao;

import ru.surantaev.entity.Company;

import java.util.List;

public interface CompanyDao {

    List<Company> getAllCompany();
    void saveCompany(Company company);
    void deleteCompany(int id);
    Company getCompanyById(int id);
    void updateCompany(Company company, int id);
}
