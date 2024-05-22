# HDT10

- Jorge Palacios- 231385
  
# Descripción del Programa

Este proyecto implementa un programa en Java para calcular la ruta más corta entre ciudades en un grafo ponderado, utilizando el algoritmo de Floyd-Warshall. Además, permite la actualización dinámica del grafo en respuesta a interrupciones de tráfico o establecimiento de nuevas conexiones entre ciudades.

## Funcionalidades Principales

- **Cálculo de Rutas**: Encuentra la ruta más corta entre cualquier par de ciudades en el grafo, utilizando el algoritmo de Floyd-Warshall.
  
- **Gestión de Grafo**: Permite la lectura de un archivo de texto que representa el grafo con las ciudades y las distancias entre ellas. Además, facilita la adición o eliminación de arcos para reflejar cambios en la red vial.

- **Identificación del Centro del Grafo**: Determina la ciudad que está en el centro del grafo, lo que puede ser útil para la ubicación estratégica de las oficinas centrales de logística.

## Uso del Programa

1. **Ejecución**: Ejecuta el programa Java proporcionando el archivo de texto que representa el grafo como argumento.

2. **Interacción**: El programa muestra un menú interactivo que permite al usuario:
   - Encontrar la ruta más corta entre dos ciudades.
   - Mostrar la ciudad en el centro del grafo.
   - Modificar el grafo añadiendo o eliminando rutas.
   - Finalizar el programa.

3. **Actualización del Grafo**: Se pueden realizar cambios dinámicos en el grafo, como la interrupción de tráfico entre ciudades o el establecimiento de nuevas conexiones. Después de cada modificación, se recalculan las rutas más cortas y se determina nuevamente el centro del grafo.

## Requisitos del Sistema

- Java JDK instalado en el sistema.
- Archivo de texto "guategrafo.txt" que representa el grafo en este formato :
  
![Screenshot 2024-05-21 at 8 53 16 PM](https://github.com/Palasuwu/Algoritmos-y-estructura-de-datos-HDT10/assets/134471477/9b057bb1-db6a-4c01-bcc6-d1c295927f5e)



## Diagrama de Clases UML 

![HDT10-UML](https://github.com/Palasuwu/Algoritmos-y-estructura-de-datos-HDT10/assets/134471477/d5c6d09a-cf84-403d-9717-54368f0a4b5a)

## Funcionalidades Principales

- **Cálculo de Rutas**: Encuentra la ruta más corta entre cualquier par de ciudades en el grafo, utilizando el algoritmo de Floyd-Warshall.
  
- **Gestión de Grafo**: Permite la lectura de un archivo de texto que representa el grafo con las ciudades y las distancias entre ellas. Además, facilita la adición o eliminación de arcos para reflejar cambios en la red vial.

- **Identificación del Centro del Grafo**: Determina la ciudad que está en el centro del grafo, lo que puede ser útil para la ubicación estratégica de las oficinas centrales de logística.

## Uso del Programa


**Interacción**: El programa muestra un menú interactivo que permite al usuario:
   - Encontrar la ruta más corta entre dos ciudades.
   - Mostrar la ciudad en el centro del grafo.
   - Modificar el grafo añadiendo o eliminando rutas.
   - Finalizar el programa.

**Actualización del Grafo**: Se pueden realizar cambios dinámicos en el grafo, como la interrupción de tráfico entre ciudades o el establecimiento de nuevas conexiones. Después de cada modificación, se recalculan las rutas más cortas y se determina nuevamente el centro del grafo.

## Capturas de Pantalla del Programa 

![Screenshot 2024-05-21 at 8 59 36 PM](https://github.com/Palasuwu/Algoritmos-y-estructura-de-datos-HDT10/assets/134471477/3a32e05b-418d-47fc-93b2-e423e5103772)

![Screenshot 2024-05-21 at 9 00 17 PM](https://github.com/Palasuwu/Algoritmos-y-estructura-de-datos-HDT10/assets/134471477/a1ecc63d-51ec-4855-9f17-7aa97bd29568)

![Screenshot 2024-05-21 at 9 01 20 PM](https://github.com/Palasuwu/Algoritmos-y-estructura-de-datos-HDT10/assets/134471477/051d07e5-1c1c-4f00-9c06-3dac54824bbf)

![Screenshot 2024-05-21 at 9 02 17 PM](https://github.com/Palasuwu/Algoritmos-y-estructura-de-datos-HDT10/assets/134471477/3018c98f-691c-425b-9823-261805bc52ae)


