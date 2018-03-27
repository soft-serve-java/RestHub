import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminLtComponent } from './admin-lt.component';

describe('AdminLtComponent', () => {
  let component: AdminLtComponent;
  let fixture: ComponentFixture<AdminLtComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminLtComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminLtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
