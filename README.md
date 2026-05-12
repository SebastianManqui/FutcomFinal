Este proyecto llamado Futcom, consiste en el desarrollo de una aplicación backend utilizando el framework Java Spring Boot. lo que permite una separación clara entre la exposición de servicios, la lógica de negocio y el acceso a los datos.
A través de este microservicio, es posible administrar entidades críticas como jugadores, selecciones, partidos, estadios y grupos, asegurando la integridad y escalabilidad del sistema mediante el uso de Spring Data JPA.

La estructura del código se organiza de manera modular para facilitar su mantenimiento. En la capa de model se definen las entidades que representan las tablas de la base de datos, mientras que los repositories gestionan las operaciones CRUD.

Para proteger la integridad de los datos y optimizar la comunicación, se han implementado DTOs en una capa independiente, evitando que las entidades de persistencia se expongan directamente en los controladores.

Por su parte, el paquete service centraliza la lógica operativa, sirviendo de puente entre las peticiones recibidas por los controllers y la base de datos.

Un componente diferenciador de este proyecto es la integración de servicios externos, configurada mediante WebClient en el paquete de config. Esto permite que la aplicación consuma APIs de terceros, como se observa en la gestión de datos meteorológicos 
a través del WeatherController, proporcionando información en tiempo real sobre el clima en los distintos estadios. En conclusión, este trabajo representa una ejecución práctica integral que combina el desarrollo, el consumo de servicios externos
y el cumplimiento de los estándares de arquitectura de software modernos exigidos en el nivel universitario.

¿Como se ejecuta entonces? 
Primero abrimos el VS (visual studio), clonar el repository en la consola, luego se conecta al base dato del laragon y se ejecutaria en el proyecto principal en visual, ya ejecutado creamos las tablas y todo lo que con lleva nuestro proyecto, despues en el postman agregamos todos los endpoint que pusimos en los controladores e iniciamos las consultas correspondientes como listar, agregar, ect.

AUTORES:
Diego Arroyo
Sebastian Manqui

