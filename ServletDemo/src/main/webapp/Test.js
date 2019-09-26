/**
 * 
 */
window.onload = function () {
    

    document.getElementById("testing").addEventListener("click", forwardTest);
}
        apiUrl='http://localhost:8082/ServletDemo/session';

    function forwardTest(){
        fetch(apiUrl, {method:"GET", headers:{"Accept":"application/json"}})
        //define behavior for when response returns
        .then((response) => {
            //return unwrapped promise object for the next chained operation
            let data = response.json();
            return data;
        })
        .then((data) => {
            document.getElementById('userid').innerHTML = "ID: "+data.id;
            document.getElementById('first').innerHTML = "Firstname: "+data.firstname;
            document.getElementById('last').innerHTML = "Lastname: "+data.lastname
        })
        .catch((error)=>{
            alert('something is wrong');
            console.log(error);
        })
        

    }
