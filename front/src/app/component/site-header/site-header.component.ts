import { Component, ElementRef, HostListener, Renderer2, ViewChild } from '@angular/core';
import { LoginService } from '../../service/login.service';

@Component({
  selector: 'app-site-header',
  templateUrl: './site-header.component.html',
  styleUrl: './site-header.component.scss'
})
export class SiteHeaderComponent {

  @ViewChild('menu', { read: ElementRef })
  private menu?: ElementRef;

  public get IsAdmin(): boolean {
    return this.loginService.IsAdmin;
  }
  public get IsLogged(): boolean {
    return this.loginService.IsLogged;
  }

  constructor(
    private loginService: LoginService,
    private renderer2: Renderer2
  ) { }

  public innerWidth: any;
  ngOnInit() {
    this.innerWidth = window.innerWidth;
  }

  @HostListener('window:resize', ['$event'])
  onResize() {
  this.innerWidth = window.innerWidth;
  }

  abrirMenu() {
    if (this.menu?.nativeElement.classList.contains('off'))
      this.renderer2.removeClass(this.menu?.nativeElement, "off");
    else
      this.renderer2.addClass(this.menu?.nativeElement, "off");
  }

  @HostListener('window:scroll', ['$event'])
  aparecerMenu() {
    window.addEventListener("scroll", function() {
      var header = document.querySelector('#header');
      header?.classList.toggle('rolagem', this.window.scrollY > 0);
    });
  }
}

