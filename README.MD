

## Pasos para Levantar la Aplicación Spring Boot

### 1. **Instalar Dependencias**

Asegúrate de tener instaladas las siguientes herramientas en tu máquina local:

- **Java 17**: Asegúrate de tener instalado Java en tu máquina. Puedes verificarlo con el siguiente comando:

```bash
java --version
```

- **Maven o Gradle**: El proyecto puede estar configurado con Maven o Gradle. Asegúrate de tener uno de estos administradores de dependencias instalados. Si no los tienes, puedes instalarlos desde sus sitios oficiales.

### 2. **Crear la Base de Datos**

Antes de iniciar la aplicación, asegúrate de tener una base de datos MySQL creada. Si no tienes MySQL instalado, puedes descargarlo desde [aquí](https://dev.mysql.com/downloads/installer/).

Para crear la base de datos, abre tu consola de MySQL y ejecuta el siguiente comando:

```sql
CREATE DATABASE calificaciones;
```

Asegúrate de reemplazar `calificaciones` con el nombre de la base de datos que prefieras si es necesario.

## 3. Pasos para Configurar Variables de entorno

1. **Crea el archivo `.env`**  
   Crea un archivo `.env`  en el directorio raíz del proyecto.

2. **Agrega las Variables Requeridas**  
   Añade las siguientes variables al archivo `.env`:

   ```properties
   SPRING_DATASOURCE_URL=jdbc:mysql://<HOST>:<PORT>/<DATABASE_NAME>
   SPRING_DATASOURCE_USERNAME=<DATABASE_USERNAME>
   SPRING_DATASOURCE_PASSWORD=<DATABASE_PASSWORD>
   ```

   - `<HOST>`: La dirección del servidor de tu base de datos (por ejemplo, localhost).
   - `<PORT>`: El número de puerto de tu servidor de base de datos (por ejemplo, 3306 para MySQL).
   - `<DATABASE_NAME>`: El nombre de tu base de datos.
   - `<DATABASE_USERNAME>`: El nombre de usuario para tu base de datos.
   - `<DATABASE_PASSWORD>`: La contraseña para tu base de datos.

   **Ejemplo de Configuración**  
   Aquí tienes un ejemplo de configuración para una base de datos MySQL local:

   ```properties
   SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/calificaciones
   SPRING_DATASOURCE_USERNAME=root
   SPRING_DATASOURCE_PASSWORD=root
   ```

3. **Verifica la Configuración**  
   Asegúrate de que el archivo `.env` esté configurado correctamente y guardado. La aplicación cargará automáticamente estas variables cuando se inicie.

4. **Nota de Seguridad**  
   No cometas el archivo `.env` en el control de versiones. El archivo `.gitignore` ya incluye una entrada para excluir los archivos `.env`.

## ¿Cómo Funciona?

La aplicación utiliza el archivo `.env` para cargar dinámicamente las siguientes propiedades en `application.properties`:

- `spring.datasource.url`
- `spring.datasource.username`
- `spring.datasource.password`

Estas propiedades se resuelven utilizando la sintaxis `${}`, que obtiene los valores del archivo `.env` durante la ejecución.

### 4. **Iniciar la Aplicación Spring Boot**

Con el archivo `.env` configurado y la base de datos creada, ahora puedes iniciar la aplicación. Dependiendo del gestor de dependencias que estés utilizando (Maven o Gradle), ejecuta uno de los siguientes comandos en la raíz de tu proyecto:

- **Si usas Maven**:

  ```bash
  ./mvnw spring-boot:run
  ```

- **Si usas Gradle**:

  ```bash
  ./gradlew bootRun
  ```

Este comando iniciará el servidor y la aplicación Spring Boot. Deberías ver algo como esto en la consola:

```
Tomcat started on port 8080 (http) with context path '/' ''
Started CalificacionesApplication in 1.968 seconds (process running for 2.148)
```

### 5. **Acceder a la Aplicación**

Una vez que la aplicación esté en funcionamiento, puedes acceder a ella en tu navegador en la siguiente URL:

```
http://localhost:8080
```

### 6. **Verificar la Conexión a la Base de Datos**

La aplicación Spring Boot debería conectarse automáticamente a la base de datos utilizando los valores configurados en el archivo `.env`. Puedes verificar que todo está funcionando correctamente consultando los registros en la consola.

## Solución de Problemas

- Si la aplicación no se conecta a la base de datos, asegúrate de que los parámetros en el archivo `.env` estén configurados correctamente (como el nombre de la base de datos, el puerto y las credenciales).
- Si el servidor de base de datos no está corriendo, asegúrate de haber iniciado MySQL.
