package com.example.project3.dao;

import com.example.project3.ColumnNameConstants;
import com.example.project3.enums.HotelStatus;
import com.example.project3.enums.RoomStatus;
import com.example.project3.model.persistance.HotelBooking;
import com.example.project3.model.persistance.Room;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class HotelBookingDao extends AbstractDao<HotelBooking, Long>{

    public Integer countTotalBookingRequest(String externalId){
        Session session = getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<HotelBooking> criteriaQuery = criteriaBuilder.createQuery(HotelBooking.class);
        Root<HotelBooking> root =criteriaQuery.from(HotelBooking.class);
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList().size();
    }

    public List<HotelBooking> getAllHotelBooking(String hotelId){
        Session session = getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<HotelBooking> criteriaQuery = criteriaBuilder.createQuery(HotelBooking.class);
        Root<HotelBooking> root =criteriaQuery.from(HotelBooking.class);
        Predicate hotelIdPredicate = criteriaBuilder.equal(root.get("hotelId") , hotelId);
        criteriaQuery.where(hotelIdPredicate);
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public HotelBooking getHotelBooking (String externalId){
        return getUniqueEntityByColumn(ColumnNameConstants.EXTERNAL_ID , externalId);
    }
}
