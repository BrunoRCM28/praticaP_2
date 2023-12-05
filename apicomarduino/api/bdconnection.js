const sql = require('mssql')
const dados = require('./bdconfig')

async function getconexao(){
    if (global.conexao && global.conexao.state !== 'disconnected'){
        return global.conexao
    }
    try{
        const pool = new sql.ConnectionPool(dados)
        await pool.connect();
        const conexao = pool.connect()
        global.conexao = conexao
        return conexao
    }
    catch(erro){
        console.log(erro)
        return null;
    }
    
}

async function getestrututra(){
    const conexao = await getconexao()
    if (conexao==undefined) return null;
    const sql2 = 'Select * from hotel.TipoQuarto';
    console.log(sql2)
    try
    {
        const teste = await conexao.query (sql2);
        await teste;
        console.log(teste)
        return true;
    }
    catch (erro)
    {
        return false;
        console.log(erro)
    }
}

module.exports = {getconexao,getestrututra}