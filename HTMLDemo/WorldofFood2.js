window.onload = function(){
    document.getElementById("food").onclick=function(){
        //let url = 'http://api.openweathermap.org/data/2.5/weather?q=Tampa,us&units=imperial&APPID=859d47520ac736ebe8bbce1fef74269c';
        let url = 'https://api.openbrewerydb.org/breweries';
        //sendAjaxGet("http://www.recipepuppy.com/api/?i=onions,garlic&q=omelet&p=3",sendAjaxGet(url,getRecipe))
        sendAjaxGet(url, getRecipe);
           
    }
}
​
function sendAjaxGet(url,func){
    let xhr = new XMLHttpRequest()
​
    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200){
            func(this)
        }
    }
    xhr.open("GET",url,true);
    xhr.send();
    //to include a body add it as a param to send
}
​
function getRecipe(xhr){
    let breweryObj = JSON.parse(xhr.responseText);
    console.log(breweryObj);
    document.getElementById("name").innerText =    `Brewery Name: ${breweryObj[0].name}`;
    document.getElementById("type").innerText = `Brewery Type: ${breweryObj[0].type}`;
    document.getElementById("street").innerText = `Street Address: ${breweryObj[0].street}`;
}
