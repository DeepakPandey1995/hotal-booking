package com.example.project3.dao;

import com.example.project3.model.dto.Response.HotelResponse;
import com.example.project3.model.persistance.Hotel;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class HotelDao extends AbstractDao<Hotel, Long>{

    public Hotel getHoteldetail(String externalId) {
        Session session = getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Hotel> criteriaQuery = criteriaBuilder.createQuery(Hotel.class);
        Root<Hotel> root = criteriaQuery.from(Hotel.class);
        Predicate externalIdPredicate = criteriaBuilder.equal(root.get("hotelExternalId"), externalId);
        Predicate finalPredicate = criteriaBuilder.and(externalIdPredicate);
        criteriaQuery.where(finalPredicate);
        Query query = session.createQuery(criteriaQuery);
        return (Hotel) query.getSingleResult();
    }
}
