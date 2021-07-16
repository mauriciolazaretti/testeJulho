import { TestBed } from '@angular/core/testing';

import { OrdemServicoService } from './ordem-servico.service';

describe('OrdemServicoServiceService', () => {
  let service: OrdemServicoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrdemServicoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
