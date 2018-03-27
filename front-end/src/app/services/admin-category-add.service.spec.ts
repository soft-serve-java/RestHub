import { TestBed, inject } from '@angular/core/testing';

import { AdminCategoryAddService } from './admin-category-add.service';

describe('AdminCategoryAddService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdminCategoryAddService]
    });
  });

  it('should be created', inject([AdminCategoryAddService], (service: AdminCategoryAddService) => {
    expect(service).toBeTruthy();
  }));
});
