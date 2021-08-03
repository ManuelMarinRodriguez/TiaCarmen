export class Venta {
    monto: number;
    tipoVenta: string;
    voucherId: number;

    constructor(monto: number, tipoVenta: string, voucherId: number) {
        this.monto = monto;
        this.tipoVenta = tipoVenta;
        this.voucherId = voucherId;
    }
}