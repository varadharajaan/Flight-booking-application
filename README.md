INVIA-FLIGHT-BOOKING-APPLICATION 
=========================

Building the Application
---------------------
    $ https://github.com/varadharajaan/Flight-booking-application.git
    $ cd invia-flightbooking-backend

This demo assumes you know how to run Docker.
------------------------------------------------------------------------------------------------------------------------
Building the Containers
----------------------
Nothing special if you already have Docker installed:

    $ docker-compose build 


Running Containers with the docker-compose
------------------------------------------

$ docker-compose up


------------------------------------------------------------------------------------------------------------------------ 

Actuators to check Application Health 
--------------------------------------
$ localhost:8080/health
$ localhost:8080/httptrace/info



------------------------------------------------------------------------------------------------------------------------ 
To consume SpringBoot app user service:
    
Consuming Rest Service
---------------------
To consume SpringBoot app user service:

    $ curl http://localhost:8080/login
    
    $ Dummy scripts available in db/migration. USed Flyway to maintain db migration.
    
------------------------------------------------------------------------------------------------------------------------

Docker push to Docker Hub Container Registry
---------------------

$export PROJECT_ID="$(gcloud config get-value project -q)"

$gcloud auth configure-docker

$docker tag invia-flightbooking:latest "gcr.io/invia-flightbooking/invia-flightbooking:v1"

$docker push gcr.io/invia-flightbooking/invia-flightbooking:v1

------------------------------------------------------------------------------------------------------------------------
Jenkins File
--------------

$Jenkins deployment which go mvn install and other stages

$docker build and push to docker hub

$ Trigger terraform apply and provision environment and deploy the docker image in Google Kubernetes Cluster

$ Communication mail to all team members
------------------------------------------------------------------------------------------------------------------------
GCP Deployment using Terraform as Infrastructure as a Code
-------------------------------------

$Step 1: terraform init
$Step 2: terraform plan
$Step 3: terraform apply
------------------------------------------------------------------------------------------------------------------------
User level Authentication   
--------------------------

 $ Time of User Registration, USERNAME and PASSWORD is stored in database and each time when user tries to book flight he needs to be autheticated.
 $ also implemented Role level authorisation 

------------------------------------------------------------------------------------------------------------------------
    
Elastic Search-LogStash-Kibana  
--------------------------
$ Implemented Dockerized version of ELK to log and index all the application logs
$ To view generated logs on Kibana UI: [http://localhost:5601](http://localhost:5601)

Custom Log Printer
--------------------------
$ Custom Log Printer which intercepts every request and response in Json Format

ADMIN LOGIN
--------------------------
$ hit: localhost:8080/login

username -> john
password -> password

on giving incorrect password, proper error message is shown

------------------------------------------------------------------------------------------------------------------------

Above commands gives complete details of the application

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







