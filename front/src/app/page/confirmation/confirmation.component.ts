import { WeddingService } from '../../service/wedding.service';
import { Component } from '@angular/core';

const MAX_ADULT = 5;
const MAX_CHILD = 10;

const initArray = function (arrayQuantity: number) {
  return Array(arrayQuantity).fill(undefined).map((x, i) => i + 1);
}

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrl: './confirmation.component.scss'
})
export class ConfirmationComponent {

  adultItens = initArray(MAX_ADULT);
  childItens = initArray(MAX_CHILD);

  fullName?: string;
  answer?: boolean;
  adultQuantity: number = 1;
  childQuantity: number = 1;
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
      adultQuantity: this.adultQuantity,
      childQuantity: this.childQuantity,
      email: this.email,
      phone: this.phone,
      obs: this.obs,
      adultsNames: this.adultsNames.filter((x, i) => i < this.adultQuantity + 1),
      childrenNames: this.childrenNames.filter((x, i) => i < this.childQuantity + 1)
    }).subscribe({
      complete: () => {
        console.log("sucesso");
      }
    });
  }

  initNewArray(arrayQuantity: number) {
    return initArray(arrayQuantity);
  }

}
