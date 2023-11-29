#include <LiquidCrystal.h>
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

    if(entrada == 'A' || entrada == 'a'){
      digitalWrite(vermelho, LOW);
      digitalWrite(backLight, HIGH);
      lcd.clear();
  	  lcd.setCursor(0, 0);
      lcd.print("Reserva Feita");
      lcd.setCursor(0, 1);
      lcd.print("com Sucesso");
      digitalWrite(verde, HIGH);
      
    }else if(entrada == 'B' || entrada == 'b'){
      digitalWrite(verde, LOW);
      digitalWrite(backLight, HIGH);
      lcd.clear();
  	  lcd.setCursor(0, 0);
      lcd.print("Erro em fazer");
      lcd.setCursor(0, 1);
      lcd.print("a reserva");
      digitalWrite(vermelho, HIGH);
    }
  }
}
