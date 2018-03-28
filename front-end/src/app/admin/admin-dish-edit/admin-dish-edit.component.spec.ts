import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDishEditComponent } from './admin-dish-edit.component';

describe('AdminDishEditComponent', () => {
  let component: AdminDishEditComponent;
  let fixture: ComponentFixture<AdminDishEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminDishEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDishEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
