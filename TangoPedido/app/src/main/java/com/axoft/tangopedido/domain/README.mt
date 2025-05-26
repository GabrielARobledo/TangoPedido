----------------------------------------
📦 Capa Domain
----------------------------------------

## 🔄 Comunicación

- **Los casos de uso** reciben o devuelven modelos de dominio (`Articulo`, `Cliente`, etc.).
- Interactúan con interfaces (`Repository interfaces`) definidas aquí mismo (si aplicara).
- **La implementación real** de estas interfaces ocurre en la capa `data/`.

---

## 🧩 Modelos de dominio

Los modelos aquí son **puros**:
- Sin anotaciones de librerías (ej: Retrofit, Room, etc.).
- Usados en toda la app como contratos centrales.
- Independientes de los detalles técnicos.

Ejemplo:
```kotlin
data class Cliente(
    val id: Int,
    val codigo: String?,
    val razonSocial: String?
)
