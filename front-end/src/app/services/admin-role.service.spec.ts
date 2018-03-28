import { TestBed, inject } from '@angular/core/testing';

import { AdminRoleService } from './admin-role.service';

describe('AdminRoleService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdminRoleService]
    });
  });

  it('should be created', inject([AdminRoleService], (service: AdminRoleService) => {
    expect(service).toBeTruthy();
  }));
});
