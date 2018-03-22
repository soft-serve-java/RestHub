import { TestBed, inject } from '@angular/core/testing';

import { AdminUserEditService } from './admin-user-edit.service';

describe('AdminUserEditService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdminUserEditService]
    });
  });

  it('should be created', inject([AdminUserEditService], (service: AdminUserEditService) => {
    expect(service).toBeTruthy();
  }));
});
