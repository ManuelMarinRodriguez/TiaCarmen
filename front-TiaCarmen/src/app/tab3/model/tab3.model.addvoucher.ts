import { Producto } from "./tab3.model.producto";

export class AddVoucher {
    productos: Array<Producto>;

    constructor(productos: Array<Producto>) {
        this.productos = productos;
    }
}