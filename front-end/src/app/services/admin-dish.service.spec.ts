import { TestBed, inject } from '@angular/core/testing';

import { AdminDishService } from './admin-dish.service';

describe('AdminDishService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdminDishService]
    });
  });

  it('should be created', inject([AdminDishService], (service: AdminDishService) => {
    expect(service).toBeTruthy();
  }));
});
