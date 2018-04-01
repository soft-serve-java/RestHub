import { TestBed, inject } from '@angular/core/testing';

import { TableStorageService } from './table-storage.service';

describe('TableStorageService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TableStorageService]
    });
  });

  it('should be created', inject([TableStorageService], (service: TableStorageService) => {
    expect(service).toBeTruthy();
  }));
});
