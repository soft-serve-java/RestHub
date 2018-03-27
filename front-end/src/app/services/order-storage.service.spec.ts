import { TestBed, inject } from '@angular/core/testing';

import { OrderStorageService } from './order-storage.service';

describe('OrderStorageService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OrderStorageService]
    });
  });

  it('should be created', inject([OrderStorageService], (service: OrderStorageService) => {
    expect(service).toBeTruthy();
  }));
});
