window.onload = function() {
    let myDivs = document.getElementsByTagName("div");
    for (let i=0; i<myDivs.length; i++) {
        myDivs[i].addEventListener("click", () => {
            console.log(`target: ${event.target.id} and the current element is :${event.currentTarget.id}`);
        }, true);
    }
    document.getElementById("button1").onclick = showPeople;
}

const jsonSource = '{"people":[{"name":"Fred", "age": 87},{"name":"Francis", "age": 27},'+
    '{"name":"Bob", "age": 40}]}';

function showPeople() {
    let peopleObj = JSON.parse(jsonSource);
    //console.log(peopleObj); //displays in the console
    //select parent element for new list items
    let ul = document.getElementById("peopleList");
    peopleObj.people.forEach(element => {
        //console.log(element);
        //create a list item element to hold the infomration about the person
        let li = document.createElement("li");
        //set the inner text
        //li.innerText = element.name;
        li.innerHTML = `<strong> ${element.name}</strong>`;
        //append it to the parent
        ul.appendChild(li);
        
    })

    function getMousePosition(){
        let myDivs = document.getElementsByTagName("div");
        for (let i=0; i<myDivs.length; i++) {
            myDivs[i].addEventListener("mouseover", () => {
                console.log(`mouse coordinates: ${event.pag}`);
        });

    }
        
   
        
    
    /*for (person in people) {
        console.log(person);
    }*/
}