# Sistema de Gestión de Inventario Inventory Management System 

Aplicación de escritorio desarrollada en Java con JavaFX para la gestión de inventario y registro de ventas. Este proyecto demuestra la implementación de una arquitectura de 3 capas (Presentación, Lógica y Datos) y el manejo de persistencia de datos a través de serialización.



##  Características Principales

* **Gestión de Inventario:** Permite crear, editar y eliminar productos del inventario.
* **Módulo de Ventas:** Interfaz intuitiva para seleccionar productos y registrar ventas.
* **Historial de Ventas:** Visualización detallada de todas las transacciones realizadas, incluyendo fecha y total.
* **Persistencia de Datos:** Toda la información se guarda localmente, asegurando que los datos no se pierdan al cerrar la aplicación.

##  Tecnologías Utilizadas

* **Lenguaje:** Java 23 (OpenJDK)
* **Interfaz Gráfica:** JavaFX 24
* **IDE:** IntelliJ IDEA
* **Gestión de Versiones:** Git y GitHub

---
##  Guía de Instalación y Ejecución

Sigue estos pasos para ejecutar el proyecto localmente.

### Prerrequisitos

* Java JDK (versión 21 o superior).
* JavaFX SDK (versión 24 o superior).
* Git para clonar el repositorio.

### Pasos de Configuración

1.  **Clonar el Repositorio:**
    ```bash
    git clone [https://github.com/Alessito54/Inventario-JavaFX.git](https://github.com/Alessito54/Inventario-JavaFX.git)
    cd Inventario-JavaFX
    ```

2.  **Abrir en IntelliJ IDEA:**
    * Abre IntelliJ IDEA y selecciona `File > Open...` y elige la carpeta clonada.

3.  **Configurar JavaFX:**
    * Añade el SDK de JavaFX a las librerías del proyecto (`File > Project Structure... > Libraries`).
    * Añade las siguientes opciones en la configuración de ejecución (`Run > Edit Configurations... > VM options`), **cambiando la ruta a donde tengas tu SDK de JavaFX**:

    ```text
    --module-path "C:\ruta\a\tu\javafx-sdk-24.0.2\lib" --add-modules javafx.controls,javafx.fxml
    ```

4.  **Ejecutar:**
    * Localiza y ejecuta la clase `Main.java`.
