const bd = require('./bdconnection')

async function seleciona()
{
    const conexao = await bd.getconexao();
    if (conexao==null) return null;
    try
    {
        const sql     = 'Select * from hotel.TipoQuarto where id_Tipo = 1'
        const teste = await conexao.query (sql);
        return { status: 200, data: teste.recordset };
    }
    catch (excecao)
    {
        return false;
    }
}

module.exports = {seleciona}