package com.example.demo.repository;

import com.example.demo.model.FisaMedicala;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FisaMedicalaRepository extends CrudRepository<FisaMedicala,Long> {

}
