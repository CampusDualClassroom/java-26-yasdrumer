# Ejercicio 26 - Agenda de teléfonos
## Descripción del ejercicio
Se quiere crear un listín telefónico en Java, con el que el usuario pueda interactuar utilizando un menú.

### Objetivos
* Poder realizar la aplicación que emule un listín telefónico.
* Que la aplicación sea capaz de pasar los test de Maven.

### Clase Contact
La clase *Contact* representa a un contacto que se guardará en el listín telefónico. Esta clase implementará la interfaz
*ICallActions* que se indica debajo. 

Un contacto tiene que tener un nombre, apellidos (puede ser más de uno o compuesto, y tiene que estar separado por 
espacios), un número de teléfono y un código que se generará automáticamente. Dicho código tiene las siguientes características:

* Todo en minúscula
* Sin [signos diacríticos](https://es.wikipedia.org/wiki/Signo_diacr%C3%ADtico#Tipos)
* Si el contacto solo tiene un apellido
    * El apellido en minúscula
* Si el contacto tiene más de un apellido (o uno compuesto que contenga espacios)
  * La primera letra del primer apellido (o primera parte del apellido)
  * El resto de las letras del subsiguiente apellido (o del mismo apellido compuesto) sin espacios

Ejemplos:
* <u>Javier</u> <u>López</u> → jlopez
* <u>Carlos</u> <u>Fernández-Simón</u> → cfernandez-simon
* <u>Jose Manuel</u> <u>Soria</u> → jsoria
* <u>Santiago</u> <u>Fernández</u> <u>Rocha</u> → sfrocha
* <u>Esteban</u> <u>Serrano</u> <u>del Río</u> → esdelrio
* <u>Fernando Miguel</u> <u>Juan de los Santos</u> <u>Requejo León</u> → fjdelossantosrequejoleon

Debe tener un menú que le permita al contacto realizar las acciones que implementa de ``ICallActions``

### Interfaz ICallActions
Este ejercicio requiere que se use una interfaz (*ICallActions.java*) que será suministrada. Esta interfaz tiene la firma
de 3 métodos diferentes.
```java
public interface ICallActions {
    
    void callMyNumber();
    //Este método tendrá que indicar con un mensaje escrito por consola
    //que el propio contacto se está llamando a sí mismo, y especificar
    //cuál es su número de teléfono
    
    void callOtherNumber(String number);
    //Este método tendrá que indicar con un mensaje escrito por consola
    //que el propio contacto se está llamando a un número de teléfono
    //que se le facilita por parámetro
    
    void showContactDetails();
    //Muestra en un mensaje por consola con los detalles del contacto
}
```
### Clase Phonebook
Esta clase contendrá un ```Map<String,Contact>``` que funcionará como almacén de contactos, siendo la clave del mapa
el código del contacto y como valor del mapa el propio contacto. Esta clase debe poseer un menú, en el que podamos:
* Añadir un contacto al listín telefónico
* Mostar los contactos del listín telefónico
* Seleccionar un contacto y mostrar su menú de acciones
* Eliminar un contacto

### Requisitos
* No se pueden modificar en absoluto las clases de test.
* Si las clases test contiene un método, es necesario modificar la aplicación para que ese método exista y tenga sentido
lógico en dicha aplicación
* Se pueden (y es recomendable) crear métodos a mayores para encapsular las funcionalidades de la aplicación o para
mejorar la legibilidad del código.

### Test

```
  mvn test
```

### Bonus
Que todos los contactos puedan tener múltiples números de teléfono. Se debe marcar uno de esos números como número
principal. El resto de los números estará almacenado en un atributo de tipo ``List<String>`` 



