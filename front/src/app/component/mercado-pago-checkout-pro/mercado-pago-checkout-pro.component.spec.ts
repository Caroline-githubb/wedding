import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MercadoPagoCheckoutProComponent } from './mercado-pago-checkout-pro.component';

describe('MercadoPagoCheckoutProComponent', () => {
  let component: MercadoPagoCheckoutProComponent;
  let fixture: ComponentFixture<MercadoPagoCheckoutProComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MercadoPagoCheckoutProComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MercadoPagoCheckoutProComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
