import { TestBed, inject } from '@angular/core/testing';

import { CookService } from './cook.service';

describe('CookService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CookService]
    });
  });

  it('should be created', inject([CookService], (service: CookService) => {
    expect(service).toBeTruthy();
  }));
});
