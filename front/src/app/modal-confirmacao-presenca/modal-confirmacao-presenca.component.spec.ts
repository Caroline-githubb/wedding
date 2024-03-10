import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalConfirmacaoPresencaComponent } from './modal-confirmacao-presenca.component';

describe('ModalConfirmacaoPresencaComponent', () => {
  let component: ModalConfirmacaoPresencaComponent;
  let fixture: ComponentFixture<ModalConfirmacaoPresencaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ModalConfirmacaoPresencaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ModalConfirmacaoPresencaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
