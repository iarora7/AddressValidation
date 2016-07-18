# AddressValidation

Client UI on index.html asks for your address and responds back with valid/invalid status for the address provided.

Project address is a web service built using spring boot. It takes in the data from the user and saves it in MongoDB. 

To test address validation feature:
1. Download index.html, x2js and js folder
2. Open index.html using a browser and use Validate address feature.
3. (optional) open console window to the address in correct format

To test DB connectivity with address web service:
1. Download the complete project.
2. Download Mongo DB and start it.
3. Create a schema named "addressdb" in mongo. (Rest all congifurations are there in project)
4. Use index.html to store/get the address based on names.