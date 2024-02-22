import { Component, HostListener } from '@angular/core';
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

  public innerWidth: any;
  ngOnInit() {
    this.innerWidth = window.innerWidth;
  }

  @HostListener('window:resize', ['$event'])
  onResize() {
  this.innerWidth = window.innerWidth;
  }

}
