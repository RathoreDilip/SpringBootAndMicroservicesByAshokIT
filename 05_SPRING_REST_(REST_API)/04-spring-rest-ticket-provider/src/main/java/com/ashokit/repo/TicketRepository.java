package com.ashokit.repo;

import com.ashokit.entity.Ticket;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    List<Ticket> findByEmail(String email);

}
