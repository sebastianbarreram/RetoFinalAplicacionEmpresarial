import { TestBed } from '@angular/core/testing';

import { BoardAPIService } from './board-api.service';

describe('BoardAPIService', () => {
  let service: BoardAPIService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BoardAPIService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
