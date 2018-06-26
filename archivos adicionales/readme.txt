Pasos para abrir el proyecto:

1. Clonar o descagar el repositorio de GitHub.

2. Dentro de la carpeta del repositorio hay otra carpeta llamada encuesta. Esta carpeta es un proyecto de Netbeans. Por lo tanto en netbeans seleccionamos la opci�n de abrir proyecto y buscamos esta carpeta.

3. Configurar el archivo de hibernate.cfg.xml:

- Tener la base de datos en el servidor, la base de datos de MySQL. El archivo de respaldo est� en la carpeta del respositorio llamada archivos adicionales en las cuales encontrar� images tambi�n de ayuda.
- Crear un JDBC con los datos de la BD.
- Cambiar los datos de conexi�n a la base de datos en el archivo hibernate.cfg.xml.

4. Darle al bot�n run de la palicaci�n para que compile.

Pasos para probar la aplicaci�n:

1. Cuando aprima el bot�n Run se le abrir� el index de la aplicaci�n  en el explorador.

2. En el index puede loguearse para entrar a la administraci�n o puede diligenciar la encuesta.
- Para loguear y entrar a administraci�n los datos de usuario son: usuario: admin, contrase�a: admin.

3. Si se loguea arriba a la derecha en el header de la p�gina puede encontrar el link que lo llevar� a administraci�n.
- Si va a administraci�n sin loguearse no se renderiza la vista y lo redirije al index.

Consideraciones:

1. No se usaron relaciones en la base de datos, por eso algunas consultas a la base de datos son ineficientes, dado que algunos datos fueron quemados en el c�digo, como las opciones de g�nero, programas acad�micos y las bebidas. 

En la carpeta de archivos adicionales encontrar� la imagen con el diagrama del modelo de la base de datos.

2. La encuesta puede ser diligenciada por personas entre 16 y 150 a�os.

3. Como los campos programa, bebida y g�nero est�n quemados en c�digo y son men�s de selecci�n no se realizaron validaciones para estos aunque el formulario aveces las valide y las indique como requeridas, esto se hizo mediante las validaciones de JSF.

4. No se hicieron vistas para Editar, eliminar y modificar usuarios, si desea un usuario diferente agregarlo a la base de datos es la opci�n.