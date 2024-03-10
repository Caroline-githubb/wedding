import { Component, Inject, Input } from '@angular/core';
import { MODAL_DATA, ModalComponent } from '../modal/modal.component';

@Component({
  selector: 'app-message-box',
  templateUrl: './message-box.component.html',
  styleUrl: './message-box.component.scss'
})
export class MessageBoxComponent {

  buttonsEnableds = [
    { value: MessageBoxButton.OK, text: "OK" },
    { value: MessageBoxButton.YES, text: "Sim" },
    { value: MessageBoxButton.CONFIRM, text: "Confirmar" },
    { value: MessageBoxButton.NO, text: "Não" },
    { value: MessageBoxButton.CANCEL, text: "Cancelar" },
  ]

  @Input()
  title?: string;

  @Input()
  message: string;

  @Input()
  type: MessageBoxType = MessageBoxType.INFO;

  @Input()
  buttons?: MessageBoxButton = MessageBoxButton.OK;

  constructor(
    private modal: ModalComponent<MessageBoxButton>,
    @Inject(MODAL_DATA) private data: MessageBoxOptions,
  ) {
    this.message = this.data.message;

    if (this.data.title)
      this.title = this.data.title;

    if (this.data.type)
      this.type = this.data.type;

    if (this.data.buttons)
      this.buttons = this.data.buttons;
  }

  public close(button: MessageBoxButton) {
    this.modal.close(button);
  }

  getStateClass() {
    switch (this.type) {
      case MessageBoxType.INFO:
        return "info";
      case MessageBoxType.WARNING:
        return "warnig";
      case MessageBoxType.ERROR:
        return "error";
      case MessageBoxType.SUCCESS:
        return "success";
      case MessageBoxType.QUESTION:
        return "question";
    }
  }

  isButtonVisible(button: MessageBoxButton) {
    if (!this.buttons)
      return false;

    return button & this.buttons;
  }
}

export enum MessageBoxButton {
  OK = 1,
  YES = 1 << 2,
  CONFIRM = 1 << 3,
  NO = 1 << 3,
  CANCEL = 1 << 4,
}

export enum MessageBoxType {
  INFO,
  WARNING,
  QUESTION,
  SUCCESS,
  ERROR,
}

export interface MessageBoxOptions {
  title?: string;
  message: string;
  type?: MessageBoxType;
  buttons?: MessageBoxButton;
}