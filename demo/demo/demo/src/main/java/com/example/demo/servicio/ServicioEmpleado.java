package com.example.demo.servicio;
import org.springframework.stereotype.Service;
import com.example.demo.model.Empleado;
@Service
public class ServicioEmpleado {
    public Empleado crearEmpleado(String nombre, String empId){
        Empleado emp = new Empleado();
        emp.setName(nombre);
        emp.setEmpId(empId);
        return emp;
    }
}
