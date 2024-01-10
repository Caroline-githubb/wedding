import { Component } from '@angular/core';
import { LoginService } from '../../service/login.service';

@Component({
  selector: 'app-site-header',
  templateUrl: './site-header.component.html',
  styleUrl: './site-header.component.scss'
})
export class SiteHeaderComponent {

  public get IsAdmin(): boolean {
    return this.loginService.IsAdmin;
  }
  public get IsLogged(): boolean {
    return this.loginService.IsLogged;
  }

  constructor(
    private loginService: LoginService
  ) { }

}
