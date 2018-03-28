import { TestBed, inject } from '@angular/core/testing';

import { AdminOrderService } from './admin-order.service';

describe('AdminOrderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdminOrderService]
    });
  });

  it('should be created', inject([AdminOrderService], (service: AdminOrderService) => {
    expect(service).toBeTruthy();
  }));
});
