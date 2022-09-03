# Desarrollo
Taller Paradigmas.

Aspect Oriented Programming. 

1.Conceptos de AOP. 
AOP es un paradigma de programación que tiene como objetivo aumentar la modularidad al permitir la separación de lo que se llaman "cross-cuttings". El significado de "cross-cutting" esta relacionada a alguna funcionalidad genérica que se necesite en muchos lugares, pero esta no está relacionada con la lógica del negocio de la aplicación. Algunos ejemplos pueden ser: el loggin, la seguridad y el manejo de errores.

Conceptos de a AOP utilizados en el taller:
* Aspecto: es una modularización de una preocupación que atraviesa múltiples clases
* Joinpoint: es un punto durante la ejecución de un programa, como la ejecución de un método o el manejo de una excepción.
* Advice: Consejo: es una acción que tomamos antes o después de la ejecución del método. La acción es una pieza de código que se invoca durante la ejecución del programa. Tipos de advice: before, after, after-returning, after-throwing, and around advice.

2.Explicación del codigo:
Se hizo una simulación de la creación de un Empleado (sin persistencia) para conocer un poco sobre alguna de las anotaciones del AOP y ver su funcionamiento e utilidad que podrian tener. 

Primero se agrego la dependencia para AOP:
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-aop</artifactId>
			<version>2.7.3</version>
</dependency>

 Se tienen varios "packages" para realizar la división de las tareas de cada clase creada:
 1. Package Model: Contiene la clase empleado donde se tienen los atributos que tiene un empleado(en este caso solo se utilizo el nombre y el id) con sus respectivos getters y setters.
 2. Package Controller: Contiene el controlador y en este caso se puso la anotación "@RestController" para que esta maneje las solicitudes realizadas por el cliente. Dentro de esta clase se encuentra un método llamado "addEmployee" que se usa para añadir un empleado llamando otro método que se encuentra en el paquete del servicio(logica del negocio). Cabe aclarar que este método ("addEmployee") utiliza la notación @RequestMapping para devolver un objeto de empleado. 
3. Package servicio: Contiene la clase "servicioEmpleado" que utiliza la anotación "@Service" para indicar que esta mantiene la lógica del negocio. Dentro de esta en este caso solo esta el método de crearEmpleado, que recibe un nombre y un id para realizar esto.
4. Package aspecto: Contiene la clase "AspectoEmpleado" donde se usa la anotación "@Aspect" para indicar que es un aspecto. Dentro de está hay dos métodos muy parecidos pero con anotaciones diferentes(@After y @Before):
  * Método beforeAdvice con la anotación @Before(excution....): esta anotación lo que hace es interceptar dentro de un método en especifico(en este caso se le esta indicando que puede ser cualquier método que este en la clase de servicioEmpleado con argumentos de nombre e ID) antes de su ejecución. La variable joinPoint es la que contiene toda la información sobre la intercepción que se realizo es por eso que al usar joinPoint.getSignature() se esta imprimiendo la firma del método interceptado.
  * Método afterAdvice con la anotación @After(execution...): esta anotación es bastante parecida al before(excution) pero en este caso lo hace después de la ejecución de un método en especifico. 

Cómo se explico anteriormente estas anotaciones utilizadas en AOP son bastantes utiles para escribir por ejemplo un codigo que se necesite antes o despues de la llamada a un método especifico. 

3.Compilación y Ejecución del codigo:
  1. Ejecutar la clase DemoApplication:
  ![image](https://user-images.githubusercontent.com/80464818/188250398-aca8a2ed-088a-4ddd-a2da-8449cd05bab9.png)
  (Nota: se adjunto imagen dentro de la carpeta: Ver foto1.png)
  2. Abrir el navegador y poner: localhost:8080/add/employee?empId=1&name=test (Nota: Revisar el puerto utilizado, normalmente es 8080)

4.Resultados:
![image](https://user-images.githubusercontent.com/80464818/188250504-7c72a86b-d01a-4fb7-8f7f-eb3c56857471.png)
(Nota: se adjunto imagen dentro de la carpeta: Ver foto2.png)

Impresiones realizados por los métodos beforeAdvice y afterAdvice. 
![image](https://user-images.githubusercontent.com/80464818/188250512-bd9336f4-81d9-4ee3-bc44-98609afe5aed.png)
(Nota: se adjunto imagen dentro de la carpeta: Ver foto3.png)

Links de Referencia:
https://www.javainuse.com/spring/spring-boot-aop
https://dev.to/pramudaliyanage/cross-cutting-concerns-in-spring-framework-9fo
https://www.javatpoint.com/spring-boot-aop#:~:text=Aspect%3A%20A%20code%20unit%20that,the%20execution%20of%20method%20bodies.
