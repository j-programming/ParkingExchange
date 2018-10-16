# MercariHackathon

You own private parking slot for your car? Maybe you can temporary exchange it for a better parking place near your office for few hours - just mark location of your current spot and area you want to park, time in which spot will be available, and wait for responses! There's no direct exchange possible? Algorithm will try to arrange multiple swaps, to satisfy your needs.
This solution is a response for illegal parking places, and lack of them in urban areas.

To be more agile with your exchanges, you can construct/rent/buy Bluetooth Low Energy sensor (i. e. Beacon), which might help in orienting in your location. Also possibility of sensor detecting car presence, connected to cellular network is available.

Proposed solution is based on mobile app (so far we have experience in Android apps), and website, all with back-end based on database engine. We need to take care of security aspect - users data must be protected, including location. The IoT part might be covered by beacons, iTags or some arduino-based projects.
Algorithm must be able to find possible matches in short time, with possibility of using locations proposed for at least 3 users.

Possible options for search: 
- direct exchange (C2C)
- multiple-swap exchange
- paid rental of spot (post your spot with a price or post desired destination of your parking with proposition of price) for specified time
- bonus points, etc.

Of course, the ranking system might be another feature of this service.

Our technology stack:
