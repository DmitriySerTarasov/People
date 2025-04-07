plugins {
    id 'java'
}

group 'ru.netology'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
    include 'db'
    include 'service'
    include 'api'
}

dependencies {
    implementation project(":db")
    implementation project(":service")

}