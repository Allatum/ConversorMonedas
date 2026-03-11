Conversor de Monedas
<img width="500" height="500" alt="Badge-Conversor" src="https://github.com/user-attachments/assets/42797711-0b6c-450c-9a95-769049cfcd86" />

Este proyecto es una aplicación de consola en Java que permite conversiones de divisas en tiempo real utilizando la API de ExchangeRate-API

Caracteristicas
---------------------
- Consumo de API externa para obtener tipos de cambios actualizados
- Opciones rápidas para conversiones comunes (Guaraníes, Dólares, Euros, Libras)
- Opcion para ingresar manualmente codigos de monedas
- Validación de datos
- Manejo de claves de API mediante variables de enterno

Tecnologias utilizadas
--------------------------
- Lenguaje: Java 17+
- Librerías: * Gson para el parseo de JSON.
      - java.net.http para las peticiones HTTP.
- API: ExchangeRate-API

Estructura del proyecto
-------------------------------
Sigue los principios de POO y se dividen en
- com.allatum.principal: Contiene la clase Principal que es el punto de entrada que gestiona el ciclo de vida de la aplicación y el menú de usuario.
- com.allatum.modelos:
       - Clase Calculos que se encargada de la lógica de negocio, validación de inputs y almacenamiento temporal de datos de conversión.
- com.allatum.servicios:
       - ConsultaConversion: es la que gestiona la conexión con la API externa y el procesamiento de la respuesta JSON.
       - GeneradorDeArchivos: es la que se encargada de la persistencia de datos, guardando el historial de consultas en un archivo local.


  OBS: Para poder ejecutar este proyecto, se debe configurar tu API Key como una variable de entorno
  Pueden obtener la llave en https://www.exchangerate-api.com/
  Al configurar la variable en su sistema pueden hacerlo así export EXCHANGE_RATE_API_KEY='tu_llave_aqui'

  Galería
  -------------
<img width="613" height="411" alt="image" src="https://github.com/user-attachments/assets/dc63b48c-2bc9-4877-ac68-d93252464e24" />

<img width="563" height="453" alt="image" src="https://github.com/user-attachments/assets/ba8578fe-dfed-4af5-a26a-c7169df06535" />

<img width="572" height="641" alt="image" src="https://github.com/user-attachments/assets/a6ae5987-cd81-49fc-8462-5b0db63e02a7" />






  
