package ru.surantaev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.surantaev.dao.CompanyDao;
import ru.surantaev.entity.Company;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImplement implements CompanyService{

    @Autowired
    private CompanyDao companyDao;

    @Override
    public List<Company> getAllCompany() {
        return companyDao.getAllCompany();
    }

    @Override
    public void saveCompany(Company company) {
        companyDao.saveCompany(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyDao.deleteCompany(id);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyDao.getCompanyById(id);
    }

    @Override
    public void updateCompany(Company company, Long id) {
        companyDao.updateCompany(company, id);
    }
}
