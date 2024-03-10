import { ApplicationRef, Injectable, Type, ViewContainerRef } from '@angular/core';
import { ModalComponent } from './modal.component';
import { MessageBoxButton, MessageBoxComponent, MessageBoxOptions } from '../message-box/message-box.component';

@Injectable({
  providedIn: 'root'
})
export class ModalService {

  private viewContainerRef: ViewContainerRef;

  constructor(
    private applicationRef: ApplicationRef
  ) {
    this.viewContainerRef = applicationRef.components[0]?.injector?.get(ViewContainerRef);
  }

  public open<T>(type: Type<any>, data?: any): ModalComponent<T> {
    if (!this.viewContainerRef)
      return undefined as unknown as ModalComponent<T>;

    const modal = this.viewContainerRef.createComponent(ModalComponent);

    modal.instance.onCompleteLoad.subscribe(() => {
      const component = modal.instance.createContainer(type, data);
      modal.instance.open();
      modal.instance.afterClosed.subscribe(() => {
        component?.destroy();
        modal.destroy();
      });
    });

    return modal.instance;
  }

  public openMessageBox(data?: MessageBoxOptions): ModalComponent<MessageBoxButton> {
    return this.open(MessageBoxComponent, data)
  }

}
