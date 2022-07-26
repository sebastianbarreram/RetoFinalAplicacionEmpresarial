import { TestBed } from '@angular/core/testing';

import { PayerAPIService } from './player-api.service';

describe('PayerAPIService', () => {
  let service: PayerAPIService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PayerAPIService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
