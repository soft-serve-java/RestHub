import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TokenConfermeComponent } from './token-conferme.component';

describe('TokenConfermeComponent', () => {
  let component: TokenConfermeComponent;
  let fixture: ComponentFixture<TokenConfermeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TokenConfermeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TokenConfermeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
