import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Producto } from '../model/tab3.model.producto';
import { AddVoucher } from '../model/tab3.model.addvoucher';
import { Venta } from '../model/tab3.model.venta';

@Injectable({
  providedIn: 'root'
})
export class Tab3Service {

  private crearVoucherUrl = "http://localhost:8025/agregarvoucher";
  private crearVentaUrl = "http://localhost:8027/agregarventa";

  constructor(private http: HttpClient) { }

  private handleError(error: any): Promise<any> {
    console.error("An error occurred mau", JSON.stringify(error)); // for demo purposes only
    return Promise.reject(error);
  }

  public async crearVoucher(productos: Array<Producto>): Promise<any> {
    var voucherRequest = new AddVoucher(productos);
    return this.http
      .post(this.crearVoucherUrl, voucherRequest)
      .toPromise()
      .then((response) => response as any)
      .catch(this.handleError);
  }

  public async crearVenta(venta: Venta): Promise<any> {
    return this.http
      .post(this.crearVentaUrl, venta)
      .toPromise()
      .then((response) => response as any)
      .catch(this.handleError);
  }  
}
