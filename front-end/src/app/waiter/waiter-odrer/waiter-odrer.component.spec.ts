import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WaiterOdrerComponent } from './waiter-odrer.component';

describe('WaiterOdrerComponent', () => {
  let component: WaiterOdrerComponent;
  let fixture: ComponentFixture<WaiterOdrerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WaiterOdrerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WaiterOdrerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
