import { Component } from '@angular/core';
import { AlertComponent } from '../alert/alert.component';
import { Producto } from './model/tab3.model.producto';
import { Venta } from './model/tab3.model.venta';
import { Tab3Service } from './service/tab3.service';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss'],
  providers: [Tab3Service, AlertComponent]
})
export class Tab3Page {

  productos: Array<Producto>;

  codigoBarra: string;
  cantidadProducto: string;

  monto: number;
  tipoVenta: string;
  voucherId: number;

  constructor(private service: Tab3Service, private alert: AlertComponent) {
    this.productos = new Array<Producto>();
  }

  addProducto() {
    if (this.codigoBarra != "" && this.cantidadProducto != "") {
      let producto = new Producto(+this.codigoBarra, +this.cantidadProducto);
      this.productos.push(producto);
    }

    this.codigoBarra = "";
    this.cantidadProducto = "";

    console.log(this.productos);
  }

  addVoucher() {
    this.service.crearVoucher(this.productos)
      .then((data) => {
        console.log(data);
        this.alert.presentAlert(data.resultado, "Agregar Voucher");
      })
  }
  
  addVenta(){
    var venta = new Venta(this.monto, this.tipoVenta, this.voucherId);

    this.service.crearVenta(venta)
      .then((data) => {
        console.log(data);
        this.alert.presentAlert(data.resultado, "Agregar Venta");
      })
  }
}
