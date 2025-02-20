package com.prueba.demo.repository;

import com.prueba.demo.models.Empleado;
import com.prueba.demo.models.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository <Empleado, Integer> {
    List<Empleado> findByCatMoneda_NumCiaAndNumEmp(Integer numCia, Integer numEmp);
    List<Empleado> findByCatMoneda_NumCiaAndCatMoneda_ClaveMoneda(Integer numCia, String claveMoneda);
}
