package com.capstone.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

import com.capstone.Entity.*;

@Stateless
public class UsersEJB {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "DVDStorePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public List<Users> findUsers(String strQuery) {
        TypedQuery<Users> query = em.createQuery(strQuery, Users.class);
	List<Users> ls = query.getResultList();
	return ls;
    }

}