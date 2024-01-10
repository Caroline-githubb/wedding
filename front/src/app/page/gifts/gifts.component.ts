import { Component } from '@angular/core';
import { Gift } from '../../autogenerated/back-map';
import { WeddingService } from '../../service/wedding.service';

@Component({
  selector: 'app-gifts',
  templateUrl: './gifts.component.html',
  styleUrl: './gifts.component.scss'
})
export class GiftsComponent {

  gifts: Gift[] = [];

  constructor(
    private weddingService: WeddingService
  ) { }

  ngOnInit(): void {
    this.weddingService.getAllAvailableGifts().subscribe(gifts => {
      this.gifts = gifts;
    })
  }

}
