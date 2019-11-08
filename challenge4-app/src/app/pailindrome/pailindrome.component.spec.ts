import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PailindromeComponent } from './pailindrome.component';
import { AppComponent } from '../app.component';


describe('PailindromeComponent', () => {
  let component: PailindromeComponent;
  let fixture: ComponentFixture<PailindromeComponent>;
  beforeEach(async(() => {
    
    TestBed.configureTestingModule({
      declarations: [AppComponent, PailindromeComponent ]
      
    })
    
    .compileComponents();
    
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PailindromeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  fit('palindrome', () =>{
    expect(component.isPailindrome('madam')).toBe(true);
      
  })
});
