import { AfterViewInit, Component, ElementRef, ViewChild, InjectionToken, Injector, ViewContainerRef, Output, EventEmitter, Type, ComponentRef } from '@angular/core';

declare const M: any;

export const MODAL_DATA = new InjectionToken("MODAL_DATA")

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.scss'
})
export class ModalComponent<T = any> implements AfterViewInit {

  @ViewChild('modalRef')
  modal?: ElementRef;

  @ViewChild('container', { read: ViewContainerRef })
  container?: ViewContainerRef;

  private materialModalInstance: any;

  @Output()
  onCompleteLoad = new EventEmitter();

  @Output()
  afterClosed = new EventEmitter();

  constructor(
    private injector: Injector
  ) {
    
  }
  ngAfterViewInit(): void {
    this.materialModalInstance = M.Modal.init(this.modal?.nativeElement, {
      onCloseEnd: () => { this.afterClosed.emit(); }
    });
    this.onCompleteLoad.emit();
  }

  public open() {
    this.materialModalInstance?.open();
  }

  public close(value?: T) {
    this.afterClosed.emit(value);
  }

  createContainer<T>(type: Type<T>, data: any): ComponentRef<T> | undefined {
    const injector = Injector.create({
      providers: [
        {
          provide: MODAL_DATA,
          useValue: data
        },
        {
          provide: ModalComponent,
          useValue: this
        }
      ],
      parent: this.injector
    });

    return this.container?.createComponent(type, {
      injector: injector
    })
  }

}
