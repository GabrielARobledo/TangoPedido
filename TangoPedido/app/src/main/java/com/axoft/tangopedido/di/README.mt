# 📦 Módulo DI (Dependency Injection)

---

## 🚦 Propósito
Centralizar la configuración de dependencias clave para:
- 🔌 Inyección con **Hilt**.
- 🌐 Consumo de APIs REST con **Retrofit**.
- ⚙️ Configuración HTTP con **OkHttpClient**.
- 💾 Base de datos local con **Room** (si aplica).

Permite desacoplar componentes, reutilizar servicios y facilitar testing.

---

## 🧩 Contenido

- **Módulos `@Module` con `@Provides`** → para exponer objetos compartidos.
- **Alcance singleton con `@InstallIn(SingletonComponent::class)`** → garantiza instancias únicas durante toda la app.
- **Integración con otras capas (Domain, Data, Presentation)** → sin acoplar dependencias concretas.

---

## ⚙️ Principios clave

✅ **Single Responsibility**
Cada módulo DI solo configura dependencias, nunca lógica de negocio.

✅ **Inversión de Control**
Las dependencias son inyectadas, no instanciadas manualmente.

✅ **Testabilidad**
Facilita mocks y reemplazos en pruebas unitarias e instrumentadas.

---