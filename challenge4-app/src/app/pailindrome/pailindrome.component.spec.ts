import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PailindromeComponent } from './pailindrome.component';

describe('PailindromeComponent', () => {
  let component: PailindromeComponent;
  let fixture: ComponentFixture<PailindromeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PailindromeComponent ]
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
});
