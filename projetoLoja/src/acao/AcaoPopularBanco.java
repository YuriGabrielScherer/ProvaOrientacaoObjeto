package acao;

import java.text.DateFormat;
import java.util.Date;

import beans.Cliente;
import beans.Funcionario;
import beans.Produto;
import beans.TipoProdutos;
import dados.Dados;

public class AcaoPopularBanco {

	// Instanciar classes
	private Date dataNow = new Date();
	DateFormat formatarData = DateFormat.getDateInstance();
	TipoProdutos tpProd = new TipoProdutos();
	Dados dados = new Dados();

	private void popularFuncionario() {
		// Metodo Cadastrar Func

		Funcionario func = new Funcionario();
		AcaoFuncionario acaoFunc = new AcaoFuncionario();

		// Dados da Pessoa
		func.setNomeP("Yuri");
		func.setCpfP("125");
		func.setEnderecoP("Tusnelda Bachmann");
		func.setTelefoneP(123);
		func.setDtCadP(formatarData.format(dataNow));

		// Dados de Funcionario
		func.setCodigoFunc(1);
		func.setSalarioFunc(2100.50);
		func.setSenhaFunc("123");
		acaoFunc.cadastrar(func);
		
		Funcionario func1 = new Funcionario();
		// Dados da Pessoa
		func1.setNomeP("Ralf");
		func1.setCpfP("258");
		func1.setEnderecoP("Velha");
		func1.setTelefoneP(1298);
		func1.setDtCadP(formatarData.format(dataNow));

		// Dados de func1ionario
		func1.setCodigoFunc(2);
		func1.setSalarioFunc(1500.00);
		func1.setSenhaFunc("321");

		// Add
		
		acaoFunc.cadastrar(func1);
	}

	private void cadastrarTipos() {
		// Mts Cadastrar Tipos

		// Instanciando
		TipoProdutos tipo = new TipoProdutos();
		tipo.setTipoProduto("Computadores");

		TipoProdutos tipo1 = new TipoProdutos();
		tipo1.setTipoProduto("Smartphones");

		TipoProdutos tipo2 = new TipoProdutos();
		tipo2.setTipoProduto("Periféricos");

		TipoProdutos tipo3 = new TipoProdutos();
		tipo3.setTipoProduto("Redes");

		// Add
		dados.vetorTipoProduto.add(tipo);
		dados.vetorTipoProduto.add(tipo1);
		dados.vetorTipoProduto.add(tipo2);
		dados.vetorTipoProduto.add(tipo3);

	}

	private void cadastrarProdutos() {
		// Metodo para cadastrar Alguns produtos

		// Instanciar
		Produto prod1 = new Produto();
		prod1.setNomeProd("Computador Alpha");
		prod1.setDescProd("TECNOLOGIA PC gamer de alto desempenho");
		prod1.setQntProd(2);
		prod1.setTpProd(0);
		prod1.setVlProd(2500.00);
		prod1.setImgProd("img/alpha.png");

		Produto prod2 = new Produto();
		prod2.setNomeProd("iPhone 20S Super MAX");
		prod2.setDescProd("TECNOLOGIA Smartphone com câmera hiper mega blaster");
		prod2.setQntProd(10);
		prod2.setTpProd(1);
		prod2.setVlProd(20000.00);
		prod2.setImgProd("img/iphone.png");

		Produto prod3 = new Produto();
		prod3.setNomeProd("Switch Intel");
		prod3.setDescProd("Switch com processador desenvolvido e produzido pela AMD");
		prod3.setQntProd(15);
		prod3.setTpProd(3);
		prod3.setVlProd(500.00);
		prod3.setImgProd("#");

		Produto prod4 = new Produto();
		prod4.setNomeProd("Mouse Razer");
		prod4.setDescProd("Rato profissional para jogar CS e ser feliz");
		prod4.setQntProd(50);
		prod4.setTpProd(2);
		prod4.setVlProd(700.00);
		prod4.setImgProd("#");

		Produto prod5 = new Produto();
		prod5.setNomeProd("Computador Portátil");
		prod5.setDescProd("Notebook com placa de vídeo e processadora 13º geração AMD");
		prod5.setQntProd(3);
		prod5.setTpProd(0);
		prod5.setVlProd(7500.00);
		prod5.setImgProd("#");

		Produto prod6 = new Produto();
		prod6.setNomeProd("Roteador Wireless");
		prod6.setDescProd("Roteador com conexão para internet para sua casa");
		prod6.setQntProd(25);
		prod6.setTpProd(3);
		prod6.setVlProd(800.00);
		prod6.setImgProd("#");

		Produto prod7 = new Produto();
		prod7.setNomeProd("Smartphone Samsung S11");
		prod7.setDescProd("Celular Samsung com áudio stéreo");
		prod7.setQntProd(10);
		prod7.setTpProd(1);
		prod7.setVlProd(8500.00);
		prod7.setImgProd("#");

		// Add
		dados.vetorProduto.add(prod1);
		dados.vetorProduto.add(prod2);
		dados.vetorProduto.add(prod3);
		dados.vetorProduto.add(prod4);
		dados.vetorProduto.add(prod5);
		dados.vetorProduto.add(prod6);
		dados.vetorProduto.add(prod7);
	}

	private void cadastrarCliente() {
		// Metodo CadastrarClientes

		Cliente cli1 = new Cliente();
		cli1.setNomeP("Yuri");
		cli1.setTelefoneP(111222);
		cli1.setEnderecoP("Blumenau");
		cli1.setDtCadP("20/05/2019");
		cli1.setCpfP("125412");
		cli1.setCooperado(true);

		Cliente cli2 = new Cliente();
		cli2.setNomeP("Ralf");
		cli2.setTelefoneP(5522);
		cli2.setEnderecoP("Gaspar");
		cli2.setDtCadP("21/05/2019");
		cli2.setCpfP("9874");
		cli2.setCooperado(true);

		Cliente cli3 = new Cliente();
		cli3.setNomeP("Marco");
		cli3.setTelefoneP(6549);
		cli3.setEnderecoP("Blumenau");
		cli3.setDtCadP("25/05/2019");
		cli3.setCpfP("6985");
		cli3.setCooperado(false);

		// Add banco
		dados.vetorCliente.add(cli1);
		dados.vetorCliente.add(cli2);
		dados.vetorCliente.add(cli3);
	}

	public void popular() {
		popularFuncionario();
		cadastrarTipos();
		cadastrarProdutos();
		cadastrarCliente();
	}
}
