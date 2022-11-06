# Drone API
This guide assumes basic familiarity with Git, Java. At the time of writing, the preferred IDE was IntelliJ IDEA.

## Requirement

Domain :- Doing deliveries using drones  
Field  :- Transportation

**Drone**

		Attributes -->
				1. Serial No
				2. Model
				3. Weight Limit
				4. Battery Capacity
				5. State
				
		Functions -->
				1. Carrying devices
				2. Carrying medication

**Medication** 

		Attributes -->
				1. Name
				2. Weight
				3. Code
				4. Image
				
**API endpoints**

	1. Registering a drone (drone) - Done
	2. Loading medications for a drone   (medication, drone) - Done
	3. Check loaded medication of a drone (drone) - Done
	4. Check available drones - all - Done
	5. Check available drones - (medication -check through available weight)
	6. Check battery level (drone)
	
## Installation

* Checkout the project using `https://github.com/susithvj/Drones`
* Run `gradle clean build` (Make sure you have gradle and java installed).
* Run `gradle bootRun` command to start the application.
* Please refer the src/main/resources/application.properties file for relevant security, server port & scheduler configs.

## API Documentation

Please refer the following swagger ui url after starting the application

    http://localhost:8090/swagger-ui/index.html
    
  