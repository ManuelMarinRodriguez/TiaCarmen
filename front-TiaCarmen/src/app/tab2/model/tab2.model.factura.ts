export class Factura {
    numeroVenta: number;
    rutEmpresa: string;

    constructor(numeroVenta: number, rutEmpresa: string) {
        this.numeroVenta = numeroVenta;
        this.rutEmpresa = rutEmpresa;
    }
}

export class RepresentanteLegal {
    rutEmpresa: string;
    rutRepresentanteLegal: string;
    nombreRepresentanteLegal: string;
    telefonoRepresentanteLegal: string;
    emailRepresentanteLegal: string;

    constructor(rutEmpresa: string, rutRepresentanteLegal: string, nombreRepresentanteLegal: string, telefonoRepresentanteLegal: string, emailRepresentanteLegal:string) {
        this.rutEmpresa = rutEmpresa;
        this.rutRepresentanteLegal = rutRepresentanteLegal;
        this.nombreRepresentanteLegal = nombreRepresentanteLegal;
        this.telefonoRepresentanteLegal = telefonoRepresentanteLegal;
        this.emailRepresentanteLegal = emailRepresentanteLegal;
    }
}

export class Empresa {
    rutEmpresa: string;
    nombreEmpresa: string;
    telefonoEmpresa: string;
    emailEmpresa: string;

    constructor(rutEmpresa: string, nombreEmpresa: string, telefonoEmpresa: string, emailEmpresa:string) {
        this.rutEmpresa = rutEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.emailEmpresa = emailEmpresa;
    }
}

export class ConsultaCliente {
    rutEmpresa: string;
    rutRepresentanteLegal: string;

    constructor(rutEmpresa: string, rutRepresentanteLegal: string) {
        this.rutEmpresa = rutEmpresa;
        this.rutRepresentanteLegal = rutRepresentanteLegal;
    }
}