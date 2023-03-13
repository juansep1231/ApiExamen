package com.api.crudconstruccion.services;

import com.api.crudconstruccion.models.Carro;
import com.api.crudconstruccion.repositories.ICarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    ICarroRepository carroRepository;

    public ArrayList<Carro> getCarros(){
        return (ArrayList<Carro>) carroRepository.findAll();
    }

    public Carro saveCarro(Carro carro){
        return carroRepository.save(carro);
    }

    public Optional<Carro> getById(Integer id){
        return carroRepository.findById(id);
    }

    public Carro updateById(Carro carroActualizado, Integer id){
        Carro carro = carroRepository.findById(id).get();

        carro.setMarca(carroActualizado.getMarca());
        carro.setModelo(carroActualizado.getModelo());
        carro.setPlaca(carroActualizado.getPlaca());

        return carro;

    }


    public Boolean deleteCarro(Integer id){
        try{
            carroRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
