# utilities

## Utilidades módulo PMDM Android + Jetpack Composes IES Balmis

### Paso 1: En el fichero **`settings.gradle.kts`** añade...

```kotlin
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
    // AÑADIR -----------------------
    maven(url = "https://jitpack.io")
    // ------------------------------
  }
}
```

### Paso 2: Añade dependencia en **`build.gradle.kts`** del módulo de nuestra app

```kotlin
dependencies {
  implementation("com.github.pmdmiesbalmis:composables:1.0")
}
```

[![](https://jitpack.io/v/pmdmiesbalmis/composables.svg)](https://jitpack.io/#pmdmiesbalmis/composables)
