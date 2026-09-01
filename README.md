\# Microservicio Perfulandia - Evaluación Parcial 1



\## Integrantes del Equipo

\- \*\*Integrante 1:\*\* Antoane Anticoi





\---



\## 1. Justificación de la Estrategia de Ramificación (GitFlow)

Para el desarrollo del microservicio \*\*Perfulandia\*\* se implementó \*\*GitFlow\*\* para los siguientes motivos técnicos:

\- \*\*Trazabilidad y Estabilidad:\*\* Garantiza que la rama `main` mantenga código probado y listo para producción.

\- \*\*Desarrollo Paralelo:\*\* Permite la integración continua en `develop` a través de ramas `feature/` sin interferir con el trabajo de otros desarrolladores.

\- \*\*Atención Inmediata a Errores:\*\* Facilita la creación de ramas `hotfix/` para solucionar incidencias en producción sin pausar el desarrollo en `develop`.



\---



\## 2. Convenciones y Buenas Prácticas del Repositorio



\### Naming Strategy (Ramas)

\- `main`: Código estable en producción.

\- `develop`: Rama principal para la integración de desarrollo.

\- `feature/<nombre>`: Nuevas características (Ej: `feature/catalogo-perfumes`, `feature/modulo-ventas`).

\- `hotfix/<nombre>`: Correcciones críticas de producción (Ej: `hotfix-puerto`).



\### Estándar de Commits (Conventional Commits)

\- `feat:` Nuevas funcionalidades.

\- `fix:` Correcciones de errores.

\- `docs:` Cambios en la documentación.

\- `chore:` Tareas de mantenimiento o configuración de CI/CD.



\### Estrategia de Merge y Revisiones

\- Prohibidos los push directos a `main` y `develop`.

\- Todo cambio se integra mediante un \*\*Pull Request (PR)\*\* con revisión previa.



\---



\## 3. Integración Continua (GitHub Actions)

Configurada en `.github/workflows/ci.yml` para ejecutarse en:

\- Cada `push` hacia la rama `develop`.

\- Cada `pull request` con destino a la rama `main`.



\---



\## 4. Declaración del Uso de Inteligencia Artificial

\- \*\*Herramienta utilizada:\*\* Gemini / Claude.

\- \*\*Uso aplicado:\*\* Asistencia en la composición Markdown para la documentación y revisión de sintaxis del archivo YAML de GitHub Actions.

\- \*\*Declaración:\*\* Las decisiones arquitectónicas, configuración de GitFlow y pruebas fueron validadas y ejecutadas.



\---



\## 5. Reflexion Individual Obligatoria



\### Reflexión de Antoane Anticoi

\*Apliqué algo de memoria y buenas prácticas de CI/CD, evaluando así mi conocimiento y aprendiendo más en base a lo que es un desarrollador operacional. .\*





