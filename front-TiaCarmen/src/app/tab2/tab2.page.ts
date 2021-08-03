import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AlertComponent } from '../alert/alert.component';
import { ConsultaCliente, Empresa, Factura, RepresentanteLegal } from './model/tab2.model.factura';
import { Tab2Service } from './service/tab2.service';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss'],
  providers: [Tab2Service, AlertComponent]
})
export class Tab2Page {

  existeRepresentanteLegal = true;
  existeEmpresa = true;

  formControlFacturaId = new FormControl(null, [
    Validators.required, Validators.pattern("^[0-9]*$")
  ]);
  formControlRepLegalRut = new FormControl(null, [
    Validators.required, Validators.pattern("^[0-9]*$")
  ]);

  representanteLegal = new FormGroup({
    rutEmpresa: new FormControl(''),
    rutRepresentanteLegal: new FormControl(''),
    nombreRepresentanteLegal: new FormControl(''),
    telefonoRepresentanteLegal: new FormControl(''),
    emailRepresentanteLegal: new FormControl('')
  });

  empresaFormGroup = new FormGroup({
    rutEmpresa: new FormControl(''),
    nombreEmpresa: new FormControl(''),
    telefonoEmpresa: new FormControl(''),
    emailEmpresa: new FormControl('')
  });  

  consultaClienteFormGroup = new FormGroup({
    rutEmpresa: new FormControl(''),
    rutRepresentanteLegal: new FormControl('')
  });  

  constructor(private service: Tab2Service, private alert: AlertComponent) { }

  ngOnInit() {

  }

  pagarFactura() {
    var factura = new Factura(this.formControlFacturaId.value, this.formControlRepLegalRut.value);
    console.log(factura);
    this.service.pagarFactura(factura)
      .then((data) => {
        console.log("data:");
        console.log(data)
        this.formControlFacturaId.reset();
        this.formControlRepLegalRut.reset();
        this.alert.presentAlert(data.resultado, "Paga Factura");
      })
  }

  addEmpresa() {
    console.log("add empresa");
    console.log(this.empresaFormGroup.value);
    var empresa = new Empresa(this.empresaFormGroup.value.rutEmpresa, this.empresaFormGroup.value.nombreEmpresa, this.empresaFormGroup.value.telefonoEmpresa, this.empresaFormGroup.value.emailEmpresa);
    console.log(empresa);
    this.service.addEmpresa(empresa)
      .then((data) => {        
        console.log(data)
        this.empresaFormGroup.reset();
        this.alert.presentAlert(data.respuesta, "Crear Empresa");
        this.existeEmpresa = true;
      })
  }  

  addRepresentanteLegal() {
    console.log("rep legal");
    console.log(this.representanteLegal.value);
    var representanteLegal = new RepresentanteLegal(this.representanteLegal.value.rutEmpresa, this.representanteLegal.value.nombreRepresentanteLegal, this.representanteLegal.value.nombreRepresentanteLegal, this.representanteLegal.value.telefonoRepresentanteLegal, this.representanteLegal.value.emailRepresentanteLegal);
    console.log(representanteLegal);
    this.service.addRepresentanteLegal(representanteLegal)
      .then((data) => {        
        console.log(data)
        this.representanteLegal.reset();
        this.alert.presentAlert(data.respuesta, "Agregar Representante Legal");

        this.existeRepresentanteLegal = true;
      })
  }

  consultaCliente() {
    console.log("consulta cliente");
    console.log(this.consultaClienteFormGroup.value);
    var consultaCliente = new ConsultaCliente(this.consultaClienteFormGroup.value.rutEmpresa, this.consultaClienteFormGroup.value.rutRepresentanteLegal);
    console.log(consultaCliente);
    this.service.consultaCliente(consultaCliente)
      .then((data) => {  
        console.log("consulta cliente");
        console.log(data);
        this.consultaClienteFormGroup.reset();
        var mensaje = "";
        if (data.rutRepresentanteLegal == "NO") {
          mensaje += "debe agregar el representante legal \r"
        }

        if (data.rutEmpresa == "NO") {
          mensaje += " debe agregar la empresa";
        }
        this.alert.presentAlert(mensaje, "Consulta Cliente");

        console.log(this.existeRepresentanteLegal);
        console.log(data.rutRepresentanteLegal);
        console.log(data.rutEmpresa);

        this.existeRepresentanteLegal = data.rutRepresentanteLegal == "SI";
        this.existeEmpresa = data.rutEmpresa == "SI";
      })
  }
}
