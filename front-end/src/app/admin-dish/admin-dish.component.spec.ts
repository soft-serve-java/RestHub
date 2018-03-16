import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDishComponent } from './admin-dish.component';

describe('AdminDishComponent', () => {
  let component: AdminDishComponent;
  let fixture: ComponentFixture<AdminDishComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminDishComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDishComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
