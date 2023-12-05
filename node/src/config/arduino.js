const {SerialPort} = require('serialport');
const arduino = new SerialPort({
    path: 'COM11',
    baudRate: 9600
});

function removerSucesso(num){
    arduino.write(''+num+'');
}

setTimeout(removerSucesso, 2000);