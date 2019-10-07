import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pailindrome',
  templateUrl: './pailindrome.component.html',
  styleUrls: ['./pailindrome.component.css']
})
export class PailindromeComponent implements OnInit {

  constructor() { }

  in2 = {
    pinput: ''
  };

  //pinput = "";
  
  isPailindrome(word){
    let wordlength = word.length;
    let pali = true;

    for (let i = 0; i <wordlength/2; i++){
      if (word[i] !== word[wordlength - 1 - i]) { //if characters are not equal return false
        pali = false;
        console.log(pali);
        return pali;
      }

    }
    pali = true;
    console.log(pali);
    return pali;
  }

  ngOnInit() {
  }

}
