package com.prueba.demo.service;

import com.prueba.demo.models.Moneda;
import com.prueba.demo.repository.MonedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonedaService {
    @Autowired
    private MonedaRepository monedaRepository;

    public List<Moneda> getAllMonedas() {
        return monedaRepository.findAll();
    }

    public Moneda saveMoneda(Moneda catMoneda) {
        return monedaRepository.save(catMoneda);
    }

    public void deleteMoneda(Integer numCia) {
        monedaRepository.deleteById(numCia);
    }

    public Moneda updateMoneda(Integer numCia, Moneda catMoneda) {
        if (monedaRepository.existsById(numCia)) {
            catMoneda.setNumCia(numCia);
            return monedaRepository.save(catMoneda);
        }
        return null;
    }
}
