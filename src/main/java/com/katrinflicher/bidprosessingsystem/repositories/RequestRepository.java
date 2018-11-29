package com.katrinflicher.bidprosessingsystem.repositories;

import com.katrinflicher.bidprosessingsystem.domain.Request;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestRepository extends CrudRepository<Request, Long> {
    Request findByText(String text);

    @Modifying
    @Query("update Request r set r.accept = ?1 where r.id = ?2")
    int setAcceptRequest(String accept, Integer id);

}
