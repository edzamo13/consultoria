/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

PrimeFaces.locales['es'] = {
    closeText: 'Cerrar',
    prevText: 'Anterior',
    nextText: 'Siguiente',
    monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
    monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
    dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
    dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
    dayNamesMin: ['D', 'L', 'M', 'X', 'J', 'V', 'S'],
    weekHeader: 'Semana',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Sólo hora',
    timeText: 'Tiempo',
    hourText: 'Hora',
    minuteText: 'Minuto',
    secondText: 'Segundo',
    currentText: 'Fecha actual',
    ampm: false,
    month: 'Mes',
    week: 'Semana',
    day: 'Día',
    allDayText: 'Todo el día'
};


/**
 * Permite el ingreso de numeros enteros 
 * @param {type} item
 * @param {type} evento
 * @returns {Boolean}
 */
function numerosEnteros(item, evento) {
    var tecla = (evento.which) ? evento.which : evento.keyCode;

    // Validacion ingreso numeros
    if (((tecla >= 48 && tecla <= 57))) {
        return true;
    } else if ((tecla >= 33 && tecla <= 40) || (tecla == 13) || (tecla == 9) || (tecla == 8) || (tecla == 0)) {
        return (true);
    } else {
        return (false);
    }
}

/**
 * Permite el ingreso de numeros de coma flotante 
 * @param {type} item
 * @param {type} evento
 * @returns {Boolean}
 */
function numerosDobles(item, evento) {
    var tecla = (evento.which) ? evento.which : evento.keyCode;

    if (((tecla >= 48 && tecla <= 57))) {
        return true;
    } else if ((tecla >= 33 && tecla <= 40) || (tecla == 13) || (tecla == 9) || (tecla == 8) || (tecla == 46) || (tecla == 0)) {
        return (true);
    } else {
        return (false);
    }
}

/**
 * Permite el ingreso unicamente de letras
 * @param {type} item
 * @param {type} evento
 * @returns {Boolean}
 */
function letras(item, evento) {
    var tecla = (evento.which) ? evento.which : evento.keyCode;

    if ((tecla >= 65 && tecla <= 90) || (tecla >= 97 && tecla <= 122)) {
        return true;
    } else if ((tecla == 241) || (tecla == 209) || (tecla == 95) || (tecla == 45) || (tecla == 46) || (tecla >= 32 && tecla <= 40) || (tecla == 13) || (tecla == 10) || (tecla == 9) || (tecla == 8) || (tecla == 0)) {
        return (true);
    } else {
        return (false);
    }
}

/**
 * Permite el ingreso unicamente de letras, numeros y el caracter punto (.)
 * @param {type} item
 * @param {type} evento
 * @returns {Boolean}
 */
function alfanumerico(item, evento) {
    var tecla = (evento.which) ? evento.which : evento.keyCode;

    if ((tecla >= 65 && tecla <= 90) || (tecla >= 97 && tecla <= 122) || (tecla >= 48 && tecla <= 57)) {
        return true;
    } else if ((tecla == 241) || (tecla == 209) || (tecla == 95) || (tecla == 64) || (tecla == 44) || (tecla == 45) || (tecla == 46) ||
            (tecla >= 32 && tecla <= 40) || (tecla == 13) || (tecla == 9) || (tecla == 8) || (tecla == 0) || (tecla == 32)) {
        return (true);
    } else {
        return (false);
    }

    //tecla = (document.all) ? e.keyCode : e.which;
    /*
     if ((tecla == 8) || (tecla == 32) || (tecla == 9) || (tecla == 46))
     return true;
     patron = /[0-9A-Za-zñÑ]/;
     te = String.fromCharCode(tecla);
     return patron.test(te);*/
}

function alfanumericoTextArea(item, evento, valor, limite) {

    var tecla = (evento.which) ? evento.which : evento.keyCode;
    limite = limite - 1;

    if (valor.length <= limite) {
        if ((tecla >= 65 && tecla <= 90) || (tecla >= 97 && tecla <= 122) || (tecla >= 48 && tecla <= 57)) {
            return true;
        } else if ((tecla == 241) || (tecla == 209) ||(tecla == 95) || (tecla == 64) || (tecla == 45) || (tecla == 46) ||
                (tecla >= 32 && tecla <= 40) || (tecla == 13) || (tecla == 9) || (tecla == 8) || (tecla == 0) || (tecla == 32)) {
            return (true);
        } else {
            return (false);
        }
    }
    else {
        return false;
    }
}

/**
 * Permite limitar el tamanio de todos los componentes textArea
 * @param {type} valor
 * @param {type} limite
 * @returns {Boolean}
 */
function limiteTextArea(valor, limite) {
    limite = limite - 1;
    if (valor.length <= limite) {
        return true;
    }
    else {
        return false;
    }
}

/**
 * Permite el ingreso de numeros, letras y guion
 * @param {type} item
 * @param {type} evento
 * @returns {Boolean}
 */
function numLetraGuion(item, evento) {
    var tecla = (evento.which) ? evento.which : evento.keyCode;

    if ((tecla >= 65 && tecla <= 90) || (tecla >= 97 && tecla <= 122) || (tecla >= 48 && tecla <= 57)) {
        return true;
    } else if ((tecla == 45) || (tecla >= 33 && tecla <= 40) || (tecla == 8)) {
        return (true);
    } else {
        return (false);
    }
}

function numGuion(evt){ 
                
            // NOTE: Backspace = 8, Enter = 13, '0' = 48, '9' = 57 
    var key = (evt.which) ? evt.which : event.keyCode    
     if ((key < 48 || key > 57) && key!=8 &&  key!=45)
        return false;

        return true;
}