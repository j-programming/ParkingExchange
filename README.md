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

Of course, the ranking system and internal currency might be another feature of this service.

### Technology stack

**Web**: Python with Django, CSS, HTML, Javascript with jQuery, Bootstrap  
**Android**: Basic Android stack with Kotlin language, RxJava, Room, Retrofit, Google Maps or OSM and all the usuals.  
**API**: Python with Django REST framework  
**Backend**: Linux server, MySQL database, Apache2 webserver with mod_wsgi  

During the Hackathon we plan to focus on developing Android application and API
