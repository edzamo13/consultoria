# Plantilla Base para la coodificación de microservicios.

## Activar Lombok

1. Sts.ini
2. Agregar Lineas
'''
	-javaagent:E:\lmb\lombok.jar
	-Xbootclasspath/a:E:\lmb\lombok.jar
'''

## Servicio Api Rest



    Brigada : Rest Api de Brigada
        Show/Hide
        List Operations
        Expand Operations
            delete /brigada/brigada

                Delete una nueva brigada
            post /brigada/brigada

                creaBrigada
            put /brigada/brigadaAll

                Actualiza una nueva brigada
            get /brigada/findAll

                Busca todas brigada
            get /brigada/findById/{id}

                Busca brigada por Id

###



# Resolver problema de lombok

* Incluir pom en Maven.
* Salir/apagado STS
* Encuentra Jar Lombok en ~/.m2/repositorio/org/projectlombok/Lombok/version.x
* desde el símbolo/Shell java -jar lombok-1.x.y.jar 