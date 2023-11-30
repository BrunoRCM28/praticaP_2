const {serialPort} = require('serialport');
const arduino = new serialPort({
    path: 'COM3',
    baudRate: 9600
});

function removerSucesso(num){
    arduino.write(''+num+'');
}

setTimeout(removerSucesso, 2000);