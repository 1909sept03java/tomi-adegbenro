let user = {};

window.onload = function() {
	populateUser();
	managerFunctions();
	//getAllEmployees();
	document.getElementById("manager").addEventListener("click", getManager);
	

}

//document.getElementById("viewAllEmp").addEventListener("click", getAllEmployees);

function createEle(ele) {
    return document.createElement(ele); 
 }

  function addToEle(ele1, ele2) {
    return ele1.appendChild(ele2); 
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

function managerFunctions() {
	// send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8082/RevERS2/session").then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
	}).then(function(data) {
		let managerRole = data.mgrRole;
		console.log(data);
		console.log(data.mgrRole);
		// check whether there is a valid session
		//define behavior for when there is no valid user
		if(managerRole === 1){
			console.log(true);
			//Defining Manager Console
			let div0 = createEle('div');
			div0.setAttribute('class', 'card');
			div0.setAttribute('style', 'width: 18rem; background-color:aqua');
			let but0 = createEle('button');
			let p0 = createEle('p');
			p0.innerText = "Manager Menu";
			but0.setAttribute('type', 'button');
			but0.setAttribute('id', 'viewAllEmp');
			but0.innerText = "View All Employees";
			let div1 = createEle('div');
			let form0 = createEle('form');
			form0.setAttribute('action', 'myTeam');
			form0.setAttribute('method', 'GET');
			let fieldset0 = createEle('fieldset');
			let input0 = createEle('input');
			input0.setAttribute('type', 'text');
			input0.setAttribute('name', 'memberId');
			let input1 = createEle('input');
			input1.setAttribute('type', 'submit');
			input1.setAttribute('name', 'myTeam');


			//Build Element Tree
			//div0.appendChild(but0);
			addToEle(div0, p0);
			//div0.appendChild(header0);
			addToEle(div0, but0);
			addToEle(div0,div1);
			addToEle(div1, form0);
			addToEle(form0, fieldset0);
			addToEle(fieldset0,input0);
			addToEle(form0, input1);
			document.getElementById("mRole").appendChild(div0);
		}else{
			console.log(false);
		}
		document.getElementById("viewAllEmp").addEventListener("click", ()=>{console.log("Viewing all Employees")});
		/*if(data.session === null) {
			console.log("Thsi is empty")
			
			//window.location = "http://localhost:8082/RevERS2/login"
		} else {
			console.log("Session is not empty")
			
		}*/
	})
}

/*function getAllEmployees(){
	console.log("Viewing all Employees");
}*/

function getManager() {
	// send a GET request to SessionServlet to obtain session information
	//let url =
	fetch("http://localhost:8082/RevERS2/manager", {method:"GET", headers:{"Accept":"application/json"}})
		.then((response) =>{
		let data = response.json();
		return data; // parsing json data in the response as a JS object
	})
	.then((data) => {
		console.log("hi");
		//document.getElementById('mgrFirstname').innerText = "firstname: "+mgrData.firstName;
		// check whether there is a valid session
		//define behavior for when there is no valid user
		if(data.session === null) {
			console.log("I'min IF");
			document.getElementById('mgrFirstname').innerText = "Can't find data";
			document.getElementById('mgrLastname').innerText = "Can't find Manager";
			//window.location = "http://localhost:8082/RevERS2/login"
		} else {
			//define behavior for when a user is returned
			//mgr = mgrData;
			console.log("I'min ELSE");
			document.getElementById('mgrFirstname').innerText = "firstname: "+data.firstName;
			document.getElementById('mgrLastname').innerText = "lastname: "+data.lastName;
		}
	})
	 // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        });
}