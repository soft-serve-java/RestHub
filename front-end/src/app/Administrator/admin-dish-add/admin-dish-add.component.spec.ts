import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDishAddComponent } from './admin-dish-add.component';

describe('AdminDishAddComponent', () => {
  let component: AdminDishAddComponent;
  let fixture: ComponentFixture<AdminDishAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminDishAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDishAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
