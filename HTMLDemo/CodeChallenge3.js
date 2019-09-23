window.onload = function () {
    document.getElementById("fetch").addEventListener("click", getUsersWithFetch);
}
let apiUrl = "https://randomuser.me/api/?results=25";
let state = { first:'', gender: '' , phone:'', thumbnail:''};
let p = "";

let updateContent = function() {
    document.getElementById('thumbnail').src = state.thumbnail;
    document.getElementById('first').innerText = state.first;
    document.getElementById('gender').innerText = state.gender;
    document.getElementById('phone').innerText = state.phone;

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
            console.log(data);
            state.thumbnail = data.results[0].picture.thumbnail;
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

function getUsersWithFetch25() {
    var p = "";
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
            data.forEach(person => {
                p =`<div class="well">
                <span>${person.name.first}</span>
                `
                //state.thumbnail = data.results[0].picture.thumbnail;
                //state.first = data.results[0].name.first;
                //state.gender = data.results[0].gender;
                //state.phone = data.results[0].phone;
                //updateContent();
            });
            
        })
        //what if there's a problem?
        .catch((error) => {
            alert('oh no :(');
            console.log(error);
        });
}