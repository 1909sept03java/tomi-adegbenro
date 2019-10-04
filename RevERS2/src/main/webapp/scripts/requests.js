let user = {};

window.onload = function () {
    document.getElementById("reqs").addEventListener("click", getViewRequests);
    //document.getElementById("reqCreate").addEventListener("click", getViewRequests);
    populateUser();
    managerRFunctions();
    managerRViews();
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

function createEle(ele) {
    return document.createElement(ele); 
 }

  function addToEle(ele1, ele2) {
    return ele1.appendChild(ele2); 
 }


function managerRFunctions() {
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
			div0.setAttribute('style', 'width: 24rem; background-color:aqua');
			
			let p0 = createEle('p');
			p0.innerText = "Manager Reimbursement Actions";
			
			let div1 = createEle('div');
			
			let form0 = createEle('form');
			form0.setAttribute('action', 'reqResolve');
			form0.setAttribute('method', 'POST');
            let fieldset0 = createEle('fieldset');
            
			let input0 = createEle('input');
			input0.setAttribute('type', 'text');
            input0.setAttribute('name', 'reqId');
            let fieldset1 = createEle('fieldset');
            let leg0 = createEle('legend');
            let lab0 = createEle('label');
            lab0.innerText="Select Action";
            let sel0 = createEle('select');
            sel0.setAttribute('name','resOptions');
            sel0.setAttribute('id','resolve');
            let opt1 = createEle('option');
            opt1.setAttribute('value', '1');
            opt1.innerText = "PENDING";

            let opt2 = createEle('option');
            opt2.setAttribute('value', '2');
            opt2.innerText = "APPROVED";

            let opt3 = createEle('option');
            opt3.setAttribute('value', '3');
            opt3.innerText = "REJECTED";

            //let input1 = createEle('input');
            //input1.setAttribute('type', 'text');
			//input1.setAttribute('name', 'memberId');
            
            let input1 = createEle('input');
			input1.setAttribute('type', 'submit');
			input1.setAttribute('name', 'reqResolve');
			input1.setAttribute('value', 'Resolve');

			//Build Element Tree
			
			addToEle(div0, p0);
			
			//addToEle(div0, but0);
			addToEle(div0,div1);
            addToEle(div1, form0);
            addToEle(form0, fieldset0);
            addToEle(fieldset0,input0);
            addToEle(form0, fieldset1);
            addToEle(fieldset1,leg0);
            addToEle(fieldset1, lab0);
            addToEle(fieldset1, sel0);
            addToEle(sel0, opt1);
            addToEle(sel0, opt2);
            addToEle(sel0, opt3);
            addToEle(fieldset1, input1);
      
			
			document.getElementById("mgrRole").appendChild(div0);
			
		}else{
			console.log(false);
		}
		
	})
}

function managerRViews() {
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
			let div2 = createEle('div');
			div2.setAttribute('class', 'card');
			div2.setAttribute('style', 'width: 18rem; background-color:aqua');
			
			let p1 = createEle('p');
			p1.innerText = "Manager Reimbursement View";
			
			let div3 = createEle('div');
			
			let form1 = createEle('form');
			form1.setAttribute('action', 'mgrRequest');
			form1.setAttribute('method', 'POST');
            
            let fieldset2 = createEle('fieldset');
            let leg1 = createEle('legend');
            let lab1 = createEle('label');
            lab1.innerText="Select Status";
            let sel1 = createEle('select');
            sel1.setAttribute('name','viewOptions');
            sel1.setAttribute('id','resolve');
            let opt11 = createEle('option');
            opt11.setAttribute('value', '1');
            opt11.innerText = "PENDING";

            let opt22 = createEle('option');
            opt22.setAttribute('value', '2');
            opt22.innerText = "APPROVED";

            let opt33 = createEle('option');
            opt33.setAttribute('value', '3');
            opt33.innerText = "REJECTED";

            //let input1 = createEle('input');
            //input1.setAttribute('type', 'text');
			//input1.setAttribute('name', 'memberId');
            
            let input2 = createEle('input');
			input2.setAttribute('type', 'submit');
			input2.setAttribute('name', 'reqView');
			input2.setAttribute('value', 'View');

			//Build Element Tree
			
			addToEle(div2, p1);
			
			//addToEle(div0, but0);
			addToEle(div2,div3);
            addToEle(div3, form1);
            addToEle(form1, fieldset2);
            addToEle(fieldset2,leg1);
            addToEle(fieldset2, lab1);
            addToEle(fieldset2, sel1);
            addToEle(sel1, opt11);
            addToEle(sel1, opt22);
            addToEle(sel1, opt33);
            addToEle(fieldset2, input2);
      
			
			document.getElementById("mgrView").appendChild(div2);
			
		}else{
			console.log(false);
		}
		
	})
}
