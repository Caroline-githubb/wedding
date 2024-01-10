import { Component } from '@angular/core';
import { LoginService } from '../../service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  login?: string;
  password?: string;

  constructor(
    private loginService: LoginService,
    private router: Router
  ) { }

  public loginClick(): void {
    if (!this.login)
      return;

    if (!this.password)
      return;

    this.loginService.login(this.login, this.password).subscribe({
      next: resp => {
        this.router.navigate(['/'])
      },
      error: err => {
        console.log(err);
      }
    });
  }

}
