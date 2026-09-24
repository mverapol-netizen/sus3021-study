# Publicación y compilación en GitHub

Este proyecto está preparado para compilar automáticamente un APK de depuración mediante GitHub Actions.

## Ruta recomendada

1. Crear un repositorio **privado** en GitHub, por ejemplo `sus3021-study`.
2. Subir **el contenido de esta carpeta** a la raíz del repositorio. No subir el ZIP como único archivo.
3. Confirmar que existe `.github/workflows/android-build.yml`.
4. Hacer commit sobre la rama `main`.
5. Abrir la pestaña **Actions** de GitHub y entrar en `Build Android APK`.
6. Cuando termine correctamente, abrir la ejecución y descargar el artefacto `SUS3021Study-debug-apk`.
7. Descomprimir el artefacto: dentro estará `app-debug.apk`.
8. Transferir el APK al teléfono Android e instalarlo. Android puede pedir autorización para instalar aplicaciones desde esa fuente.

## Qué hace GitHub Actions

- Usa JDK 17.
- Instala Android SDK 35 y Build Tools 35.0.0.
- Usa Gradle 8.9, compatible con Android Gradle Plugin 8.7.3.
- Ejecuta `gradle :app:assembleDebug`.
- Guarda `app-debug.apk` como artefacto descargable.

## Importante

GitHub Pages no ejecuta una aplicación Android nativa. GitHub sirve aquí para alojar el código, versionarlo y compilar el APK. Para publicar una aplicación instalable para terceros conviene generar posteriormente un APK/AAB firmado y, si corresponde, distribuirlo mediante GitHub Releases o Google Play.
