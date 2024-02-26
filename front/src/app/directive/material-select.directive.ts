import { AfterContentChecked, AfterRenderOptions, AfterViewChecked, ContentChildren, Directive, ElementRef, OnChanges, OnInit, QueryList, SimpleChanges, ViewChildren } from '@angular/core';
import { timer } from 'rxjs';

declare var M: any;

@Directive({
  selector: 'select[appMaterialSelect]'
})
export class MaterialSelectDirective implements OnInit {

  private instances?: any;

  @ContentChildren("option")
  private set chidlen(value: QueryList<ElementRef>) {
    console.log(value);
    this.updateMaterial();
  } 

  constructor(private el: ElementRef) { }
  
  
  ngOnInit(): void {
    // timer(2000)
    // .subscribe(() => {
    //   M.FormSelect.init(this.el.nativeElement, {});
    // })
    this.updateMaterial();
  }

  private updateMaterial() {
    if (this.instances) {
      this.instances.destroy();
      delete this.instances;
    }
    this.instances = M.FormSelect.init(this.el.nativeElement, {});
  }

}
