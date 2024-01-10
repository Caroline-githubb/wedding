import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './page/home/home.component';
import { GiftsComponent } from './page/gifts/gifts.component';
import { ReceptionComponent } from './page/reception/reception.component';
import { WeddingComponent } from './page/wedding/wedding.component';
import { LoginComponent } from './page/login/login.component';
import { AdminComponent } from './page/admin/admin.component';
import { adminGuard } from './guard/admin.guard';
import { ConfirmationComponent } from './page/confirmation/confirmation.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'gifts', component: GiftsComponent },
  { path: 'wedding', component: WeddingComponent },
  { path: 'reception', component: ReceptionComponent },
  { path: 'login', component: LoginComponent },
  { path: 'confirmation', component: ConfirmationComponent },
  { path: 'admin', component: AdminComponent, canActivate: [adminGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
