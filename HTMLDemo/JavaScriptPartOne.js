window.onload = function () {
    //select element with id " fizzBuzzButton"
    // apply an event listener to it to make it clickable
    //define anonymous fuction to be invoked when clicked
    //This anonymous function is a CALLBACK function - executes when another function 
    //has finished executing

    document.getElementById("fizzBuzzButton").addEventListener("click", function () {
        let num1 = document.getElementById("num1").value;
        let word1 = document.getElementById("word1").value;
        let num2 = document.getElementById("num2").value;
        let word2 = document.getElementById("word2").value;
        //console.log(`num1 is ${num1}, replaced by ${word1}, and num2 is ${num2}, replaced by ${word2}`);
        fizzBuzzSimilar(num1,word1,num2,word2)

    });

    document.getElementById("nfizzBuzzButton").addEventListener("click", function () {
        let nums1 = document.getElementById("nums1").value;
        let words1 = document.getElementById("words1").value;
        //console.log(`num1 is ${num1}, replaced by ${word1}, and num2 is ${num2}, replaced by ${word2}`);
        nfizzBuzzSimilar(nums1,words1)

    });
}

// THE ARGUMENTS NAMES ARE ARBITRARY AND NOT AT ALL RELATED TO IDENTIFIERS IN THE ABOVE FUNCTION
function fizzBuzzSimilar(num1, word1, num2, word2) {
    //this is a template string introduced in ES6
    //console.log(`num1 is ${num1}, replaced by ${word1}, and num2 is ${num2}, replaced by ${word2}`);
    //console.log to print from 1 - 100 with all mutiples
    for (i = 0; i < 100; i++) {
        if (i % num1 === 0 && i % num2 === 0) {
            console.log(word1 + word2);
            
        }
        else if (i % num1 === 0) {
            console.log(word1);
           
        }
        else if (i % num2 === 0) {
            console.log(word2);
            
        }
        else
        console.log(i+" ");
        


    }

}

function nfizzBuzzSimilar(nums1, words1) {
    //this is a template string introduced in ES6
    //console.log(`num1 is ${num1}, replaced by ${word1}, and num2 is ${num2}, replaced by ${word2}`);
    //console.log to print from 1 - 100 with all mutiples
    var numList = nums1.split(",");
    var wordList = words1.split(",");
    var numIntList = numList.map(Number);
    for (var i in numIntList)
        console.log(numList[i]);
    
    for (var j in wordList)
        console.log(wordList[j]);
    
    if(numIntList.length!==wordList.length){
        console.log("Mismatch in length of arrays")
    }else{
        
        for(a=1; a<100; a++){
            var array = [];
            for(var b in numIntList){
                if(a%numIntList[b]===0){
                    array.push(wordList[b]);
                    //console.log(array.push(wordList[b]));
                }
            }
            if(array.length!==0){
                console.log(array.join());
            }
            else{
                console.log(a);
                
            }
        }
    }

    
    

    //getElementById()
         


}


