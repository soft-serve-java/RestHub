import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DishPageComponent } from './dish-page.component';

describe('DishPageComponent', () => {
  let component: DishPageComponent;
  let fixture: ComponentFixture<DishPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DishPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DishPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
