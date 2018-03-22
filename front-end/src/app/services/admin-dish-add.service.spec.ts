import { TestBed, inject } from '@angular/core/testing';

import { AdminDishAddService } from './admin-dish-add.service';

describe('AdminDishAddService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdminDishAddService]
    });
  });

  it('should be created', inject([AdminDishAddService], (service: AdminDishAddService) => {
    expect(service).toBeTruthy();
  }));
});
