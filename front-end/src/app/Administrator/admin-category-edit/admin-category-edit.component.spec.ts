import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCategoryEditComponent } from './admin-category-edit.component';

describe('AdminCategoryEditComponent', () => {
  let component: AdminCategoryEditComponent;
  let fixture: ComponentFixture<AdminCategoryEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCategoryEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCategoryEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
