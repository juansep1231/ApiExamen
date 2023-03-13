package com.api.crudconstruccion.constrollers;

import com.api.crudconstruccion.models.Carro;
import com.api.crudconstruccion.repositories.ICarroRepository;
import com.api.crudconstruccion.services.CarroService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;
    @GetMapping
    public ArrayList<Carro> getCarros(){
        return this.carroService.getCarros();
    }

    @PostMapping
    public Carro saveCarro(@RequestBody Carro carro){
        return this.carroService.saveCarro(carro);
    }

    @GetMapping(path = "/{id}")
    public Optional<Carro> getCarroById(@PathVariable("id") Integer id){
    return this.carroService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Carro getCarroById(@RequestBody Carro carro, @PathVariable("id") Integer id){
        return this.carroService.updateById(carro,id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean ok = this.carroService.deleteCarro(id);

        if(ok){
            return "Carro con id " + id + " eliminado";
        }else{
            return "Carro con id " + id + " no eliminado";
        }
    }




}
