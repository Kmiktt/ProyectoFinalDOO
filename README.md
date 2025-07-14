# ProyectoFinalDOO
Tarea Final de la asignatura de Desarrollo Orientado a Objetos
### Integrantes:
Camila Alejandra Garcia Torres (Kmiktt)
Benjamin Alejandro Stuckrath Bustamante (Stuckrath)
Fernanda Catalina Rubilar Sánchez (Catalinafer2023)
## Actualizaciones por Semana:
#### Semana 1:
Se creo la base tanto de la clase de Mascota que se va a utilizar, como de la GUI, dividiendo la ventana en el panel que mostrará el contenido de la habitación y en el panel que contiene acciones constantes, como el boton para revisar el inventario, para cambiar de habitación y botones para cambiar la velocidad del juego (IMG 1). También se diseñaron diagramas de casos de uso simples para usar de referencia de momento (IMG 2) y diagramas para usar como referencias nosotros de como deberian ser las distintas propiedades de Mascota (IMG 3) y como deberian estar distribuidas las salas dentro del mapa y el contenido de cada una (IMG 4)

IMG 1, GUI de base: 
![image](https://github.com/user-attachments/assets/aad8517d-4689-4cb3-9ac9-4c393b692c61)

IMG 2, Diagrama de casos de uso: 
![Diagrama en blanco](https://github.com/user-attachments/assets/fdf7efbe-2c55-4701-b20f-e33e9f18a65d)

IMG 3, Diagrama de propiedades de Mascota: 

![Diagrama de Mascota](https://github.com/user-attachments/assets/b69683e2-3c2c-4055-a62a-ae977dce2fef)

IMG 4, Diagrama de Salas y su contenido: 

![Diagrama Salas](https://github.com/user-attachments/assets/ea65e61f-da19-43c5-b277-9c81c633ae3f)

INFORME:
Implementación de patrones de diseño:

Desafortunadamente no encontramos muchos lugares donde implementar un patrón de diseño fuera lo mas eficiente, un patrón de diseño que fue de mucha ayuda fue el patrón Singleton ya que este nos permite tener una sola instancia del Usuario, y además de eso un acceso global entre todos los objetos a esta instancia de usuario, esto nos ahorró muchos métodos extras ya que los métodos de por ejemplo, comprar solo tenían que llamar a Usuario.getInstance().restarDinero()  desde cualquier objeto y el dinero se descontaba, hubieron algunos problemas al hacer los test unitarios ya que tuvimos que crear un método aparte para resetear esta instancia, pero aparte de eso para este patrón de diseño no hubieron muchos más problemas.

Decisiones Importantes:

Primero, Inicialmente teníamos una perspectiva mucho mas grande sobre como iba a ser este proyecto, una interfaz distinta más dinámica en algunos aspectos, por temas de tiempo tuvimos que decidir en cortar gran parte de lo que se tenia pensado para el proyecto, esto siendo nuevas habitaciones, un mapa en donde podías cambiarte a la sala especifica donde quieras y otras decisiones sobre como era la interfaz, también otra de las decisiones importantes era la manera en la que utilizaríamos los Enums de Atributos, esto hizo que el trabajo fuera mucho más fácil ya que al crear un Objeto Podíamos darle las características desde este enum y todo podía encontrarse mucho mas organizado, con eso siendo el hambre, higiene, salud y felicidad iniciales, el tipo de especie, comida favorita, etc. Este cambio finalmente ayudo a la organización del proyecto.

Problemas en el proyecto y autocritica:

En este proyecto nos dividimos la mayoría de las cosas entre lógica y Visual, esto hizo que algunos detalles de la implementación quedaran difíciles de entender de una parte a la otra, pudo haber más comunicación entre estas partes pero el resultado final quedo bastante adecuado, también algunos detalles de la programación orientada a objeto en si fueron un problema, ya que, por ejemplo, para el objeto Tienda se tenia pensado originalmente usarlo para que sea una Tienda y un Refugio si es que en este se vendían mascotas, el problema ahí era que, ya que esta tienda era genérica, para dos mascotas de la misma especie se usaba el mismo objeto, por ende era la misma referencia, eso causaba problemas con las características de dos animales que se suponían que debían ser distintos, esto se resolvió creando el refugio como un tipo de objeto aparte, pero en ese aspecto nos falto manejo de el lenguaje para ejecutar la visión exitosamente, un problema algo externo que se tuvo con el proyecto era el tiempo, ya que teníamos los últimos certámenes hubieron días donde no pudimos hacer muchos commit así retrasando el desarrollo del proyecto, últimamente, todo podría llegar a darse a la organización y falta de manejo.

Pensamientos Finales:

Este proyecto aunque en partes fue tedioso, la manera en la que logramos cambiar nuestra manera de organizarnos durante el semestre hizo que este proyecto no se sintiera tan engorroso como los anteriores, además como el tema tenía algunas características extra las cuales podíamos elegir le daba un Ambiente de creatividad e innovación, pensar en cómo nosotros implementaríamos ciertas características a el programa hizo que fuera mucho más interesante, y el producto final aunque no fue lo que esperábamos, se siente más valioso al saber que lo hicimos nosotros como grupo.

