import { ComponentFixture, TestBed } from '@angular/core/testing';
import { OrdemServicoComponent } from './ordem-servico-component';


describe('OrdemServicoComponentComponent', () => {
  let component: OrdemServicoComponent;
  let fixture: ComponentFixture<OrdemServicoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrdemServicoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdemServicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
