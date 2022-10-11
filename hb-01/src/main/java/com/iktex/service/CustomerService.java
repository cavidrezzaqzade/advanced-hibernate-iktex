package com.iktex.service;

import com.iktex.models.Customer;
import com.iktex.models.Vehicle;
import com.iktex.repository.CustomerRepository;
import com.iktex.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerService implements CustomerRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Customer> findAll() {
        // JPQL & HQL
        return em.createQuery("FROM Customer", Customer.class).getResultList();
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void saveToDatabase(Customer object) {

    }

    @Override
    public void deleteFromDatabase(Customer object) {

    }

    @Override
    public void deleteFromDatabase(int id) {

    }

    @Override
    public void updateOnDatabase(Customer object) {

    }

    @Override
    public List<Vehicle> findAllVehicleOfCustomerWithSSID(long ssid) {
        TypedQuery<Customer> q =  em.createQuery("FROM Customer c WHERE c.ssid = :ssid", Customer.class);
        q.setParameter("ssid", ssid);
        Customer customer = q.getSingleResult(); // Lazy loading
        return customer.getVehicleList();
    }
}
