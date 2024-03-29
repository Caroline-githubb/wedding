import { Configuration } from './autogenerated/back-map/configuration';
import { ApiModule } from './autogenerated/back-map/api.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GiftsComponent } from './page/gifts/gifts.component';
import { HomeComponent } from './page/home/home.component';
import { SiteHeaderComponent } from './component/site-header/site-header.component';
import { HttpClientModule } from '@angular/common/http';
import { WeddingComponent } from './page/wedding/wedding.component';
import { ReceptionComponent } from './page/reception/reception.component';
import { AdminComponent } from './page/admin/admin.component';
import { LoginComponent } from './page/login/login.component';
import { FormsModule } from '@angular/forms';
import { JwtModule } from '@auth0/angular-jwt';
import { PaymentComponent } from './page/payment/payment.component';
import { ConfirmationComponent } from './page/confirmation/confirmation.component';
import { ModalDirective } from './directive/modal.directive';
import { GiftResumeComponent } from './page/gifts/gift-resume/gift-resume.component';
import { MercadoPagoCheckoutProComponent } from './component/mercado-pago-checkout-pro/mercado-pago-checkout-pro.component';

export function tokenGetter() {
  return localStorage.getItem("access_token");
}

@NgModule({
  declarations: [
    AppComponent,
    GiftsComponent,
    HomeComponent,
    SiteHeaderComponent,
    WeddingComponent,
    ReceptionComponent,
    AdminComponent,
    LoginComponent,
    PaymentComponent,
    ConfirmationComponent,
    ModalDirective,
    GiftResumeComponent,
    MercadoPagoCheckoutProComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: tokenGetter,
        allowedDomains: ["example.com"],
        disallowedRoutes: ["http://example.com/examplebadroute/"],
      },
    }),
    AppRoutingModule,
    HttpClientModule,
    ApiModule.forRoot(() => {
      return new Configuration({
        basePath: 'http://localhost:8080'
      })
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
