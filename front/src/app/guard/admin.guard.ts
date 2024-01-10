import { inject } from '@angular/core';
import { CanActivateFn } from '@angular/router';
import { LoginService } from '../service/login.service';

export const adminGuard: CanActivateFn = (route, state) => {
  return inject(LoginService).IsAdmin
};
