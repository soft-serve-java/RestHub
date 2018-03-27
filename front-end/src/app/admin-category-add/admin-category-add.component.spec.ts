import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCategoryAddComponent } from './admin-category-add.component';

describe('AdminCategoryAddComponent', () => {
  let component: AdminCategoryAddComponent;
  let fixture: ComponentFixture<AdminCategoryAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCategoryAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCategoryAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
