import { TestBed } from '@angular/core/testing';

import { ViewreimbService } from 'src/app/services/viewreimb.service';

describe('ViewreimbService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewreimbService = TestBed.get(ViewreimbService);
    expect(service).toBeTruthy();
  });
});
