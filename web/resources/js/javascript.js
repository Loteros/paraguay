var Euromillones = [];


function marcar(i)
{
        var valor = document.getElementById(i);
        var nuevoTD = document.createElement("td");
        nuevoTD.setAttribute("id",i);
        nuevoTD.setAttribute("align","center");
        var desmarca = "javascript:desmarcar('"+i+"');";
        nuevoTD.setAttribute("onclick",desmarca);

        if(valor.firstChild.nodeValue != "X")
        {
            if(Euromillones.length<5)
            {
                Euromillones.push(i);
                alert(Euromillones.length);
                var texto = document.createTextNode("X");
            }else{
                alert("Ya ha marcado la cantidad máxima de números permitidos.")
            }
        }else{
            //alert("El numero marcado es: "+i);
            var texto = document.createTextNode(i);            
        }

        nuevoTD.appendChild(texto);
        valor.parentNode.replaceChild(nuevoTD,valor);
     
}

function desmarcar(i){
    var valor = document.getElementById(i);
        var nuevoTD = document.createElement("td");
        nuevoTD.setAttribute("id",i);
        nuevoTD.setAttribute("align","center");
        var desmarca = "javascript:marcar('"+i+"');";
        nuevoTD.setAttribute("onclick",desmarca);
        var texto = document.createTextNode(i);
        nuevoTD.appendChild(texto);
        valor.parentNode.replaceChild(nuevoTD,valor);
     
}

function aleatorios(){
    var numerosValidos, numeroGenerado;
    var estado = false;
    //array donde se almacenarán los números correctos
    numerosValidos = new Array();
    while(numerosValidos<6){
        //genera un número aleatorio entre 0 y 49
        numeroGenerado = Math.floor(Math.random()*49+1);
        for(var t=0; t<numreosvalidos.length;t++){
           if(numreosValidos[t]==numeroGenerado){
                estado=true;   
           }
         }
         //si el número no esta repetido, lo guarda
         if(estado==false){
             numerosvalidos.push(numerogenerado);
         }
         estado=false;
    }
}
