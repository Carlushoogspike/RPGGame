pluginManagement {
    plugins {
        kotlin("jvm") version "2.0.21"
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "RPGGame"

include("rpg-micro-service")
include("rpg-game-engine")
include("rpg-config")
include("rpg-docs")
include("rpg-core")
