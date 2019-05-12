import { TestBed } from '@angular/core/testing';

import { ResolvereimbService } from './resolvereimb.service';

describe('ResolvereimbService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ResolvereimbService = TestBed.get(ResolvereimbService);
    expect(service).toBeTruthy();
  });
});
