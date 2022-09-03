package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class AspectoEmpleado {
    //execution: la intercepcion es dentro del metodo
    @Before(value = "execution(* com.example.demo.servicio.ServicioEmpleado.*(..)) && args(name,empId)")
    public void beforeAdvice(JoinPoint joinPoint, String name, String empId) { //El joinpoint contiene toda la info de la intercepcion
        System.out.println("Before method:" + joinPoint.getSignature()); //Imprimo la firma del metodo
        System.out.println("Creando empleado con nombre- " + name + " y id - " + empId);

    }

    @After(value = "execution(* com.example.demo.servicio.ServicioEmpleado.*(..)) && args(name,empId)")
    public void afterAdvice(JoinPoint joinPoint, String name, String empId) {
        System.out.println("After method:" + joinPoint.getSignature());
        System.out.println("Correctamente creado el empleado con nombre- " + name + " y id - " + empId);
    }
}
