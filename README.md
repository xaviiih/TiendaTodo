# TiendaTodo

## Integrantes
- Xavier Ojeda
- Arlete Patiño

## Descripción
Sistema de gestión de tienda de ropa basado en arquitectura de microservicios con Spring Boot. 
Permite gestionar clientes, productos, vendedores, proveedores, ventas, carritos, envíos, 
pagos, sucursales y valoraciones de forma independiente y escalable.

## Funcionalidades implementadas
- CRUD de Clientes
- CRUD de Productos
- CRUD de Vendedores
- CRUD de Proveedores
- CRUD de Carritos
- Gestión de Ventas con comunicación entre microservicios (Feign Client)
- Gestión de Envíos con validación de estado de venta
- CRUD de Pagos
- CRUD de Sucursales
- CRUD de Valoraciones
- Validaciones con Bean Validation en todos los servicios
- Manejo de errores con ResponseEntity y GlobalExceptionHandler
- Logs con SLF4J en todos los servicios
- Comunicación entre microservicios mediante Feign Client

## Tecnologías utilizadas
- Java 17
- Spring Boot 4.0.6
- Spring Data JPA + Hibernate
- Oracle, Visual Studio Code, Apache Netbeans
- OpenFeign
- Bean Validation
- Maven

## Microservicios

| Servicio | Puerto | Ruta base |
|---|---|---|
| carrito-service | 1080 | `/API/V1/carritos` |
| envio-service | 1081 | `/API/V1/envios` |
| cliente-service | 1082 | `/API/V1/clientes` |
| venta-service | 1083 | `/API/V1/ventas` |
| producto-service | 1084 | `/API/V1/productos` |
| vendedor-service | 1085 | `/API/V1/vendedores` |
| proveedor-service | 1086 | `/API/V1/proveedores` |
| valoracion-service | 1087 | `/API/V1/valoraciones` |
| sucursal-service | 1088 | `/API/V1/sucursales` |
| pago-service | 1089 | `/API/V1/pagos` |

## Cómo ejecutar

### Requisitos previos
- Java 17 o superior
- Maven
- Wallet oracle

### Pasos
1. Configurar la variable de entorno del Wallet antes de ejecutar cada servicio:
```powershell
$env:TNS_ADMIN="D:/Wallet"
```
2. Entrar a la carpeta de cada microservicio y ejecutar:
```powershell
.\mvnw.cmd spring-boot:run "-Dmaven.test.skip=true"
```
3. Probar los endpoints con Postman usando las rutas indicadas en la tabla anterior.

### Notas importantes
- La URL de conexión en `application.properties` debe ser `jdbc:oracle:thin:@bd2_low`
- No incluir la ruta del Wallet en la URL, solo usar la variable de entorno
- Cada servicio tiene configurado el pool de conexiones con máximo 2 conexiones
