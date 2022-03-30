package ru.surantaev.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.surantaev.entity.Company;

import java.util.List;

@Repository
public class CompanyDaoImplement implements CompanyDao{

    private final SessionFactory sessionFactory;

    @Autowired
    public CompanyDaoImplement(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Company> getAllCompany() {
        return sessionFactory.getCurrentSession().createQuery("FROM Company order by id asc").getResultList();
    }

    @Override
    public void saveCompany(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(company);
    }

    @Override
    public void deleteCompany(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Company.class, id));
    }

    @Override
    public Company getCompanyById(int id) {
        return sessionFactory.getCurrentSession().find(Company.class, id);
    }

    @Override
    public void updateCompany(Company company, int id) {
        Session session = sessionFactory.getCurrentSession();
        Company company1 =session.get(Company.class, id);
        company1.setName(company.getName());
    }
}
