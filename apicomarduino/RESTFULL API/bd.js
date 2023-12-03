const sql = require('mssql')


async function getConexao ()
{
    if (global.conexao && global.conexao.state !== 'disconnected')
        return global.conexao;

    try
    {
        const dados = {
            server: 'regulus.cotuca.unicamp.br',
            database: 'BD23632',
            user: 'BD23632',
            password: 'BD23632',
            options:{
              encrypt: true,
              trustServerCertificate: true
            }
        };
        
        
        const pool = new sql.ConnectionPool(dados)
        const conexao = await pool.connect()
        //pool.connect()
        global.conexao = conexao;
        return conexao;
    }
    catch (erro)
    {
        console.log(erro)
        return null;
    }
}

async function estrutureSe ()
{
    const conexao = await getConexao()
    if (conexao==undefined) return null;
    const sql2 = 'Select * from hotel.TipoQuarto';
    console.log(sql2)
    try
    {
        await conexao.query (sql2);
        return true;
    }
    catch (erro)
    {
        return false;
        console.log(erro)
    }
}

module.exports = {getConexao, estrutureSe}