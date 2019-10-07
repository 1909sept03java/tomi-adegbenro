import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { PailindromeComponent } from './pailindrome/pailindrome.component';
import { BubblesortComponent } from './bubblesort/bubblesort.component';

@NgModule({
  declarations: [
    AppComponent,
    PailindromeComponent,
    BubblesortComponent
    ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
