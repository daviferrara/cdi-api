# cdi-api

### Rest webServer returning the CDI historical index within two dates

Project created with spring Initializer

Build an executable JAR
You can run the application from the command line with Maven. You can also build a single executable JAR file that contains all the necessary dependencies, classes, and resources and run that. Building an executable jar makes it easy to ship, version, and deploy the service as an application throughout the development lifecycle, across different environments, and so forth.

To run the application use
### ./mvnw spring-boot:run. 

Alternatively, you can build the JAR file with 

### ./mvnw clean package 
and then run the JAR file, as follows:
### java -jar target/cdi-0.0.1.jar

Logging output is displayed. The service should be up and running within a few seconds.

Test the Service
Now that the service is up, visit http://localhost:8080/cdiList?dtIni=20191015&currDt=20191110, where you should see the list of cdi {date, prices} within the two dates

"prices":[{"date":"2019-11-01T03:00:00.000+0000","price":4.9},{"date":"2019-11-08T03:00:00.000+0000","price":4.9},.....





