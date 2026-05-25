# tarea-procesamiento-masivo-java

\# Laboratorio: Procesamiento Masivo de Datos y Optimización en Java



\* Nombre Completo: Edwin Oswaldo Cortez Tita

\* Actividad: Tarea XII - Mejora de Código



\## 📝 Descripción del Proyecto

Este proyecto aborda el problema de procesar y agrupar grandes volúmenes de datos información simulada de clientes y campañas de manera eficiente se implementaron y compararon dos enfoques principales para medir la complejidad algorítmica en entornos reales:



1\. Enfoque Ineficiente (Base):Procesamiento secuencial tradicional con búsquedas repetitivas de alta complejidad temporal.

2\. Enfoque Optimizado: Implementación basada en la estructura de datos HashMap, permitiendo búsquedas y agrupaciones en tiempo constante.



\## 📊 Resultados de Rendimiento



A continuación se detallan las métricas obtenidas durante la ejecución masiva del programa utilizando el volumen de datos completo solicitado de 2,000,000 de registros:



&#x20;Métrica / Fase | Valor Registrado |

&#x20;\*Cantidad de Clientes: 2,000,000 clientes 

&#x20;\*Tiempo de Generación del CSV: 114,277 ms (1.9 minutos) 

&#x20;\*Memoria JVM Usada Inicial (Fase Generación): 51 MB 

&#x20;\*Memoria JVM Total Asignada: 126 MB 

&#x20;\*Memoria JVM Máxima Permitida: 1,984 MB 



\### 🔍 Conclusión del Análisis e Incidente Técnico:

Durante la fase de Carga de TODOS los clientes en memoria, el programa experimentó una excepción crítica de falta de memoria: java.lang.OutOfMemoryError: Java heap space. 



El error se originó específicamente en el método ProcesadorMalo.cargarTodosLosClientes al intentar procesar las cadenas de texto mediante el método String.split(). Esto demuestra que la recreación simultánea e indexación secuencial de 2 millones de objetos String dentro de los límites de la memoria dinámica asignada a la Máquina Virtual de Java (Heap de 1,984 MB) satura el recolector de basura (Garbage Collector). Como solución y investigando determine que para procesar esta escala de datos masivos de forma continua se requiere la optimización de lectura por flujos (Streams/Buffers), el incremento del parámetro -Xmx en la JVM, o el procesamiento segmentado de la información.



\## 🛠️ Tecnologías Utilizadas

\* \*Lenguaje:\* Java 24

\* \*IDE:\* IntelliJ IDEA

\* \*Gestor de Versiones:\* Git / GitHub Desktop



\## 🚀 Cómo Ejecutar el Proyecto



1\. Clona este repositorio en tu máquina local.

2\. Abre la carpeta del proyecto (actividad1) en IntelliJ IDEA.

3\. Asegúrate de tener configurado el SDK de Java 24.

4\. Abre el archivo src/Main.java y ejecuta el método principal haciendo clic en el botón de Play verde junto a la línea de código.

