const five = require("johnny-five");
const board = new five.Board({ port: 'COM3', baudRate: 9600 });

board.on('ready', () => {
  const led = new five.Led(6); // Use o mesmo pino que você definiu como `backLight` no Arduino
  var lcd = new five.LCD({ 
    pins: [12, 11, 5, 4, 3, 2],
    backlight: 13,
    rows: 2,
    cols: 16
  });

  lcd.on();
  lcd.cursor(0, 0).print("hello");
});

