# 📦 presentation/common

Este paquete contiene todos los recursos, componentes y herramientas transversales y reutilizables en la capa **presentation** de la app.

La idea es centralizar lo visual, estético y auxiliar para que ningún feature repita código ni lógica innecesaria.

---

## 📁 Contenido

### 🔸 component/
Componentes UI genéricos hechos en Jetpack Compose.
Se pueden usar en cualquier pantalla.

- **animation/** → animaciones reutilizables.
- **button/** → botones personalizados.
- **card/** → tarjetas (cards) de información.
- **layout/** → helpers de layout (rows, columns, etc.).
- **progress/** → loaders y barras de progreso.
- **scaffold/** → estructuras base como Scaffold custom.
- **text/** → textos y títulos estilizados.
- **textfield/** → campos de texto personalizados.
- **toolbar/** → toolbars y appbars genéricas.

👉 **Regla:** si creás un nuevo componente, organizalo dentro del subfolder adecuado (o creá uno nuevo si no encaja en los existentes).

---

### 🔸 constant/
Constantes globales, principalmente mensajes de error, textos fijos, etc.

- **ErrorConst** → mensajes y claves relacionados a errores.

👉 **Regla:** agrupar por contexto (ej. `ErrorConstants`, `ApiConstants`, `UiConstants`) si empiezan a crecer mucho.

---

### 🔸 mapper/
Mapeadores que transforman modelos de datos entre capas.

- `ItemCardMapper.kt` → transforma entidades a modelos visuales de tipo `ItemCard`.
- `RenglonCardMapper.kt` → idem para renglones.

👉 **Regla:** mantener los mappers finitos y específicos. No poner lógica pesada aquí.

---

### 🔸 state/
Modelos de estado generalizados.

- `UiState` → envoltorio para representar Loading, Success, Error, etc.

👉 **Regla:** extender este patrón si creás nuevos tipos de estados globales.

---

### 🔸 theme/
Configuración visual general de la app.

- `Color.kt` → paleta de colores.
- `Type.kt` → tipografías.
- `Theme.kt` → tema Compose principal.
- `Extensions.kt` → helpers visuales relacionados a tema (si aplica).

👉 **Regla:** todo cambio de estilo debe reflejarse acá, no directamente en los componentes.

---

## 🌟 Buenas prácticas

✅ Usá siempre componentes de `common/component` en vez de crear visuales duplicados en cada feature.
✅ Si necesitás helpers o extensiones, ponelos en carpetas claras (`utils`, `extensions`) para no mezclar con visual.
✅ Documentá brevemente cada componente nuevo para que otros sepan usarlo.
✅ Si un componente empieza a crecer mucho en variantes, considerá separarlo en subcomponentes.

---

## 📌 Nota final

Esta carpeta es clave para mantener consistencia y escalabilidad en la app.
¡Asegurate de mantenerla limpia, ordenada y bien documentada! 💪✨

