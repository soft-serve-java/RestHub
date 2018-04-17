import { TestBed, inject } from '@angular/core/testing';

import { AdminCategoryService } from './admin-category.service';

describe('AdminCategoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdminCategoryService]
    });
  });

  it('should be created', inject([AdminCategoryService], (service: AdminCategoryService) => {
    expect(service).toBeTruthy();
  }));
});
