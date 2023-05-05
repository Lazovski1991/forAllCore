# **Library extra beans**

For support spring-boot-3 exist branch spring3 and now it is developing and testing. For work with version spring boot 2.*.* now exist last version with tag 0.2.2.


### Connection with project
1. Add repository in project. Example for maven:
````
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
````
For gradle:
````
allprojects {
	repositories {
	...
	maven { url 'https://jitpack.io' }
	}
}
````
2. Add dependency(Specify last version). Example for Maven:
````
<dependency>
	 <groupId>com.github.Lazovski1991</groupId>
	 <artifactId>forAllCore</artifactId>
	 <version>0.2.0</version>
</dependency>
````

For gradle:
````
dependencies {
   implementation 'com.github.Lazovski1991:forAllCore:0.2.0'
}
````

Library can use spring doc. You can enable this in our properties.

Example setting spring doc:
````
springdoc:
  api-docs:
    enabled: true //this parameter disable swagger
  packages-to-scan: my.company.imageservice
  swagger-ui:
    path: /swagger-ui.html #http://localhost:8081/api/template/swagger-ui/index.html
  doc-api-info:
    title: image-microservice
    description: "for building new microservices"
    version: 1.0.0
    license:
      name: JavaForAll
      url: https://javafarall.tech/license
    contact:
      name: "Alexander Lazovski"
      email: Lazovski1991@gmail.com
      url: https://javafarall.tech
````