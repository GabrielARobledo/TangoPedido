# TangoPedido

----------------------------------------
📦 Proyecto TangoPedido - README General
----------------------------------------

🚀 Propósito  
TangoPedido es una aplicación modular basada en Clean Architecture diseñada para gestionar pedidos, clientes y artículos. Su objetivo es proveer una experiencia fluida y escalable con una arquitectura mantenible y testeable.

------------------------------
📚 Arquitectura  
Se divide en capas bien definidas que separan responsabilidades y facilitan la escalabilidad:

1. Presentation  
   - UI construida con Jetpack Compose.  
   - Comunicación mediante ViewModels que exponen estados (`UiState<T>`) usando StateFlow.  
   - Componentes reutilizables y mapeo a modelos UI (`ItemUiModel`) para desacoplar UI del dominio.  

2. Domain  
   - Contiene modelos de dominio y casos de uso (use cases).  
   - Lógica de negocio pura, independiente de frameworks o detalles de implementación.

3. Data  
   - Maneja fuentes de datos locales y remotas.  
   - Local: base de datos Room para almacenamiento persistente.  
   - Remote: API AxCloud con controlador PedidoMobileController.  
   - Mapper para transformar DTOs, entidades y modelos de dominio.  
   - Repository que unifica la lógica de obtención y persistencia de datos.  

4. DI (Dependency Injection)  
   - Centraliza la configuración de dependencias con Hilt.  
   - Provee Retrofit para consumo API y OkHttpClient para HTTP.  
   - Facilita el desacople y la inyección en toda la app.

------------------------------
🎯 Principios aplicados  
- **Single Responsibility:** Cada módulo y clase tiene una función clara.  
- **Separation of Concerns:** UI, dominio y datos están claramente desacoplados.  
- **Testabilidad:** Fácil creación de pruebas unitarias y de integración.  
- **Reutilización:** Componentes UI y modelos mapeados para múltiples usos.  
- **Consistencia:** Repositorios aseguran una única fuente de verdad sincronizada.

------------------------------
🛠 Tecnologías  
- Kotlin  
- Jetpack Compose  
- StateFlow / LiveData  
- Room (Local DB)  
- Retrofit + OkHttp (API HTTP)  
- Hilt (DI)  
- Clean Architecture

------------------------------
📦 Estructura del proyecto  
- `presentation/`: UI, Composables, ViewModels, UI models.  
- `domain/`: Modelos de dominio y casos de uso.  
- `data/`: Repositorios, fuentes locales/remotas, mappers, DTOs, entidades.  
- `di/`: Configuración de inyección de dependencias.

------------------------------
🚀 Cómo contribuir  
- Seguir principios SOLID y Clean Architecture.  
- Documentar cambios y mantener consistencia de código.  
- Usar los modelos UI para mostrar datos en la UI.  
- Centralizar dependencias en el módulo DI.

------------------------------
📄 Licencia  
Proyecto privado / según licencia interna.

----------------------------------------
