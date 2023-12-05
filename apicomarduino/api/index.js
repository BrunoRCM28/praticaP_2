const express = require ('express');
const bd = require ('./bdconnection');
const cmd = require ('./bdcmds')
const body = require('body-parser')

function middleWareGlobal (req, res, next)
{
    console.time('Duração');
    console.log('Iniciou  o processamento da requisição '+req.method+' em '+req.url);

    next();
               
    console.log('Terminou o processamento da requisição '+req.method+' em '+req.url);
    console.timeEnd('Duração');
}

async function servidor(){
    const ret = await bd.getestrututra()

    if (ret === null){
        console.log('não foi possivel estabelecer conexão com o bd');
        process.exit(1);
    }

    if (ret==false){
        console.log('não foi possivel estruturar o bd')
        process.exit(1)
    }
    const express = require('express');
    const app = express()

    app.use(body.json())
    app.use(middleWareGlobal)

    app.get('/lesp', cmd.seleciona,(req,res) =>{
        res.status(200)
    })


    console.log('Servidor ativo na porta 3000')
    app.listen(3000)

    
}

servidor()