import { Directive, ElementRef, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appLoadding]'
})
export class LoaddingDirective implements OnInit {

  constructor(
    private el: ElementRef,
    private renderer: Renderer2,
    ) { }

  ngOnInit(): void {
    this.hide();
  }

  show() {
    this.renderer.removeClass(this.el.nativeElement, 'off')
  }

  hide() {
    this.renderer.addClass(this.el.nativeElement, 'off')
  }

}
