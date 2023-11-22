
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
}