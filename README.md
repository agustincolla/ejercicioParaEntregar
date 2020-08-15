# ejercicioParaEntregar
1) Iniciar la base de datos postgres en un docker usando el comando docker run --name postgres-spring -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine , despues docker ps para obtener el id del container , luego ejecutar exec -it ContainerId bin/bash ,seguido ejecutamos el comando psql -U postgres, despues usamos el comando CREATE DATABASE demodb; y al final \c demodb.
2) Levantar el servidor ejecutando el proyecto . 
3) Probar desde un navegador.   