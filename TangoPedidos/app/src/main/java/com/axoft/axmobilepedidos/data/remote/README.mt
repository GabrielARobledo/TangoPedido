----------------------------------------
📦 Capa Data
----------------------------------------

🚦 Propósito  
Gestionar el acceso y manipulación de datos desde diferentes fuentes, garantizando una única fuente de verdad para la aplicación.

---

🧩 Contenido principal  
- Local: Base de datos local usando Room para almacenamiento persistente.  
- Remote: Acceso a API externa AxCloud, comunicándose con el controlador PedidoMobileController.  
- Mapper: Convierte entre DTOs, entidades de base de datos y modelos de dominio.  
- Repository: Orquesta la lógica de obtención y persistencia de datos, combinando fuentes local y remota.

---

⚙️ Principios aplicados  
- Single Responsibility: Cada componente tiene una función clara (remote, local, mapeo, repositorio).  
- Abstracción: El repository oculta detalles de las fuentes de datos a las capas superiores.  
- Consistencia: Se mantiene una única fuente de verdad sincronizando local y remoto.  
- Testabilidad: Facilita pruebas unitarias mediante la separación de responsabilidades.

---

🚀 Uso  
- Consultar y actualizar datos a través del repository.  
- Mapper transforma los datos entre capas para evitar acoplamientos.  
- Room gestiona el almacenamiento local y cacheo.  
- Retrofit (u otra librería HTTP) se usa para el acceso remoto a AxCloud.

---

🧼 Buenas prácticas  
- Mantener las entidades y DTOs bien definidas y separadas.  
- Evitar lógica de negocio compleja en repository; delegar a la capa dominio.  
- Documentar mappers y repositorios para facilitar mantenimiento.
