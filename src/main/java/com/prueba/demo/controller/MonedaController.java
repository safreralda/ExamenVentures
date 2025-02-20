package com.prueba.demo.controller;

import com.prueba.demo.models.Moneda;
import com.prueba.demo.service.MonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monedas")
public class MonedaController {
    @Autowired
    private MonedaService monedaService;

    @GetMapping("/buscar")
    public ResponseEntity <List<Moneda>> getAllMonedas (){
        try {
            List<Moneda> monedaList = monedaService.getAllMonedas();
            return ResponseEntity.ok(monedaList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/agregar")
    public ResponseEntity <Moneda> saveMoneda (@RequestBody Moneda catMoneda) {
        try {
            Moneda saveMoneda = monedaService.saveMoneda(catMoneda);
            return ResponseEntity.status(HttpStatus.CREATED).body(saveMoneda);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/borrar/{numCia}")
    public ResponseEntity <Void> deleteMoneda (@PathVariable Integer numCia) {
        try {
            monedaService.deleteMoneda(numCia);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/actualizar/{numCia}")
    public ResponseEntity <Moneda> updateMoneda (@PathVariable Integer numCia, @RequestBody Moneda catMoneda) {
        try {
            Moneda updateMoneda = monedaService.updateMoneda(numCia, catMoneda);
            if (updateMoneda == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(updateMoneda);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
