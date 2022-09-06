# Swagger Petstore

### Descripción
###### En la pagina web [SwaggerPetstore]([https://www.demoblaze.com/index.html](https://petstore.swagger.io/)) se va a testear el metodo POST para crear una nueva mascota, GET para conseguir una mascota existente con ID, PUT para modificar una mascota existente. En todos los casos se valida el status code y el schema del response.


### Construido con 🛠️

 - **Eclipce IDE**- El framework web usado
 -  **Maven** - Manejador de dependencias
 - **Cucumber** - Utilizado para especificar escenarios de pruebas
 - **JUnit** - Utilizado para ejecutar los Tests
 - **Java** - Lenguaje utilizado para construir la automatizacion
 - **Rest assured** - Herramienta utilizada para enviar los request y reponse de API .
 
### Comenzando

#### Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.
### Ejecutando las pruebas

##### Se clona o descarga el proyecto dentro de su repositorio, en la esquina superior derecha con el boton llamado "Code".
##### Se abre el cmd (simbolo del sistema/consola)
##### Se debe ingresar la ruta donde se aloje el proyecto e ingresamos el comando



          mvn clean install

##### Si no se ejecuta correctamente tambien se puede ingresar

         mvn test
         
 ### Report      

##### Cuando se termine de ejecutar los test el report se sube automaticamente en html en la siguiente carpeta:

##### target>html-reports>report.html
