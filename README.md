# Netflix-zuul-api-gateway-example

Learn to create load balancer using Netflix Zuul and its solid bonding with Spring Cloud. Here we will mainly concentrate on API gateway pattern and it’s usage. We will build a netflix zuul example where we will create a microservice ecosystem and test its effectiveness and applicability of Zuul API gateway in the whole ecosystem.

This is a very common microservice pattern and Netflix, creator of Zuul makes use of this heavily and intelligently, and Netflix claims that all Netflix traffic first go to a Zuul cluster which is mainly responsible for dynamic routing, monitoring, resiliency and security based on different groovy based custom filters.

![alt text](https://www.howtodoinjava.com/wp-content/uploads/2017/07/Zull-filters.jpg)

Now let’s make our hands dirty by creating a simple yet meaningful ecosystem using Zuul proxy. We will create below artifacts to demonstrate the whole thing:

- Payment Microservice – a spring boot based microservice which will just expose a single url to enable some payment functionality. 
- Zuul gateway service proxy – It would be again a spring boot based, which will basically intercept all the traffic of payment service and apply series of request filter and then route to the underlying service and again at the time of response serving, it will apply some response filtering. Since it is a gateway, we can literally take many interesting and useful action using the filters effectively.
Some of the common responsibility of gateway service are –
  - Apply microservice authentication and security in the gateway layer to protect the actual services
  - We can do microservices insights and monitoring of all the traffic that are going in to the ecosystem by enabling some logging to get meaningful data and statistics at the edge in order to give us an accurate view of production.
  - Dynamic Routing can route requests to different backend clusters as needed.
  - We can do runtime stress testing by gradually increasing the traffic to a new cluster in order to gauge performance in many scenarios e.g. cluster has new H/W and network setup or that has new version of production code deployed.
  - We can do dynamic load shedding i.e. allocating capacity for each type of request and dropping requests that go over the limit.
  - We can apply static response handling i.e. building some responses directly at the edge instead of forwarding them to an internal cluster for processing.


Tech Stack and Runtime
- Java and intellij IDE as development environment
- Spring cloud Zuul as Gateway proxy provider
- Spring boot as application framework
- Spring Rest for exposing microservice as REST
- Maven as build tool

Testing features
- With Zuul API;
  - Run the "SpringBootZuulgatewayproxyApplication" in "spring-boot-zuulgatewayproxy" module
  - Run the "PaymentServiceApplication" in "payment-service" module
  - Send request with below format to "http://localhost:8080/payment/direct" as POST method;
```json
    {
      "amount": 234,
      "currencyCode": "TL",
      "holder": "test",
      "pan": "4355084355084358",
      "validMonth": "12",
      "validYear": "2026",
      "cvv": "001"
    }
```
- With Spring Cloud Gateway API;
  - Run the "SpringCloudApigatewayApplication" in "spring-cloud-apigateway" module
  - Run the "PaymentServiceApplication" in "payment-service" module
  - Send request with below format to "http://localhost:8081/payment/direct" as POST method;
```json
    {
      "amount": 234,
      "currencyCode": "TL",
      "holder": "test",
      "pan": "4355084355084358",
      "validMonth": "12",
      "validYear": "2026",
      "cvv": "001"
    }
```
- This project is using H2 database to store required data. To access H2 console;

  - http://localhost:8080/h2-console/
