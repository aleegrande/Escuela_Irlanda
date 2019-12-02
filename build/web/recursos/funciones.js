/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Validar formulario-AE-8
function validarFormulario(forma) {

    //Validar usuario
    var usuario = forma.usuario2.value;
    if (usuario === "")
    {
        alert("Debe proporcionar un nombre de usuario");
        return false;
    }

    //Validar password
    var password = forma.password2.value;
    if (password === "")
    {
        alert("Introduzca su contraseña");
        return false;
    }
    else
    {
        if(password.length < 8)
        {
            alert("Debe proporcionar una contraseña de al menos 8 caracteres");
            return false;
        }
    }

    //Validar tecnologias
    var idiomas = forma.idiomas;
    var checkSeleccionado = false;

    //Revisar que este seleccionada al menos una tecnologia    
    for (i = 0; i<idiomass.length; i++) 
    {
        if (idiomas[i].checked) 
        {
            checkSeleccionado = true;
        }
    }    
    if(checkSeleccionado === false)
    {
        alert("Debe seleccionar al menos 1 idioma");
        return false;
    }
    
    //Validar genero
    var genero = forma.genero;
    var seleccionGenero = false;
    
    for (i = 0; i<genero.length; i++)
    {
        if (genero[i].checked)
        {
            seleccionGenero = true;
        }
    }
    if (seleccionGenero === false)
    {
        alert("Debe seleccionar su genero");
        return false;
    }
    
    //Validar Ocupacion
    var nacionalidad = forma.nacionalidad;
    if(nacionalidad.value==="")
    {
        alert("Debera seleccionar una nacionalidad");
        return false;
    }
    
    alert("Enviando formulario...");
    return true;
}



