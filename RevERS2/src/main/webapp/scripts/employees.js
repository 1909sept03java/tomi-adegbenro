let user = {};
let ul = document.getElementById('start');

window.onload = function () {
    
    populateUser();
    viewEmpResults();
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

function createEle(ele) {
    return document.createElement(ele); 
 }

  function addToEle(ele1, ele2) {
    return ele1.appendChild(ele2); 
 }

 function viewEmpResults(){
    fetch("http://localhost:8082/RevERS2/empResults").then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
	}).then(function(data) {
        console.log(data);
                
        //for (let i = 0; i < data.length; i++) {
       data.forEach((obj) => {
            console.log(obj.reqId);
            let div0 = createEle('div');
            div0.setAttribute('class','row');

            let id_cell = createEle('div');
            id_cell.setAttribute('class', 'cell');
            id_cell.innerText = obj.empId;
            addToEle(div0,id_cell);
                       
            let firstName = createEle('div');
            firstName.setAttribute('class', 'cell');
            firstName.innerText = obj.firstName;    
            addToEle(div0,firstName);
            
            let lastName = createEle('div');
            lastName.setAttribute('class', 'cell');
            lastName.innerText = obj.lastName;
            addToEle(div0,lastName);

            addToEle(ul, div0);
        }
        );
            //var holder = "";
            
        
            
    })
}