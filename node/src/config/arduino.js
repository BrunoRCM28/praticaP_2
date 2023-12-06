const five = require("johnny-five");
const board = new five.Board({ port: 'COM3', baudRate: 9600 });

class Ligar{
  removerSucesso(){
    board.on('ready', () => {
      const led = new five.Led(11);
      var lcd = new five.LCD({
        pins: [12, 10, 5, 4, 3, 2],
        backlight: 13,
        rows: 2,
        cols: 16
      });

     lcd.on();
     lcd.cursor(0, 0).print("Removido com");
     lcd.cursor(1, 0).print("Sucesso");

     led.on();

     setTimeout(() => {
      lcd.off();
      led.off();
      
     }, 5000)

    board.on("exit", () => {
      led.off();
    });

     
   });
  }

  removerErro(){
    board.on('ready', () => {
      const led = new five.Led(6);
      var lcd = new five.LCD({
        pins: [12, 10, 5, 4, 3, 2],
        backlight: 13,
        rows: 2,
        cols: 16
      });

     lcd.on();
     lcd.cursor(0, 0).print("[ERRO]Falha ao");
     lcd.cursor(1, 0).print("Remover");

   
     led.on();
     setTimeout(() => {
      lcd.off();
      led.off();
     }, 5000)
   });
  }

  editarSucesso(){
    board.on('ready', () => {
      const led = new five.Led(11);
      var lcd = new five.LCD({
        pins: [12, 10, 5, 4, 3, 2],
        backlight: 13,
        rows: 2,
        cols: 16
      });

     lcd.on();
     lcd.cursor(0, 0).print("Editado com");
     lcd.cursor(1, 0).print("Sucesso");

     led.on();

     setTimeout(() => {
      lcd.off();
      led.off();
     }, 5000)
   });
  }

  editarErro(){
    board.on('ready', () => {
      const led = new five.Led(6);
      var lcd = new five.LCD({
        pins: [12, 10, 5, 4, 3, 2],
        backlight: 13,
        rows: 2,
        cols: 16
      });

     lcd.on();
     lcd.cursor(0, 0).print("[ERRO]Falha ao");
     lcd.cursor(1, 0).print("Editar");

   
     led.on();
     setTimeout(() => {
      lcd.off();
      led.off();
     }, 5000)
   });
  }
}
  

module.exports = Ligar;


