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
        Long id = company.getId();
        if (id == null) {
            entityManager.persist(company);
        }else {
            entityManager.merge(company);
        }
    }

    @Override
    public void deleteCompany(Long id) {
        entityManager.remove(getCompanyById(id));
    }

    @Override
    public Company getCompanyById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public void updateCompany(Company company, Long id) {
        Company company1 = getCompanyById(id);
        company1.setName(company.getName());
        //company1.setLocatedCountry(company.getLocatedCountry());
        entityManager.merge(company1);
    }
}
