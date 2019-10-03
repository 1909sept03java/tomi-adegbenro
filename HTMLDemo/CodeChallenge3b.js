window.onload = function () {
    document.getElementById("fetch").addEventListener("click", getUsersWithFetch);
    document.getElementById("fetch25").addEventListener("click", getRandomUser25);
}
let apiUrl = "https://randomuser.me/api/";
let state = { first:'', gender: '' , phone:'', thumbnail:''};
let ul = document.getElementById('randomUser');
let myTable = document.getElementById('myTable');
let nUser = 0;
var p = ""; //to caputure results from array

let updateContent = function() {
    document.getElementById('thumbnail').src = state.thumbnail;
    document.getElementById('first').innerText = state.first;
    document.getElementById('gender').innerText = state.gender;
    document.getElementById('phone').innerText = state.phone;

}

function createEle(ele) {
    return document.createElement(ele); 
  }

  function addToEle(ele1, ele2) {
    return ele1.appendChild(ele2); 
  }

function getUsersWithFetch() {
    fetch(apiUrl, {method:"GET", headers:{"Accept":"application/json"}})
        //define behavior for when response returns
        .then((response) => {
            //return unwrapped promise object for the next chained operation
            let data = response.json();
            return data;
        })
        // utilize unwrapped promise as a JS object
        .then((data) => {
            state.thumbnail = data.results[0].picture.medium;
            state.first = data.results[0].name.first;
            state.gender = data.results[0].gender;
            state.phone = data.results[0].phone;
            updateContent();
        })
        //what if there's a problem?
        .catch((error) => {
            alert('oh no :(');
            console.log(error);
        });
}

let avgAge =0;
function getRandomUser25() {
    
    for (var i = 1; i <= 25; i++) {
        getUsersWithFetch25(i);
    }
    document.getElementById('fetch25Header').innerText = "Average Age of Users is "+avgAge;
}

function getUsersWithFetch25(param) {
    let sum =0;
    
    //var p = "";
    fetch(apiUrl, {method:"GET", headers:{"Accept":"application/json"}})
        //define behavior for when response returns
        .then((response) => {
            //return unwrapped promise object for the next chained operation
            let data = response.json();
            return data;
        })
        // utilize unwrapped promise as a JS object
        .then((data) => {
            console.log(data);
            let users = data.results;
               
            //Summing Ages
            sum = sum + users.dob.age;
            //defining DIVs
            let div = createEle('div');
            div.setAttribute('class', 'card');
            div.setAttribute('style', 'width: 18rem; background-color:aqua');
            //Defining Images
            let image = createEle('img');
            image.setAttribute('height', '250');
            let div2 = createEle('div');
            div2.setAttribute('class-card', 'card');
            div.setAttribute('style', 'width: 18rem; background-color:bisque');
            let p = createEle('p');
            let ul = createEle('ul');
            let li1 = createEle('li');
            let li2 = createEle('li');
            let li3 = createEle('li');
            image.src = users[0].picture.medium;
            p.innerText = "Name: "+ users[0].name.first+" "+users[0].name.first;
            li1.innerText = "Gender: "+users[0].gender;
            li2.innerText = "Telephone: "+users[0].phone;
            li3.innerText = "Location: "+users[0].location.city;
            div.appendChild(image);
            div.appendChild(div2);
            div2.appendChild(p);
            div2.appendChild(ul);
            ul.appendChild(li1);
            ul.appendChild(li2);
            ul.appendChild(li3);
            document.body.appendChild(div);
            
            avgAge = sum / param;
            //document.getElementById('fetch25Header').innerText = "Average Age of Users is "+avgAge;

            })
            
       
        //what if there's a problem?
        .catch((error) => {
            alert('oh no :(');
            console.log(error);
        });
}