
<h2><b>standerdization of Ports:</b></h2>
<p>
<b>1. Limits Microservice</b><br>
Ports: 8080, 8081, etc.

<b>2. Spring Cloud Config Server</b><br>
Port: 8888

<b>3. Currency Exchange Microservice</b><br>
Ports: 8000, 8001, 8002, etc.

<b>4. Currency Conversion Microservice</b><br>
Ports: 8100, 8101, 8102, etc.

<b>5. Netflix Eureka Naming Server</b><br>
Port: 8761

<b>6. API Gateway</b><br>
Port: 8765

<b>7. Zipkin Distributed Tracing Server</b><br>
Port: 9411  
</p>
<h2>URLs</h2>
<p>
<b>1. spring cloud config server: (to check if the config server is fetching configuration data from local git repo)</b><br>
http://localhost:8888/currency-exchange-microservice/dev <br>
http://localhost:8888/limits-service/dev

<b>2. Step by Step instructions is provided in the troubleshooting guide to help you troubleshoot frequently occurring problems.
(Using the Chrome Browser is recommended)</b><br>
COMPLETE DEBUGGING GUIDE: https://github.com/in28minutes/spring-microservices-v3/blob/main/03.microservices/01-step-by-step-changes/readme.md#eureka---step-19-to-21 
</p>

<h2> Local git repo for spring config server: </h2>
<p>
 1. create "application-name.properties" file in local git repository.<br>
    Example: limits-service.properties, limits-service-dev.properties.<br>
 2. provide configurations for the targeted application in the properties file<br>
    Example: In "limits-service-dev.properties", we are providing "limits-service.minimum=1
    limits-service.maximum=1000"<br>
3. Local git data is uploaded on "Master branch" in git of this remote repo. 
</p>

<h2>Process of creating instances manually: </h2>
<p>
1) select "Run Configurations..." from left side of stop button.<br>
2) create duplicate entry of target project<br>
3) in "Arguments" tab, in "VM arguments" input box, type "-Dserver.port=8001"<br>
4) click on Apply<br>
5) click on Run
</p>

<h2> URL for API-Gateway: </h2>
<p>
 <h4> Initial </h4>

- http://localhost:8765/CURRENCY-EXCHANGE/currency-exchange/from/USD/to/INR

- http://localhost:8765/CURRENCY-CONVERSION/currency-conversion/from/USD/to/INR/quantity/10

- http://localhost:8765/CURRENCY-CONVERSION/currency-conversion-feign/from/USD/to/INR/quantity/10



<h4> Lower Case </h4>

- http://localhost:8765/currency-exchange/currency-exchange/from/USD/to/INR

- http://localhost:8765/currency-conversion/currency-conversion/from/USD/to/INR/quantity/10

- http://localhost:8765/currency-conversion/currency-conversion-feign/from/USD/to/INR/quantity/10



<h4> Custom Routes </h4>

- http://localhost:8765/currency-exchange/from/USD/to/INR

- http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10

- http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10

- http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10
</p>

<h2> Resilience Circuit Breaker: </h2>
<p>
 <p> we can use Cygwin terminal to send multiple requests to API, to check the Circuit breaker working </p>
 
- watch -n 0.1 curl http://localhost:8000/sample-api2
</p>

<h2> Zipkin </h2>
 <p>
  
- in28Minute git repo: https://github.com/in28minutes/spring-microservices-v3/blob/main/v3-upgrade.md <br>
- rather than creating a project for Zipkin, we use global docker image "openzipkin/zipkin". <br>
  <b>docker run -p 9411:9411 openzipkin/zipkin:2.23</b>
- url: localhost:9411
- dependacies: add these dependacies in the microservices (spring boot applications)
  
   ```
   
   <dependency>
			<groupId>io.micrometer</groupId>
			<artifactId>micrometer-observation</artifactId>
		</dependency>

		<!-- OPTION 1: Open Telemetry as Bridge (RECOMMENDED) -->
		<!-- Open Telemetry 
    - Simplified Observability (metrics, logs, and traces) -->

		<dependency>
			<groupId>io.micrometer</groupId>
			<artifactId>micrometer-tracing-bridge-otel</artifactId>
		</dependency>

		<dependency>
			<groupId>io.opentelemetry</groupId>
			<artifactId>opentelemetry-exporter-zipkin</artifactId>
		</dependency>
  
   ```
   
- add configurations in application.properties:
    ```
    management.tracing.sampling.probability=1.0
    logging.pattern.level=%5p [${spring.application.name:},%X{traceId:-},%X{spanId:-}]

    ```
  here, 1.0 in management.tracing.sampling.probability means 100% logs are being tracked by zipkin.
 </p>



