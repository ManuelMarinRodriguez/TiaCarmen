import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ConsultaCliente, Empresa, Factura, RepresentanteLegal } from '../model/tab2.model.factura';

@Injectable({
  providedIn: 'root'
})
export class Tab2Service {

  private pagarFacturaUrl = "http://localhost:8027/pagarFactura";
  private addRepresentanteLegalUrl = "http://localhost:8024/AgregarRepLegal";
  private addEmpresaUrl = "http://localhost:8024/AgregarEmpresa";
  private consultaClienteUrl = "http://localhost:8024/ConsultaClientes";

  constructor(private http: HttpClient) { }

  private handleError(error: any): Promise<any> {
    console.error("An error occurred mau", JSON.stringify(error)); // for demo purposes only
    return Promise.reject(error);
  }

  public async pagarFactura(factura: Factura): Promise<any> {
    return this.http
      .post(this.pagarFacturaUrl, factura)
      .toPromise()
      .then((response) => response as any)
      .catch(this.handleError);
  }

  public async addEmpresa(empresa: Empresa): Promise<any> {
    return this.http
      .post(this.addEmpresaUrl, empresa)
      .toPromise()
      .then((response) => response as any)
      .catch(this.handleError);
  }  

  public async addRepresentanteLegal(representanteLegal: RepresentanteLegal): Promise<any> {
    return this.http
      .post(this.addRepresentanteLegalUrl, representanteLegal)
      .toPromise()
      .then((response) => response as any)
      .catch(this.handleError);
  } 
  
  public async consultaCliente(consultaCliente: ConsultaCliente): Promise<any> {
    return this.http
      .post(this.consultaClienteUrl, consultaCliente)
      .toPromise()
      .then((response) => response as any)
      .catch(this.handleError);
  }    
}
