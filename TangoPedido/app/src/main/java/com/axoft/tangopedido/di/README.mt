----------------------------------------
📦 Módulo DI
----------------------------------------

🚦 Propósito
Centralizar la configuración de dependencias para facilitar inyección, reutilización y desacoplamiento usando:
- Hilt (inyección de dependencias)
- Retrofit (consumo de APIs REST)
- OkHttpClient (configuración HTTP)

---

🧩 Contenido
- Módulos @Module con @Provides para objetos singleton (Retrofit, OkHttpClient, servicios).
- Alcance singleton con @InstallIn(SingletonComponent::class).
- Integración transparente para otras capas.

---

⚙️ Principios
- Single Responsibility: Solo configuración, sin lógica de negocio.
- Inversión de Control: Dependencias inyectadas, no creadas directamente.
- Testabilidad: Facilita mocks y pruebas.

---

🚀 Uso
- Añadir proveedores con @Provides.
- Inyectar con @Inject.
- Mantener organización modular.

---

🧼 Buenas prácticas
- Evitar lógica de negocio o acceso a datos aquí.
- Mantener configuraciones limpias y documentadas.
