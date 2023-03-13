package com.api.crudconstruccion.repositories;

import com.api.crudconstruccion.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarroRepository extends JpaRepository<Carro,Integer> {


}
