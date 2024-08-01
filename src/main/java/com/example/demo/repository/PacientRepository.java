package com.example.demo.repository;

import com.example.demo.model.Pacient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PacientRepository extends CrudRepository<Pacient,Long> {
    Pacient findByNrCrt(Long nrCrt);
    boolean existsByNrCrt(Long nrCrt);

    @Query("SELECT p FROM Pacient p ORDER BY p.nrCrt DESC")
    List<Pacient> findLastPacient(Pageable pageable);
}
