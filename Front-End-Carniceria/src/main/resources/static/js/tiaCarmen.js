var only_email = /(^[0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$/;
var d = new Date();
var mes = d.getMonth() + 1;
var dia = d.getDate();
var hora = d.getHours();
var minuto = d.getMinutes();
var segundo = d.getSeconds();
var milseg = d.getMilliseconds();


function copiarDatos(){

  var numeroSerie = document.getElementById("numeroserie").value;
  var referencia = document.getElementById("referencia").value;
  var peso = document.getElementById("peso").value;

  var texto = numeroSerie + "\t\t" + referencia + "\t\t" + peso;

  document.getElementById("textToEncode").innerHTML = texto;

}

function copiarDatos2(){



  var texto = "Codigo producto   Nombre                                                                                    Cantidad         Precio        IVA       123               Carne de Cerdo                                                                            2.4 KG           $2.400        $800"

  document.getElementById("textToEncode").innerHTML = texto;

}

function miFunc() {
    console.log("Paso");
  }