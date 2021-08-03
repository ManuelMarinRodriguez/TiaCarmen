import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Boleta } from '../model/tab1.model.boleta';

@Injectable({
  providedIn: 'root'
})
export class Tab1Service {

  private pagarBoletaUrl = "http://localhost:8027/pagarBoleta";

  constructor(private http: HttpClient) { }

  private handleError(error: any): Promise<any> {
    console.error("An error occurred mau", JSON.stringify(error)); // for demo purposes only
    return Promise.reject(error);
  }

  public async pagarBoleta(boleta: Boleta): Promise<any> {
    return this.http
      .post(this.pagarBoletaUrl, boleta)
      .toPromise()
      .then((response) => response as any)
      .catch(this.handleError);
  }
}
