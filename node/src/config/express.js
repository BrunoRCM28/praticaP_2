const express = require("express");
const app = express();

app.set("view engine", "ejs");
const path = require("path");
app.use(express.static("arquivos"));

const rotas = require("../app/ROTAS/rotas");
rotas(app);

module.exports = app;