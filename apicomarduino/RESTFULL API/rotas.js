const codigos = require('./codbancos.js');
const tipo = require('./tpquarto.js');
const Comunicado = require ('./comunicado.js');
const quarto = require('./quarto.js')
const { urlencoded } = require('express');
urlencoded

async function incluitipo(req,res){
    
    if (Object.values(req.body).length!=1 || !req.body.esp){
        const erro = Comunicado.novo('DdI','Dados inesperados','Não foram fornecido a informação necessaria para um tipo de quarto(Especificação)').object;
        return res.status(422).json(erro);
    }

    let tipoquarto;
    try{
        tipoquarto = tipo.novaesp(req.body.esp);
        console.log(tipoquarto)
    }
    catch(excecao){
        console.log(excecao)
        const erro = Comunicado.novo('TDE','Dado de tipo errado','especificação deve ser uma string').object;
        return res.status(422).json(erro);
    }

    const ret = await codigos.incluirespecificacao(livro);

    if (ret===null)
    {
        const  erro = Comunicado.novo('CBD','Sem conexão com o BD','Não foi possível estabelecer conexão com o banco de dados').object;
        return res.status(500).json(erro);
    }

    if (ret===false)
    {
        const  erro = Comunicado.novo('LJE','TipoQuarto já existe','Já há TipoQuarto cadastrado com o código informado').object;
        return res.status(409).json(erro);
    }

  
    const  sucesso = Comunicado.novo('IBS','Inclusão bem sucedida','O TipoQuarto foi incluído com sucesso').object;
    return res.status(201).json(sucesso);
  
}

async function selecionaespt (req, res)
{
    if (Object.values(req.body).length!=0)
    {
        const erro = Comunicado.novo('DSP','Fornecimento de dados sem propósito','Foram fornecidos dados sem necessidade no corpo da requisição').object;
        return res.status(422).json(erro);
    }

    const ret = await codigos.selecionarespt();
    if (ret===null)
    {
        const  erro = Comunicado.novo('CBD','Sem conexão com o BD','Não foi possível estabelecer conexão com o banco de dados').object;
        return res.status(500).json(erro);
    }
    if (ret===false)
    {
        const  erro = Comunicado.novo('FNC','Falha no comando SQL','O comando SQL apresenta algum erro').object;
        return res.status(409).json(erro);
    }
    console.log(ret);
    return res.status(200).json(ret);
}

async function incluiquarto(req,res){
    
    if (Object.values(req.body).length!=2 || !req.body.andar || !req.body.tipo){
        const erro = Comunicado.novo('DdI','Dados inesperados','Não foram fornecido a informação necessaria para um quarto(andar,tipo)').object;
        return res.status(422).json(erro);
    }

    let quartos;
    try{
        quartos = quarto.novoQuarto(req.body.andar,req.body.tipo);
        console.log(quarto.novoQuarto)
    }
    catch(excecao){
        console.log(excecao)
        const erro = Comunicado.novo('TDE','Dado de tipo errado','andar deve ser uma string e tipo deve ser inteiro').object;
        return res.status(422).json(erro);
    }

    const ret = await codigos.incluirquarto(quarto);

    if (ret===null)
    {
        const  erro = Comunicado.novo('CBD','Sem conexão com o BD','Não foi possível estabelecer conexão com o banco de dados').object;
        return res.status(500).json(erro);
    }

    if (ret===false)
    {
        const  erro = Comunicado.novo('LJE','quarto já existe','Já há quarto cadastrado com o código informado').object;
        return res.status(409).json(erro);
    }

  
    const  sucesso = Comunicado.novo('IBS','Inclusão bem sucedida','O quarto foi incluído com sucesso').object;
    return res.status(201).json(sucesso);

}

async function selecionarequarto (req, res)
{
    if (Object.values(req.body).length!=0)
    {
        const erro = Comunicado.novo('DSP','Fornecimento de dados sem propósito','Foram fornecidos dados sem necessidade no corpo da requisição').object;
        return res.status(422).json(erro);
    }

    const ret = await codigos.selecionarequarto();
    if (ret===null)
    {
        const  erro = Comunicado.novo('CBD','Sem conexão com o BD','Não foi possível estabelecer conexão com o banco de dados').object;
        return res.status(500).json(erro);
    }
    if (ret===false)
    {
        const  erro = Comunicado.novo('FNC','Falha no comando SQL','O comando SQL apresenta algum erro').object;
        return res.status(409).json(erro);
    }
    console.log(ret);
    return res.status(200).json(ret);
}

module.exports = {incluitipo,selecionaespt,incluiquarto,selecionarequarto}