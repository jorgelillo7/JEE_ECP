# JEE_Votaciones
Proyecto que usa para abordar un mismo problema: jsp+jsf+rest.

Se pretende realizar una aplicación Web para la recogida de votos de usuarios de diferentes temáticas. Cada temática tendrá una pregunta y el usuario podrá contestar en una valoración entre 0 a 10. La aplicación se requisita en cuatro Casos de Uso:
* Votar. Se le presenta al usuario un conjunto de temas. El usuario elegirá un tema y el sistema le presentará una pregunta donde el usuario podrá valorar en una escala de 0..10, además indicará su nivel de estudio de una lista prestablecida (mínimo tres). Ese voto quedará almacenado con la IP del usuario
* Ver votaciones. El usuario podrá ver el número de votos de cada tema y la votación media según el nivel de estudios
* Añadir Tema. Se permite añadir un nuevo tema al sistema
* Eliminar Tema. Se le pide al usuario un identificador de autorización. Sólo con el valor 666 podrá avanzar y se le mostrara el conjunto de temas existentes para elegir uno. El sistema borrará todos los votos asociados a ese tema y el propio tema. En el caso de utilizar un identificador no válido, se le mostrará una pantalla de error.
Este enunciado es una descripción genérica. El alumno deberá cerrar todos aquellos detalles que considere oportuno mientras no se contradiga los aquí especificados. Además deberá diseñar las pantallas y los enlaces entre ellas.


Probado en:
- Netbeans 7.2.1
- JDK 1.7

Arrancando el proyecto: (index.html) nos encontramos con las 3 formas de acceso de la web:

![alt tag](https://github.com/jorgelillo7/JEE_Votaciones/blob/master/docs/1-%20index.PNG)

JSP:
![alt tag](https://github.com/jorgelillo7/JEE_Votaciones/blob/master/docs/2-%20index%20jsp.PNG)


JSF:
![alt tag](https://github.com/jorgelillo7/JEE_Votaciones/blob/master/docs/3-%20index%20jsf.PNG)


REST:
![alt tag](https://github.com/jorgelillo7/JEE_Votaciones/blob/master/docs/4-%20index%20rest.PNG)

**Nota rest: Revisar clase jersey client para probar el resto de funcionalidad que no se puede realizar vía petición get**
