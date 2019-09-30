window.onload = function () {
    document.getElementById("viewRequests").addEventListener("click", getViewRequests);
}
let apiUrl = "https://icanhazdadjoke.com/";
let state = { joke: '' };
let updateContent = function() {
    document.getElementById('joke').innerText = state.joke;
}

async function getViewRequests() {
    // clean up the Promises syntax, fewer chained .then() statements..
    try {
        let response = await fetch(apiUrl, {method:"GET", headers:{"Accept":"application/json"}});
        let data = await response.json();
        state.joke = data.joke;
        updateContent();
    } catch(error) {
        console.log(error);
    }
}