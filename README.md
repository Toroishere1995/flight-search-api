# Flight Search Api
Flight search Api is based on Java, built using Jersey(v 2.25.1) , Hibernate(v 5.3.3) and MySQL(v 5.1.10) and build tool used is Apache Maven.

This API handles the request based on the criteria searched by the user mainly including arrival and departure locations code (e.g. 'DEL').
If there is no direct flight available between two locations ,then a connecting flight is searched considering factors like time durations.
Also this API handles the currency factor.
