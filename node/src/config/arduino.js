const five = require("johnny-five");
const board = new five.Board({ port: 'COM3', baudRate: 9600 });

class Teste{
  ligar(){
    board.on('ready', () => {
      // Use o mesmo pino que você definiu como `backLight` no Arduino
      const led = new five.Led(6);
      var lcd = new five.LCD({ 
        //LCD pin name  RS  EN  DB4 DB5 DB6 DB7
        // Arduino pin # 7    8   9   10  11  12
        pins: [12, 10, 5, 4, 3, 2],
        backlight: 13,
        rows: 2,
        cols: 16
      });
   
     lcd.on();
     lcd.cursor(0, 0).print("hello");
   
     led.on();
   });
  }
}


module.exports = Teste;


