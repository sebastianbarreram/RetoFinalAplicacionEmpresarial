import { TestBed } from '@angular/core/testing';

import { CardGameAPIService } from './card-api.service';

describe('CardGameAPIService', () => {
  let service: CardGameAPIService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CardGameAPIService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
