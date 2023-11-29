const {serialPort} = require('serialport');
const arduino = new serialPort({
    path: 'porta-do-arduino',
    baudRate: 9600
});

function removerSucesso(num){
    arduino.write(''+num+'');
}

setTimeout(reservaSucesso, 2000);