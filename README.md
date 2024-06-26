# Distance Calculator
### API Documentation placed at https://distancecalculator-production-1653.up.railway.app/swagger-ui/index.html
## About 

Rest service that calculates the distance between two cities <br>

HTTP Method | EndPoint | Description  
--- | --- | ---  
GET | api/cities | Getting a list of cities from the database 
GET | /calculate/{type}/{from_city}/{to_city} | Calculation of distance between cities 
POST | /uploadFile | Uploading an xml file with cities and distances to the server

The type can be Crowflight or Distance Matrix

### Screenshots
* You can upload your data via postman

![Снимок экрана (301)](https://user-images.githubusercontent.com/90307025/169847317-f79f88eb-f04e-4396-aa77-891162ffa3f9.png)

* Getting distance

![Снимок экрана (304)](https://user-images.githubusercontent.com/90307025/169847358-ae86b3d3-d513-4c26-95c9-e14d582feb23.png)
### Requirements
* Dataset should have this template!
```xml
<h2>Example of code</h2>

<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<data_set>
    <cities>
        <city>
            <name>Samara</name>
            <latitude>53.12N</latitude>
            <longitude>50.06E</longitude>
        </city>
        .
        .
        .
    </cities>
    <distances>
        <distance>
            <fromCity>
                <name>Samara</name>
                <latitude>131.322</latitude>
                <longitude>444.432</longitude>
            </fromCity>
            <toCity>
                <name>Moscow</name>
                <latitude>36.123</latitude>
                <longitude>38.323</longitude>
            </toCity>
            <distance>113.21</distance>
        </distance>
         .
         .
         .
    </distances>
</data_set>
```

### Technologies in the project
* Spring Boot 2.7.4
* Maven
* JAXB
* MySQL (remote)
* Postgresql (local)
* Liqubase
* Git(of course)
* Testcontainers
* Docker
* Java 17 (for records)


## Build and run in local environment

### Up from docker compose file
```xml
docker compose up
```

### Or build and launch with maven
```xml
mvn clean install
cd target
javac -jar Test_Task-0.0.1-SNAPSHOT.war
```
#### Open API doc will be placed at http://localhost:8080/swagger-ui/index.html
