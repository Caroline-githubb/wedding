import { WeddingService } from '../../service/wedding.service';
import { Component } from '@angular/core';

const MAX_ADULT = 5;
const MAX_CHILD = 10;

const initArray = function (arrayQuantity: number, start_from: number) {
  return Array(arrayQuantity).fill(undefined).map((x, i) => i + start_from);
}

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrl: './confirmation.component.scss'
})
export class ConfirmationComponent {

  adultItens = initArray(MAX_ADULT, 1);
  childItens = initArray(MAX_CHILD, 0);

  fullName?: string;
  answer?: boolean;
  adultQuantity: number = 1;
  childQuantity: number = 0;
  email?: string;
  phone?: string;
  obs?: string;
  adultsNames: string[] = [];
  childrenNames: string[] = [];

  constructor(
    private weddingService: WeddingService,
  ) { }

  sendClick(): void {
    this.weddingService.confirmInvite({
      fullName: this.fullName,
      answer: this.answer,
      email: this.email,
      phone: this.phone,
      obs: this.obs,
      adultsNames: this.adultsNames.filter((x, i) => i < this.adultQuantity - 1),
      childrenNames: this.childrenNames.filter((x, i) => i < this.childQuantity - 1)
    }).subscribe({
      complete: () => {
        console.log("sucesso");
      }
    });
  }

  initNewArray(arrayQuantity: number, start_from: number) {
    return initArray(arrayQuantity, start_from);
  }

}
