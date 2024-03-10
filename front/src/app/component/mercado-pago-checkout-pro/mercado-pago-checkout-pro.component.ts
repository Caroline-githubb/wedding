import { Component, Inject, Input, OnInit } from '@angular/core';
import { MODAL_DATA } from '../modal/modal.component';

declare var MercadoPago: any;

@Component({
  selector: 'app-mercado-pago-checkout-pro',
  templateUrl: './mercado-pago-checkout-pro.component.html',
  styleUrl: './mercado-pago-checkout-pro.component.scss',
  exportAs:'mercadopago'
})
export class MercadoPagoCheckoutProComponent implements OnInit {

  private mp: any;
  private bricksBuilder: any;

  constructor(
    @Inject(MODAL_DATA) private data: any,
  ) {
    this.mp = new MercadoPago('TEST-9c9661d7-501c-4df5-b0f1-d58d4e10682b');
    this.bricksBuilder = this.mp.bricks();
  }

  ngOnInit(): void {
    if (this.data.preferenceId) {
      this.init(this.data.preferenceId);
    }
  }

  public init(preferenceId: String) {
    this.bricksBuilder.create("wallet", "mercado_pago", {
      initialization: {
        preferenceId: preferenceId,
      },
      onSubmit: () => {

      },
      onError: () => {

      },
      onReady: () => {

      },
      customization: {
        texts: {
          valueProp: 'smart_option',
        },
      },
    });
  }

}
