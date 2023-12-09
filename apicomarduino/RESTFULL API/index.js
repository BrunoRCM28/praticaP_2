const express  = require ('express');
const bd       = require ('./bd.js');
const rotas    = require ('./rotas.js');
const codigos = require('./codbancos.js');

function middleWareGlobal (req, res, next)
{
    console.time('Duração'); 
    console.log('Iniciou  o processamento da requisição '+req.method+' em '+req.url);

    next();
               
    console.log('Terminou o processamento da requisição '+req.method+' em '+req.url);
    console.timeEnd('Duração');
}

async function ativacaoDoServidor ()
{
    const ret = await bd.estrutureSe();

    if (ret===null)
    {
        console.log ('Não foi possível estabelecer conexão com o BD!');
        process.exit(1);
    }

    if (ret===false)
    {
        console.log ('Não foi possível estruturar o BD!');
        process.exit(1);
    }

    const express = require('express');
    const app     = express();
    
    app.use(express.json());
    app.use(middleWareGlobal);

    app.post  ('/cesp', rotas.incluitipo); 
    app.get  ('/lesp', rotas.selecionaespt);
    app.post  ('/cquarto', rotas.incluiquarto); 
    app.get  ('/lquarto', rotas.selecionarequarto);  

    console.log ('Servidor ativo na porta 3000...');
    app.listen(3000);
}
ativacaoDoServidor();
