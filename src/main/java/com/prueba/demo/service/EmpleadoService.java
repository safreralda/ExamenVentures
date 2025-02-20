package com.prueba.demo.service;

import com.prueba.demo.models.Empleado;
import com.prueba.demo.repository.EmpleadoRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Operation(summary = "Obtener todos los empleados", description = "Retorna una lista de todos los empleados")
    public List<Empleado> getAllEmpls() {
        return empleadoRepository.findAll();
    }

    public List<Empleado> getEmplByNumCiaAndNumEmp(Integer numCia, Integer numEmp) {
        return empleadoRepository.findByCatMoneda_NumCiaAndNumEmp(numCia, numEmp);
    }

    public List<Empleado> getEmplByNumCiaAndClaveMoneda(Integer numCia, String claveMoneda) {
        return empleadoRepository.findByCatMoneda_NumCiaAndCatMoneda_ClaveMoneda(numCia, claveMoneda);
    }

    public Empleado saveEmpl(Empleado empl) {
        return empleadoRepository.save(empl);
    }

    public void deleteEmpl(Integer numEmp) {
        empleadoRepository.deleteById(numEmp);
    }

    public Empleado updateEmpl(Integer numEmp, Empleado empl) {
        if (empleadoRepository.existsById(numEmp)) {
            empl.setNumEmp(numEmp);  // Mantener el numEmp original
            return empleadoRepository.save(empl);
        }
        return null;  // Si no existe el registro
    }
}

