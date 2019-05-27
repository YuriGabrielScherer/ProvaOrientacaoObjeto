package dados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import beans.Carrinho;
import beans.Cliente;
import beans.Compra;
import beans.Funcionario;
import beans.Produto;
import beans.TipoProdutos;

public class Dados {

	// Banco de Dados Funcionario
	public static List<Funcionario> vetorFuncionario = new ArrayList<Funcionario>();

	// Banco de Dados Clientes
	public static List<Cliente> vetorCliente = new ArrayList<Cliente>();

	// Banco de Dados Produtos
	public static List<Produto> vetorProduto = new ArrayList<Produto>();

	// Banco de Dados Tipos de Produtos
	public static List<TipoProdutos> vetorTipoProduto = new ArrayList<TipoProdutos>();

	// Banco de Dados para Carrinhos
	public static List<Carrinho> vetorCarrinho = new ArrayList<Carrinho>();

	// Banco de Dados para Compra
	public static List<Compra> vetorCompra = new ArrayList<Compra>();

}
