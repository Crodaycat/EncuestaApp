Pasos para abrir el proyecto:

1. Clonar o descagar el repositorio de GitHub.

2. Dentro de la carpeta del repositorio hay otra carpeta llamada encuesta. Esta carpeta es un proyecto de Netbeans. Por lo tanto en netbeans seleccionamos la opción de abrir proyecto y buscamos esta carpeta.

3. Configurar el archivo de hibernate.cfg.xml:

- Tener la base de datos en el servidor, la base de datos de MySQL. El archivo de respaldo está en la carpeta del respositorio llamada archivos adicionales en las cuales encontrará images también de ayuda.
- Crear un JDBC con los datos de la BD.
- Cambiar los datos de conexión a la base de datos en el archivo hibernate.cfg.xml.

4. Darle al botón run de la palicación para que compile.

Pasos para probar la aplicación:

1. Cuando aprima el botón Run se le abrirá el index de la aplicación  en el explorador.

2. En el index puede loguearse para entrar a la administración o puede diligenciar la encuesta.
- Para loguear y entrar a administración los datos de usuario son: usuario: admin, contraseña: admin.

3. Si se loguea arriba a la derecha en el header de la página puede encontrar el link que lo llevará a administración.
- Si va a administración sin loguearse no se renderiza la vista y lo redirije al index.

Consideraciones:

1. No se usaron relaciones en la base de datos, por eso algunas consultas a la base de datos son ineficientes, dado que algunos datos fueron quemados en el código, como las opciones de género, programas académicos y las bebidas. 

En la carpeta de archivos adicionales encontrará la imagen con el diagrama del modelo de la base de datos.

2. La encuesta puede ser diligenciada por personas entre 16 y 150 años.

3. Como los campos programa, bebida y género están quemados en código y son menús de selección no se realizaron validaciones para estos aunque el formulario aveces las valide y las indique como requeridas, esto se hizo mediante las validaciones de JSF.

4. No se hicieron vistas para Editar, eliminar y modificar usuarios, si desea un usuario diferente agregarlo a la base de datos es la opción.