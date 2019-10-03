let user = {};

window.onload = function () {
    document.getElementById("reqs").addEventListener("click", getViewRequests);
    populateUser();
}

function populateUser() {
	// send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8082/RevERS2/session").then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
	}).then(function(data) {
		console.log(data);
		// check whether there is a valid session
		//define behavior for when there is no valid user
		if(data.session === null) {
			window.location = "http://localhost:8082/RevERS2/login"
		} else {
			//define behavior for when a user is returned
			user = data;
			document.getElementById('firstname').innerText = "firstname: "+data.firstName;
			document.getElementById('lastname').innerText = "lastname: "+user.lastName;
		}
	})
}

function getViewRequests(){
    fetch("http://localhost:8082/RevERS2/statRequest").then(function(response) {
        return response.json();
    }).then(function(data){
        console.log(data);


    })
}
