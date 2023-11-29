
const express = require("express")
const app = express()

module.exports = (app) => {
    app.use((req,res,next) => {
        res.header("Acess-Control-Allow-Origin", "*");
        next();
    });

    const hotelcontroller = require("../CONTROLLERS/CON_hotel");
    const hcontroller = new hotelcontroller();
    let urlencodedParser = express.urlencoded({extends: true});

    app.get("/listagemquarto",hcontroller.exibequarto());
    app.get("/listagemhospedes",hcontroller.exibehospede());
    app.get("/listagemtipoquarto",hcontroller.exibetipo());
    app.get("/listagemreservas",hcontroller.exibereserva());
    app.get("/listagemestacionamento",hcontroller.exibeestacionamento());

    app.get('/', function(req, res){
        res.render('main')
    });

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

    //edições

    app.get('/editaestacionamento/:id_Vaga', urlencodedParser, function(req, res){
        res.render('estacionamentoed')
    });
    app.post('/estaed/:id_Vaga', urlencodedParser,hcontroller.editacarro(), function(req, res){
    });

    app.get('/editahospedes/:codigoCliente', urlencodedParser, function(req, res){
        res.render('hospedeed')
    });
    app.post('/hosed/:codigoCliente', urlencodedParser,hcontroller.editahospede(), function(req, res){
    });

    app.get('/editareserva/:id_Reserva', urlencodedParser, function(req, res){
        res.render('reservaed')
    });
    app.post('/editareserva/:id_Reserva', urlencodedParser,hcontroller.editahospede(), function(req, res){
    });

    app.get('/editatipo/:id_tipo', urlencodedParser, function(req, res){
        res.render('tipoquartoed')
    });
    app.post('/editatipo/:id_tipo', urlencodedParser,hcontroller.editatipo(), function(req, res){
    });

    app.get('/editaquarto/:numeroQuarto', urlencodedParser, function(req, res){
        res.render('quartoed')
    });
    app.post('/editaq/:numeroQuarto', urlencodedParser,hcontroller.editaquarto(), function(req, res){
    });
}