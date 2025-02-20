package com.prueba.demo.controller;


import com.prueba.demo.models.Empleado;
import com.prueba.demo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/buscar")
    public ResponseEntity<List<Empleado>> getAllEmpls() {
        try {

            List<Empleado> empleadoList = empleadoService.getAllEmpls();
            System.out.println(empleadoList);
            return ResponseEntity.ok(empleadoList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/by_numcia_numemp")
    public ResponseEntity<List<Empleado>> getEmplByNumCiaAndNumEmp(@RequestParam Integer numCia, @RequestParam Integer numEmp) {
        try {
            List<Empleado> empleados = empleadoService.getEmplByNumCiaAndNumEmp(numCia, numEmp);
            if (empleados.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(empleados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/by_numcia_clavemoneda")
    public ResponseEntity<List<Empleado>> getEmplByNumCiaAndClaveMoneda(@RequestParam Integer numCia, @RequestParam String claveMoneda) {
        try {
            List<Empleado> empleados = empleadoService.getEmplByNumCiaAndClaveMoneda(numCia, claveMoneda);
            if (empleados.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(empleados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/agregar")
    public ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado empl) {
        try {
            Empleado saveEmpleado = empleadoService.saveEmpl(empl);
            return ResponseEntity.status(HttpStatus.CREATED).body(saveEmpleado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/borrar/{numEmp}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Integer numEmp) {
        try {
            empleadoService.deleteEmpl(numEmp);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/actualizar/{numEmp}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Integer numEmp, @RequestBody Empleado empl) {
        try {
            Empleado updateEmpleado = empleadoService.updateEmpl(numEmp, empl);
            if (updateEmpleado == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(updateEmpleado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
