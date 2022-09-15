# **Библиотека вспомогательных бинов**

### Подлючение к проекту
1. Добавить репозиторий в проект. Пример для maven:
````
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
````
Для gradle:
````
allprojects {
	repositories {
	...
	maven { url 'https://jitpack.io' }
	}
}
````
2. Добавить зависомость(уточнять последнюю версию). Пример для Maven:
````
<dependency>
	 <groupId>com.github.Lazovski1991</groupId>
	 <artifactId>forAllCore</artifactId>
	 <version>0.1.0</version>
</dependency>
````

Для gradle:
````
dependencies {
   implementation 'com.github.Lazovski1991:forAllCore:0.1.0'
}
````