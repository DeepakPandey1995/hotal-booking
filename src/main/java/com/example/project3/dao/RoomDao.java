package com.example.project3.dao;

import com.example.project3.enums.RoomStatus;
import com.example.project3.model.dto.Response.HotelResponse;
import com.example.project3.model.dto.Response.RoomResponse;
import com.example.project3.model.persistance.Hotel;
import com.example.project3.model.persistance.Room;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class RoomDao extends AbstractDao<Room, Long>{

    public Integer countTotalRoom (Long hotelId){
        Session session = getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Room> criteriaQuery = criteriaBuilder.createQuery(Room.class);
        Root<Room> root =criteriaQuery.from(Room.class);
        Join<Object , Object> hotelJoin = (Join<Object, Object>) root.fetch("hotel");
        Predicate statusPredicate = criteriaBuilder.equal(root.get("status") , RoomStatus.Available);
        Predicate hotelPredicate = criteriaBuilder.equal(hotelJoin.get("id") ,hotelId);
        Predicate finalPredicate = criteriaBuilder.and( hotelPredicate,statusPredicate);
        criteriaQuery.where(finalPredicate);
        Query query = session.createQuery(criteriaQuery);
        return  query.getResultList().size();

    }

    public List<Room>getAvailableRoom(Long hotelId){
        Session session = getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Room> criteriaQuery = criteriaBuilder.createQuery(Room.class);
        Root<Room> root =criteriaQuery.from(Room.class);
        Join<Object , Object> hotelJoin = (Join<Object, Object>) root.fetch("hotel");
        Predicate hotelPredicate = criteriaBuilder.equal(hotelJoin.get("id"),hotelId);
        Predicate statusPredicate = criteriaBuilder.equal(root.get("status"), RoomStatus.Available);
        Predicate finalPredicate = criteriaBuilder.and( hotelPredicate,statusPredicate);
        criteriaQuery.where(finalPredicate);
        Query query = session.createQuery(criteriaQuery);
        return  query.getResultList();
    }

    public List<Room> getBookedRoom() {
        Session session = getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Room> criteriaQuery = criteriaBuilder.createQuery(Room.class);
        Root<Room> root = criteriaQuery.from(Room.class);
        Predicate statusPredicate = criteriaBuilder.equal(root.get("status"), RoomStatus.Booked.ordinal());
        Predicate finalPredicate = criteriaBuilder.and(statusPredicate);
        criteriaQuery.where(finalPredicate);
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
