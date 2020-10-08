api_dinardap.

Pre condicionantes

* Servicios SOAP Dinardap V2

http://interoperabilidad.dinardap.gob.ec/interoperador-v2


* IMPORTACION DE CERTIFICADO PARA CONSUMO DE LA DINARDAP AL SRI
keytool -import -alias dinardapgobec -keystore /usr/java/jdk1.8.0_241-amd64/jre/lib/security/cacerts -file dinardapgobec.crt -storepass changeit

* Servicios Sri punto a punto

https://wsprodu.registrocivil.gob.ec/WsRegistroCivil/ConsultaCiudadano

Implementaci¢n

Proyecto SpringBoot Arquitetcura REST, permite la interoperar con los servicios de dinerdap (SOAP) y Registro Civil


*  id	codigoPaquete	tipoIdentificacion	Detalle de fuente
*  1	codigoPaquete	identificacion	Registro Civil
*  2	codigoPaquete	valor	 "Ant peticion 1"
*  3	codigoPaquete	valor	Ant peticion 2
*  4	codigoPaquete	identificacion 	Cosejo Nacional Electoral
*  5	codigoPaquete	identificacion	Senescyt consulta titulo
*  6	codigoPaquete	identificacion	Servicio Nacional de Contrataci¢n P£blica
*  7	codigoPaquete	identificacion 	Instituto Ecuatoriano de Seguridad Social
*  8	codigoPaquete	identificacion	Policia
*  9	codigoPaquete	identificacion	Superintendencia de Compa¤ias Datos Compan¡a
*  10	codigoPaquete	identificacion	Servicio de Rentas Internas 101ÿ 
*  11	codigoPaquete	identificacion	Servicio de Rentas Internas 102
*  12	codigoPaquete	identificacion	Servicio de Rentas Internas 104
*  13	codigoPaquete	identificacion	Servicio de Rentas Internas 2
*  14	codigoPaquete	identificacion	Servicio de Rentas Internas 1
*  15	codigoPaquete	codigoAutorizacion	Servicio de Rentas Internas AUTORIZACION EMISION
*  16	codigoPaquete	identificacion	Registro Civil


