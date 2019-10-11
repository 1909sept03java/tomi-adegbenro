import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pailindrome',
  templateUrl: './pailindrome.component.html',
  styleUrls: ['./pailindrome.component.css']
})
export class PailindromeComponent implements OnInit {

  constructor() { }

  in2 = {
    pinput: '',
    pali: true
  };

  //pinput = "";
  
  isPailindrome(word){
    let wordlength = word.length;
    this.in2.pali = true;

    for (let i = 0; i <wordlength/2; i++){
      if (word[i] !== word[wordlength - 1 - i]) { //if characters are not equal return false
        this.in2.pali = false;
        console.log(this.in2.pali);
        //return pali;
      }

    }
    //this.in2.pali = true;
    console.log(this.in2.pali);
    //return pali;
  }

  ngOnInit() {
  }

}
