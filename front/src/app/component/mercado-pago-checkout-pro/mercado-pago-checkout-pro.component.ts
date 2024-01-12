import { Component, Input, OnInit } from '@angular/core';

declare var MercadoPago: any;

@Component({
  selector: 'app-mercado-pago-checkout-pro',
  templateUrl: './mercado-pago-checkout-pro.component.html',
  styleUrl: './mercado-pago-checkout-pro.component.scss',
  exportAs:'mercadopago'
})
export class MercadoPagoCheckoutProComponent {

  private mp: any;
  private bricksBuilder: any;

  constructor() {
    this.mp = new MercadoPago('TEST-9c9661d7-501c-4df5-b0f1-d58d4e10682b');
    this.bricksBuilder = this.mp.bricks();
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
