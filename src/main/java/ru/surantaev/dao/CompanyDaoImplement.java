package ru.surantaev.dao;

import org.springframework.stereotype.Repository;
import ru.surantaev.entity.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CompanyDaoImplement implements CompanyDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Company> getAllCompany() {
        return entityManager.createQuery("SELECT c FROM Company c", Company.class).getResultList();
    }

    @Override
    public void saveCompany(Company company) {
        entityManager.persist(company);
    }

    @Override
    public void deleteCompany(int id) {
        entityManager.remove(getCompanyById(id));
    }

    @Override
    public Company getCompanyById(int id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public void updateCompany(Company company, int id) {
        Company company1 = getCompanyById(id);
        company1.setName(company.getName());
        company1.setLocatedCountry(company.getLocatedCountry());
        entityManager.merge(company1);
    }
}
