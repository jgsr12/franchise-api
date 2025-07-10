
# 📦 Franchise API - Prueba Técnica Backend (Accenture)

API REST desarrollada en **Spring Boot** para gestionar franquicias, sucursales y productos, como parte de una prueba técnica para Accenture.

---

## 📌 Funcionalidades

- Crear franquicia
- Agregar sucursales a una franquicia
- Agregar productos a una sucursal
- Eliminar productos
- Modificar el stock de un producto
- Obtener el producto con mayor stock de una sucursal
- Actualizar nombre de franquicia, sucursal o producto (punto extra)
- Dockerización completa de base de datos y backend

---

## 🧰 Tecnologías utilizadas

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- MySQL 8 (Docker)
- Maven
- Docker + Docker Compose
- Postman (para pruebas)

---

## ⚙️ Requisitos previos

- [Docker](https://www.docker.com/products/docker-desktop/)
- [Git](https://git-scm.com/)
- [Postman](https://www.postman.com/)

---

## 🚀 Instalación y ejecución con Docker

1. Clona el repositorio:

```bash
git clone https://github.com/tu-usuario/franchise-api.git
cd franchise-api
```

2. Ejecuta los contenedores con Docker Compose:

```bash
docker-compose up --build
```

Esto levantará:
- MySQL 8 en el puerto `3307`
- Spring Boot API en el puerto `4400`

---

## 📮 Endpoints disponibles

### ✅ Franquicias

| Método | Endpoint               | Descripción                  |
|--------|------------------------|------------------------------|
| POST   | `/api/franchises`      | Crear nueva franquicia       |
| GET    | `/api/franchises`      | Listar todas las franquicias |
| GET    | `/api/franchises/{id}` | Obtener franquicia por ID    |
| PUT    | `/api/franchises/{id}` | Editar nombre de franquicia  |

### ✅ Sucursales

| Método | Endpoint                                      | Descripción                   |
|--------|-----------------------------------------------|-------------------------------|
| POST   | `/api/franchises/{franchiseId}/branches`      | Agregar sucursal a franquicia |
| PUT    | `/api/franchises/{franchiseId}/branches/{id}` | Editar nombre de sucursal     |

### ✅ Productos

| Método | Endpoint                                 | Descripción                    |
|--------|------------------------------------------|--------------------------------|
| POST   | `/api/branches/{branchId}/products`      | Agregar producto a sucursal    |
| DELETE | `/api/products/{productId}`              | Eliminar producto              |
| PUT    | `/api/products/{productId}/stock`        | Modificar stock de un producto |
| PUT    | `/api/products/{productId}/name`         | Modificar nombre del producto  |
| GET    | `/api/branches/{branchId}/highest-stock` | Obtener producto con más stock |

---

## 📬 Ejemplos en Postman

> URL base: `http://localhost:4400`

### 🔹 Crear franquicia

**POST** `/api/franchises`

```json
{
  "name": "Franquicia Norte"
}
```

### 🔹 Agregar sucursal a franquicia

**POST** `/api/franchises/1/branches`

```json
{
  "name": "Sucursal Medellín"
}
```

### 🔹 Agregar producto a sucursal

**POST** `/api/branches/1/products`

```json
{
  "name": "Hamburguesa Clásica",
  "stock": 50
}
```

### 🔹 Modificar stock de producto

**PUT** `/api/products/1/stock`

```json
{
  "newStock": 100
}
```

### 🔹 Modificar nombre del producto

**PUT** `/api/products/1/name`

```json
{
  "newName": "Hamburguesa Doble"
}
```

### 🔹 Obtener producto con mayor stock

**GET** `/api/branches/1/highest-stock`

### 🔹 Eliminar producto

**DELETE** `/api/products/1`

---

## ✅ Pruebas

- Usa **Postman** con los ejemplos anteriores
- Asegúrate que el contenedor `franchise-api` esté corriendo (`http://localhost:4400`)
- Verifica logs con `docker logs franchise-api`

---

## 🧪 Extras Implementados

✅ Dockerizado completamente  
✅ Uso de variables de entorno  
✅ Endpoints adicionales de actualización  
✅ Conexión a base de datos persistente  
✅ Se aplicó programación funcional con uso de `Streams` y `Lambdas` en operaciones sobre colecciones.
❌ No se implementó programación reactiva (WebFlux), ya que no era requerida por el alcance de la prueba.
☁️ Despliegue en la nube:

🚧 En proceso de despliegue en **Railway** (https://railway.app) desde el repositorio:

🔗 https://github.com/jgsr12/franchise-api

Se actualizará esta sección una vez finalice el despliegue con la URL pública.

---

## 👨‍💻 Autor

**Juan Guillermo Soto Rincón**  
Desarrollador Fullstack  
📧 rincom1244@gmail.com
