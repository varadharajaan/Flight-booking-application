Elasticsearch - Logstash - Kibana 
=========================

Building the ELK
---------------------
    $ git clone https://github.com/buraksarp/docker-elk.git
    $ cd docker-elk

This demo assumes you know how to run Docker.

Building the Containers
----------------------
Nothing special if you already have Docker installed:

    $ docker-compose build 

Running Containers with the docker-compose
---------------------
To run these containers:

    $ docker-compose up
    
Consuming Rest Service
---------------------
To consume SpringBoot app user service:

    $ curl http://localhost:8080/user/{userid}
    
To view generated logs on Kibana UI: [http://localhost:5601](http://localhost:5601)

##### i. Modularise :
	For the time being I have modularise the project on package level.
	Later we can also modularise in maven modules.

------------------------------------------------------------------------------------------------------------------------
##### ii. DTO :
	It stands for Data Transfer Object.
	In this project DTO are used to send as response object from rest controller.

------------------------------------------------------------------------------------------------------------------------
##### iii. RESTful API design :
	Backend consists following restful apis i.e.

	You can find all the available api's after running the application in Swagger documentation at http://localhost:8888
------------------------------------------------------------------------------------------------------------------------
##### iv. Exception Handler via Aspect :
	Added aspect for exception handling at rest layer and send appropriate http status and error messages.

------------------------------------------------------------------------------------------------------------------------
##### v. Testing and documentation for RESTful apis:
	Integrated Swagger, for more details please visit here : http://swagger.io/
	I’ve added swagger framework for testing the apis.

------------------------------------------------------------------------------------------------------------------------
##### vi. Comments :
	Entire code styling is influenced by Clean Code principle - Robert Martin
	Which says
	'Truth can only be found in one place: the code’.
	So you may not found any comments anywhere in the project.
	Keeping in mind that git can be used to manage version of file and method name should be kept as self explanatory.

	However, if you need comments on each file. I can do that too.

------------------------------------------------------------------------------------------------------------------------
##### vii. Design principles used in Project :
	a. SOLID (single responsibility, open-closed, Liskov subsitution, interface segragation, dependency inversion) principle,
	b. Composition over inheritance,
	c. DRY(Don’t repeat yourself),
	d. Test only exceptions,
	e. KISS(Keep it simple, stupid)
	f. and some experience principle ;)







