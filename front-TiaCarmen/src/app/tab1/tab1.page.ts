import { Component } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { AlertComponent } from '../alert/alert.component';
import { Boleta } from './model/tab1.model.boleta';
import { Tab1Service } from './service/tab1.service';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss'],
  providers: [Tab1Service, AlertComponent]
})
export class Tab1Page {

  formControlId = new FormControl(null, [
    Validators.required, Validators.pattern("^[0-9]*$")
  ]);

  constructor(private service: Tab1Service, private alert: AlertComponent) { }

  pagarBoleta() {

    var boleta = new Boleta(this.formControlId.value);
    console.log(boleta);
    this.service.pagarBoleta(boleta)
      .then((data) => {
        console.log("volvio");
        console.log(data)
        this.formControlId.reset();
        this.alert.presentAlert(data.resultado, "Pagar Boleta");
      })
  }
}
