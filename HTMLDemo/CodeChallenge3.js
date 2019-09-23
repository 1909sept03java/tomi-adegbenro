window.onload = function () {
    document.getElementById("fetch").addEventListener("click", getUsersWithFetch);
}
let apiUrl = "https://randomuser.me/api/";
let state = { user: '' , phone:''};

let updateContent = function() {
    document.getElementById('user').innerText = state.user;
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
            state.user = data.results[0].gender;
            state.phone = data.results[0].phone;
            updateContent();
        })
        //what if there's a problem?
        .catch((error) => {
            alert('oh no :(');
            console.log(error);
        });
}