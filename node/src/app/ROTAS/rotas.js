
const express = require("express")
const app = express()

module.exports = (app) => {
    app.use((req,res,next) => {
        res.header("Acess-Control-Allow-Origin", "*");
        next();
    });

    const hotelcontroller = require("../CONTROLLERS/CON_hotel");
    const hcontroller = new hotelcontroller();
    let urlencodedParser = express.urlencoded({extends: false});

    app.get("/",hcontroller.exibequarto());
    app.get("/1",hcontroller.exibehospede());
    app.get("/2",hcontroller.exibetipo());
    app.get("/3",hcontroller.exibereserva());
    app.get("/4",hcontroller.exibeestacionamento());

    app.get('/exclusaoesta/:id_Vaga', urlencodedParser,hcontroller.deletaesta(), function(req, res){
    });

    app.get('/exclusaohospede/:codigoCliente', urlencodedParser,hcontroller.deletahospede(), function(req, res){
    });

    app.get('/exclusaoquarto/:numeroQuarto', urlencodedParser,hcontroller.deletaquarto(), function(req, res){
        
    });

    app.get('/exclusaoreserva/:id_Reserva', urlencodedParser,hcontroller.deletareserva(), function(req, res){
    });

    app.get('/exclusaotipo/:id_Tipo', urlencodedParser,hcontroller.deletatipo(), function(req, res){
    });
}