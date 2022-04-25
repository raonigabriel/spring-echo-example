Spring Boot Echo Example
-------------------
A small app that echoes back a nice JSON with some info from the incoming requests:
- Request protocol
- Request method
- Request headers
- Request cookies
- Request params (query string)
- Request path
- Request body (Base64 encoded)

Is is usefull to trace/debug problems while developing REST APIs and SOAP WebServices.

# Features:
1. Spring Boot 2.6.x, supporting fully executable JARs
2. Accepts HTTP methods:  GET, POST, PUT, DELETE and OPTIONS
3. Accepts all content type (\*/\*)
4. Catches everything (ie, mapped at /**), thus no webjars,  no favicon.ico and no /error 
5. Response code is always a 404 "Not Found" to avoid unexpected client behavior
6. GZip compression is disabled (on purpose) to avoid unexpected client behavior
7. Response content type is always "application/json;charset=UTF-8".
8. Small. Final JAR includes everything (it self-contained) and it is only 17 MB
9. Docker image, published to GCR (Github Container Registry)

To get the code:
-------------------
Clone the repository:

    $ git clone https://github.com/raonigabriel/spring-echo-example.git

If this is your first time using Github, review http://help.github.com to learn the basics.

To run the application:
-------------------	
From the command line with Maven:

    $ cd spring-echo-example
    $ mvn spring-boot:run 

Using Docker:

    $ docker run --rm -it -p 8080:8080 ghcr.io/raonigabriel/spring-echo-example

# Try it using your browser, REST client, SoapUI, with:
* http://localhost:8080/sample.asp?product=42&category=dummy
* http://localhost:8080/sample.php?name=john
* http://localhost:8080/sample.html
* http://localhost:8080/sample.json
* http://localhost:8080/sample.css
* http://localhost:8080/sample.js
* http://localhost:8080/ws/sample.wsdl
* http://localhost:8080/people/1/cars

Use your preferred IDE such as SpringSource Tool Suite (STS) or IDEA:

* Import spring-echo-example as a Maven Project

## License

Released under the [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0.html)
