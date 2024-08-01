package com.example.demo.repository;

import com.example.demo.model.Medic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicRepository extends CrudRepository<Medic,Long> {

    Medic findFirstByEmail(String email);
}
