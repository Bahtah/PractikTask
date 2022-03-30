package ru.surantaev.service;

import ru.surantaev.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompany();
    void saveCompany(Company company);
    void deleteCompany(int id);
    Company getCompanyById(int id);
    void updateCompany(Company company, int id);
}
