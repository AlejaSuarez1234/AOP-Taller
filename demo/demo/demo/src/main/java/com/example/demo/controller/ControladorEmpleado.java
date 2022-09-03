package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Empleado;
import com.example.demo.servicio.ServicioEmpleado;
@RestController
public class ControladorEmpleado {
    @Autowired
    private ServicioEmpleado service;

    @RequestMapping(value = "/add/employee", method = RequestMethod.GET)
    public Empleado addEmployee(@RequestParam("name") String name, @RequestParam("empId") String empId) {

        return service.crearEmpleado(name, empId);

    }
}
