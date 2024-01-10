import { Component } from '@angular/core';

const MAX_ADULT = 5;
const MAX_CHILD = 10;

const init_array = function (arrayQuantity: number) {
  return Array(arrayQuantity).fill(undefined).map((x, i) => i + 1);
}

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrl: './confirmation.component.scss'
})
export class ConfirmationComponent {

  adultItens = init_array(MAX_ADULT);
  childItens = init_array(MAX_CHILD);

  fullName?: string;
  answer?: boolean;
  adultQuantity: number = 1;
  childQuantity: number = 1;
  email?: string;
  phone?: string;
  obs?: string;

  sendClick(): void {

  }

}
