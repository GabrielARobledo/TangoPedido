----------------------------------------
📦 Capa Presentation
----------------------------------------

## 🚦 Comunicación
La capa de presentación **no accede directamente a datos** ni realiza lógica de negocio. En cambio:

- Se comunica con `ViewModel`, quien expone `StateFlow` o `LiveData`.
- El `ViewModel` traduce los datos del dominio a modelos entendibles por la UI (por ejemplo, `ItemUiModel`).

---

## 👩‍🎨 Principios aplicados
- **Single Responsibility**: Cada Composable tiene una responsabilidad bien definida.
- **Separation of Concerns**: No hay lógica de negocio o acceso a datos aquí.
- **Testabilidad**: La UI puede ser testeada con previews o tests instrumentados.

---

## 🧩 Reutilización
- Los componentes reutilizables están en `common/component/`.
- Si varios modelos distintos usan una misma UI, se pueden mapear a un `UiModel` común.

---

## 🧼 Buenas prácticas
- Usar `@Composable` para funciones puramente visuales.
- Evitar lógica de negocio.
- Mantener funciones pequeñas y legibles.
- Separar UI state (`UiState<T>`) del modelo de dominio.

---

> Esta estructura facilita la escalabilidad, el mantenimiento y la legibilidad de la aplicación.