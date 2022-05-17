# insti-lunchbox-backend

<h3>JWT End Points: </h3>

<b>Creating a JWT token</b> <br> 
POST : http://localhost:9090/authenticate

<hr>

<h3>Institute End Points: </h3>

<b>Adding a new Institute User</b> <br> 
POST : http://localhost:9090/api/institute/add

<b>Get all the Institute Users</b> <br>
GET : http://localhost:9090/api/institute/get

<b>Get all the Institute Users by Status</b> <br>
GET : http://localhost:9090/api/institute/getByStatus

<b>Get all the Institute Users by Email</b> <br>
GET : http://localhost:9090/api/institute/email

<b>Update the Institute User</b> <br>
PUT : http://localhost:9090/api/institute/update

<b>Update the status of the Institute User</b> <br>
PUT : http://localhost:9090/api/institute/updateStatus/{id}/{status}

<b>Delete the Institute User</b> <br>
DELETE : http://localhost:9090/api/institute/delete/{id}

<hr>

<h3>NGO End Points: </h3>

<b>Adding a new NGO User</b> <br> 
POST : http://localhost:9090/api/ngo/add

<b>Get all the NGO Users</b> <br>
GET : http://localhost:9090/api/ngo/get

<b>Get all the NGO Users by Status</b> <br>
GET : http://localhost:9090/api/ngo/getByStatus

<b>Get all the NGO Users by Email</b> <br>
GET : http://localhost:9090/api/ngo/email

<b>Update the NGO User</b> <br>
PUT : http://localhost:9090/api/ngo/update

<b>Update the status of the NGO User</b> <br>
PUT : http://localhost:9090/api/ngo/updateStatus/{id}/{status}

<b>Delete the NGO User</b> <br>
DELETE : http://localhost:9090/api/ngo/delete/{id}

<hr>

<h3>LunchBox End Points: </h3>

<b>Adding a new LunchBox</b> <br> 
POST : http://localhost:9090/api/lunchbox

<b>Get all the LunchBoxes</b> <br>
GET : http://localhost:9090/api/lunchbox/get

<hr>

<h3>FoodItem End Points: </h3>

<b>Adding a new FoodItem</b> <br> 
POST : http://localhost:9090/api/fooditem/

<b>Get all the FoodItems</b> <br>
GET : http://localhost:9090/api/fooditem/get

<b>Get all the NGONames</b> <br>
GET : http://localhost:9090/api/fooditem/getNGONames

<b>Get all the FoodItem for Institute User</b> <br>
GET : http://localhost:9090/api/fooditem/get/{email}

<b>Update the FoodItem</b> <br>
PUT : http://localhost:9090/api/fooditem/put

<hr style="border: 1px dashed black;">
