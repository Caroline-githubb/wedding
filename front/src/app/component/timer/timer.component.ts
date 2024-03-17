import { Component, OnInit } from '@angular/core';
import { interval } from 'rxjs';
import moment from 'moment';
import { Duration } from 'moment';


@Component({
  selector: 'app-timer',
  templateUrl: './timer.component.html',
  styleUrl: './timer.component.scss'
})
export class TimerComponent implements OnInit{

  private DATA_CASAMENTO = new Date(2024, 3, 6, 16, 0); // 2024-04-06

  public restante?: Duration;

  constructor() {
    this.atualizarRestante();
  }

  ngOnInit() {
    interval(1000)
    .subscribe(() => {
      this.atualizarRestante();
    });
  }

  private atualizarRestante() {
    const hoje = moment(new Date());
    const data_casamento = moment(this.DATA_CASAMENTO);

    this.restante = moment.duration(data_casamento.diff(hoje));
  }

  public truncar(valor?: number) {
    if (valor)
      return Math.trunc(valor);
    else
      return 0;
  }
}
