export * from './authController.service';
import { AuthControllerService } from './authController.service';
export * from './confirmationController.service';
import { ConfirmationControllerService } from './confirmationController.service';
export * from './giftController.service';
import { GiftControllerService } from './giftController.service';
export const APIS = [AuthControllerService, ConfirmationControllerService, GiftControllerService];
