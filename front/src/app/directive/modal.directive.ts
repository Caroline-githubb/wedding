import { Directive, ElementRef, OnDestroy, OnInit, Renderer2 } from '@angular/core';
import { Observable, Subscriber } from 'rxjs';

declare var M: any;

@Directive({
  selector: '[appModal]',
  exportAs:'modal'
})
export class ModalDirective implements OnInit, OnDestroy {

  private materialInstance: any;
  private openSubscriber?: Subscriber<void>;

  constructor(private renderer: Renderer2, private el: ElementRef) { }

  ngOnInit(): void {
    this.renderer.addClass(this.el.nativeElement, 'modal');
    this.materialInstance = M.Modal.init(this.el.nativeElement, {
      onCloseEnd: () => this.onClose()
    });
  }

  ngOnDestroy(): void {
    this.materialInstance.destroy();
  }

  public open(): Observable<void> {
    this.materialInstance.open();
    M.updateTextFields()
    return new Observable(subscriber => {
      this.openSubscriber = subscriber;
    });
  }

  public close() {
    this.materialInstance.close();
  }

  private onClose(): void {
    if (this.openSubscriber) {
      this.openSubscriber?.next();
      this.openSubscriber?.complete();
      delete this.openSubscriber;
    }
  }

}
