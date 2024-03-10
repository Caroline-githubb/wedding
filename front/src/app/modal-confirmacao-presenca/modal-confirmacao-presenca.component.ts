import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-modal-confirmacao-presenca',
  templateUrl: './modal-confirmacao-presenca.component.html',
  styleUrl: './modal-confirmacao-presenca.component.scss'
})
export class ModalConfirmacaoPresencaComponent  implements AfterViewInit{
  @ViewChild('focar')
  buttonPraFocar?: ElementRef;

  constructor(public activeModal: NgbActiveModal) { }

  ngAfterViewInit() {
    this.buttonPraFocar?.nativeElement?.focus();
  }
}





