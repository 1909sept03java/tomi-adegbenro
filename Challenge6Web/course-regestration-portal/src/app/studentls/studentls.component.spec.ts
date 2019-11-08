import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentlsComponent } from './studentls.component';

describe('StudentlsComponent', () => {
  let component: StudentlsComponent;
  let fixture: ComponentFixture<StudentlsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentlsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentlsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
