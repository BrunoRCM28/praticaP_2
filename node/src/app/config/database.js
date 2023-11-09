var Connection = require('tedious').Connection;  
var config = {  
    server: 'regulus.cotuca.unicamp.br',
    authentication: {
        type: 'default',
        options: {
            userName: 'BD23537', 
            password: 'BD23537'  
        }
    },
    options: {
        encrypt: true,
        database: 'BD23537'  
    }
};  
var connection = new Connection(config);  
connection.on('connect', function(err) {  
    console.log("Connected");  
});

connection.connect();