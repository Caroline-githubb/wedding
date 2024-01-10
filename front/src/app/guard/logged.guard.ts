import { CanActivateFn } from '@angular/router';
import { LoginService } from '../service/login.service';
import { inject } from '@angular/core';

export const loggedGuard: CanActivateFn = (route, state) => {
  return inject(LoginService).UserName ? true : false;
};
