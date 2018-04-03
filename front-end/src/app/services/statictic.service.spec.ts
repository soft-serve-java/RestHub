import { TestBed, inject } from '@angular/core/testing';

import { StaticticService } from './statictic.service';

describe('StaticticService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [StaticticService]
    });
  });

  it('should be created', inject([StaticticService], (service: StaticticService) => {
    expect(service).toBeTruthy();
  }));
});
