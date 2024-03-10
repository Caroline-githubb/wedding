import { Component, HostListener } from '@angular/core';
import { ModalService } from '../../component/modal/modal.service';
import { MessageBoxComponent, MessageBoxType } from '../../component/message-box/message-box.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

  public innerWidth: any;

  constructor(
    private modalService: ModalService,
  ) { }

  ngOnInit() {
    this.innerWidth = window.innerWidth;
  }

  @HostListener('window:resize', ['$event'])
  onResize() {
    this.innerWidth = window.innerWidth;
  }
}
