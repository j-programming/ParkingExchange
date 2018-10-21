# Mercari Hackathon

## Parking Exchange

### About

You own private parking slot for your car? Maybe you can temporary exchange it for a better parking place near your office for few hours - just mark location of your current spot and area you want to park, time in which spot will be available, and wait for responses! There's no direct exchange possible? Algorithm will try to arrange multiple swaps, to satisfy your needs.
This solution is a response to illegal parking practices, and lack of parking spots in urban areas.

To be more agile with your exchanges, you can construct, rent, or buy Bluetooth Low Energy sensor (i. e. Beacon), which might help track your car's location, or custom build sensor able to any car presence and connected to cellular network.

### Solution

Proposed solution is based on mobile application, website, and API back-end based with database engine. We need to take care of security aspect - users data must be protected, especially his location. The IoT part might be covered by beacons, iTags or some arduino-based projects.

Algorithm must be able to find possible matches in short time, with possibility of using locations proposed for at least 3 users.

Possible options for search: 
- direct exchange (C2C), long and short-term
- multiple-swap exchange
- paid rental of spot (post your spot with a price or post desired destination of your parking with proposition of price) 
- bonus points, and internal ranking system based exchanges etc.

Creating robust ranking system and internal currency might be another feature of this service, allowing true peer to peer exchanges without much need for external monitoring and administration.

#### Hackathon work
We've developed Android application, with the target to recreate all possible user actions.
We've started working on REST API, but we've prioritized work over backend and algorithm part of task

Example of data in database:
(2, 'a', '50.062936', '19.811645', '1523', '0:16', '20:42', 'wants')
This is example from user 'a', with the coordinates specified above. Additionaly, user wish to search in '1523' meter radius from specified location. He want place to be avaiable since 0:16 to 20:42. Last column says, that this is place wanted by user. In the other way the field would mean 'offers'


### Technology stack

**Web**: Python with Django, CSS, HTML, Javascript with jQuery, Bootstrap  
**Android**: Basic Android stack with Kotlin language, RxJava, Room, Retrofit, Google Maps or OSM and all the usuals.  
**API**: Python with Django REST framework  
**Backend**: Linux server, MySQL database, Apache2 webserver with mod_wsgi  

During the Hackathon we plan to focus on developing Android application and API
