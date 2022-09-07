# Questions for Spring and Java Interview preparation

### 1. Significance of 'var' keyword in java 10+. And all the cases. ###
	1. Firstly,

	```
	var person = new Person();
	```
	> It serves the same purpose as:

	```
	Person person = new Person();
	```
	BUT, it is not same as the `var` in javascript.<br />
**Javascript is a dynamically typed language whereas Java is Statically typed language.**<br />
In javascript a variable doesn't have information about the variable. It does not have restrictions on what it can contain. It is just a holder for a value, and the value can be of any type.<br />
	Java is a statically typed language and the opposite is true for all of those statements. A programmer has to say up-front what type their variable can hold.

### 2. What is a web-service? ###
	Three layers:
	1. Web layer
	2. Business layer(Logic layer)
	3. Data layer(Where data is stored and queried)
The output of the web layer is HTML which is not re-usable. Logic layer and data layer combined can be re-usable after creating a jar file, but  there are a lot of problems creating a jar and trying to reuse it.<br />
But if the application is able to provide out in a format that other applications can understand it, that's where web-service comes in.<br />
According to W3C:
> Software system designed to support `interoperable` `machine-to-machine interaction` `over a network`.<br />
3 keys:
>> **interoperable** means to be able to communicate and exchange data with another system or device.<br />
>> **machine-to-machine interaction** means the applications should be able to communicate with any other application (not requiring any human interaction). Should not be platform dependent. Irrespective of the technologies or language used to build any application should be able to communicate with our application only then our application can be called a web-service.<br />
>> **over a network** In the case where we are creating a jar file, we provide the jar file to the person who wants to use the service. That particular person installs the file locally on his machine. So the machine is not communicating over a network, there are a lot of stuff going on manually. In this case our application cannot be called a web-service. For that, the communication between those machines should be over a network.

### 3. How does Data exchange take place between applications? ###
Let's say we have our web-service, so in that case other application to communicate with our web-service it needs to send some input that is called **request** and the output that our web-service gives based on input is called **response**. The Application creates a request, web-service would process it and gives out a response that is again consumed by the application. 

### 4. How can we make our web-service platform independent? ###
 The web-service to be independent, the request and the response also should be platform independent. They should be in the format that all different kind of platforms can support.
There are two popular formats for request and response:
	1. XML(Extensible Markup Language)
	It can be generated from any platform java, .net,...
	eg.
		```
		<getCourseDetailRequest>
			<id>Course1</id> //whose detail we want
		</getCourseDetailRequest>
		```
	2. JSON(JavaScript Object Notation) 
	Json is actually how javascript represents its objects. <br />
	Json is now supported by wide variety of platforms.<br />

### 5. How does an application know the request and response?(what to send, in what format to send and where to send the request) ###
Every web-service offers a service definition.<br />
Service Definition specifies the following:
	1. Request/Response format - specifies which format is it. JSON, XML or any other format. 
	2. Request Structure - specifies what specific request the service needs. In which way/structure.
	3. Response Structure - specifies in what structure the response would be returned by the service.
	4. Endpoint - specifies the uri, that where the is service available.

### 6. Key Terminologies. ###
Service provider - one that hosts the web-service. In case of web-service, web-service is a service provider. <br />
Service consumer -  consumer of the web-service.<br />
Service Definition - It's the contract between the provider and the consumer. It defines the format of the request and response (XML or JSON), structure of the request and response, and the endpoint where the service can be consumed.<br />
Transport - it defines how service is called.  Is the service exposed over the internet and we can use it or the service is exposed over a queue. Two popular formats:
	1. HTTP(Internet)
	2. MQ(a Queue) - it's communication over a queue. The service requester would place a message over a queue, whereas the service provider would be listening on the queue. A soon as the request is on the queue, it would take the request and process it to create a response and put it back in the queue and the service requester would get the response from the queue. 

### 7. SOAP and REST. ###
**SOAP** defines specific way of building web-services. In SOAP we use XML as request/response exchange format. <br />
SOAP defines a specific structure of request and response structure. <br />
>SOAP-ENV:Envelope<br />
>>SOAP-ENV:Header //contains meta information like authentication, authorisation, signatures...<br />
>>SOAP-ENV:Body //here we put the real request or response.<br />
For a web-service to be a SOAP web-service the application has to adhere to this structure of request and response format, where SOAP-envelope encloses the header and the body in request and response.<br /><br />
SOAP can be transported over HTTP or MQ.<br />
As Definition language, it uses WSDL(Web-Service Definition Language).<br /><br />
**REST** (REpresentational State Transfer)<br />
Browsing over Internet, requires a request and gives corresponding response. The format of this request and response is defined by HTTP.<br />
Sending a GET request, makes the server send back a response. A HTTP response containing an HTML which is then displayed by the browser on the screen.<br />
HTTP defines the headers as well as body, and along with them HTTP also defines request methods to indicate what action the application wants to perform by using the HTTP request methods. HTTP methods GET, POST, PUT, DELETE.<br />
RESTful web-services try to define services using the different concepts that are already present in the HTTP. <br />
Resource in REST is something that is to be returned as a response or sth that application consumes.<br />
REST attaches specific URI for specific resource. CRUD operation includes their respective URI to perform their task.<br />
REST has no restriction on Data exchange format. (XML or JSON)<br />
Transport is always HTTP.<br />
No standard service Definition.WADL / Swagger<br />

 




