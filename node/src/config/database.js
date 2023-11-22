const sql = require('mssql');

const config = {
    server: 'regulus.cotuca.unicamp.br',
    database: 'BD23537',
    user: 'BD23537',
    password: 'BD23537',
    options:{
      encrypt: true,
      trustServerCertificate: true
    }
};

const pool = new sql.ConnectionPool(config);

pool.connect()
  .then(() => {
    console.log("Conexão com o SQL Server realizada com sucesso!");
    return pool;
  })
  .catch(err => {
    console.error("Erro na conexão com o SQL Server:", err);
  });

module.exports = pool;

