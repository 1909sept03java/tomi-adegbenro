import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bubblesort',
  templateUrl: './bubblesort.component.html',
  styleUrls: ['./bubblesort.component.css']
})
export class BubblesortComponent implements OnInit {

  constructor() { }

  in = {
    pinput: '',
    answer :''
  };

  
  //function invoked when event occurs
  public bubbleSort(n: string): string{
    let nArray = n.split(" ");
    let nLength = nArray.length;
		//Looping through the array
		for (let i=0; i < nLength-1; i++) {
			for(let j=0; j < nLength-i-1; j++) {
				if(nArray[j] > nArray[j+1]) {
					let temp = nArray[j];
					nArray[j] = nArray[j+1];
					nArray[j+1] = temp;
				}
			}
    }
    //let result:string = nArray.toString();
    this.in.answer = nArray.toString();
    console.log(this.in.answer);
		return this.in.answer;
  }
  
  //answer = this.bubbleSort(this.in.pinput);

  ngOnInit() {
  }

}
