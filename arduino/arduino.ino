#include <LiquidCrystal.h> //Inclusão da Biblioteca
LiquidCrystal lcd(12, 11, 10, 5, 4, 3, 2);

const int vermelho = 6;
const int verde = 9;
int entrada = 0;
int backLight = 13;

void setup(){
  pinMode(backLight, OUTPUT);
  pinMode(vermelho, OUTPUT);
  pinMode(verde, OUTPUT);
  Serial.begin(9600);
  lcd.begin(16, 2);
}
void loop(){
  if(Serial.available() > 0){
    
    entrada = Serial.read();
    Serial.print("Recebido: ");
    Serial.println(entrada);

    digitalWrite(backLight, LOW);
    
    switch(entrada){
      case '1':
        digitalWrite(verde, HIGH);
      	digitalWrite(vermelho, LOW);
        digitalWrite(backLight, HIGH);
        lcd.clear();
        lcd.setCursor(0, 0);
        lcd.print("Removido com");
        lcd.setCursor(0, 1);
        lcd.print("Sucesso");
        delay(5000);
      	break;
      case '2':
      	digitalWrite(verde, LOW);
        digitalWrite(vermelho, HIGH);
        digitalWrite(backLight, HIGH);
        lcd.clear();
        lcd.setCursor(0, 0);
        lcd.print("[ERRO]Falha ao");
        lcd.setCursor(0, 1);
        lcd.print("remover");
        delay(5000);
      	break;
      case '3':
        digitalWrite(verde, HIGH);
      	digitalWrite(vermelho, LOW);
        digitalWrite(backLight, HIGH);
        lcd.clear();
        lcd.setCursor(0, 0);
        lcd.print("Editado com");
        lcd.setCursor(0, 1);
        lcd.print("Sucesso");
        delay(5000);
      	break;
      case '4':
        digitalWrite(vermelho, HIGH);
      	digitalWrite(verde, LOW);
        digitalWrite(backLight, HIGH);
        lcd.clear();
        lcd.setCursor(0, 0);
        lcd.print("[ERRO]Falha ao");
        lcd.setCursor(0, 1);
        lcd.print("Editar");
        delay(5000);
      	break;
      default:
      	digitalWrite(vermelho, LOW);
      	digitalWrite(verde, LOW);
      	lcd.clear();
      	Serial.print("não da");
    }
  }
}
