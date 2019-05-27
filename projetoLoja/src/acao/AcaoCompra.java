package acao;

import javax.swing.table.DefaultTableModel;

import beans.Carrinho;
import beans.Compra;
import beans.Produto;
import dados.Dados;

public class AcaoCompra {

	// Instancias
	Dados dados = new Dados();

	// Metodos CRUD

	public void adicionarCompra(Compra compra) {
		// Metodo para adicionar no Carrinho

		dados.vetorCompra.add(compra);
	}

	public void reduzirEstoque(String produto, int qntComprada) {
		// Mtd para reduzir estoque

		// Variaveis
		int codProd = -1;
		int estoqueAtual = 0;
		boolean ver = false;

		// Percorrendo o vetor
		for (int i = 0; i < (dados.vetorProduto.size()); i++) {
			if (produto.equals(dados.vetorProduto.get(i).getNomeProd())) {
				estoqueAtual = dados.vetorProduto.get(i).getQntProd();
				codProd = i;
				ver = true;
				break;
			}
		}

		if (ver == true) {
			// Realizando novo estoque
			Produto p1 = new Produto();
			p1.setNomeProd(dados.vetorProduto.get(codProd).getNomeProd());
			p1.setDescProd(dados.vetorProduto.get(codProd).getDescProd());
			p1.setImgProd(dados.vetorProduto.get(codProd).getImgProd());
			p1.setTpProd(dados.vetorProduto.get(codProd).getTpProd());
			p1.setVlProd(dados.vetorProduto.get(codProd).getVlProd());
			p1.setQntProdAlterada(estoqueAtual - qntComprada);

			dados.vetorProduto.set(codProd, p1);
		}

	}

	// ----------
	// Acoes para Carrinhos
	// ---------

	public void adicionarCarrinho(Carrinho carrinho) {
		// Mtd para adicionar no carrinho

		// Add
		dados.vetorCarrinho.add(carrinho);

	}

	public DefaultTableModel selecionarCarrinho() {
		// Metodo para retornar para a tabela

		DefaultTableModel modelo = new DefaultTableModel();

		// Colunas
		modelo.addColumn("Produto");
		modelo.addColumn("Valor unitário");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Total");

		// Linhas
		for (int i = 0; i < (dados.vetorCarrinho.size()); i++) {
			modelo.addRow(new Object[] { dados.vetorCarrinho.get(i).getNomeProduto(),
					dados.vetorCarrinho.get(i).getValor(), dados.vetorCarrinho.get(i).getQnt(),
					(dados.vetorCarrinho.get(i).getValor()) * (dados.vetorCarrinho.get(i).getQnt())

			});
		}

		return modelo;

	}

	public void limparCarrinho() {
		// Mtd limpar carrinho
		dados.vetorCarrinho.clear();
	}

	public void excluirItemCarrinho(int index) {
		// Mtd tirar item carrinho

		dados.vetorCarrinho.remove(index);
	}

	public boolean verificarQuantidade(String produto, int index) {
		// Mtd para verificar quantidade

		// Temp
		boolean ver = true;

		// Percorrendo o vetor e verificando
		for (int i = 0; i < (dados.vetorProduto.size()); i++) {
			if (produto.equalsIgnoreCase(dados.vetorProduto.get(i).getNomeProd())) {

				// Verificando a quantidade
				if (index > dados.vetorProduto.get(i).getQntProd() || index == 0) {
					ver = false;
				}
			}

		}

		return ver;
	}

	public double calcularTotal() {
		// Mtd para Calcular o Total

		double vlTotal = 0;

		// Percorrendo e calculando
		for (int i = 0; i < (dados.vetorCarrinho.size()); i++) {
			vlTotal += dados.vetorCarrinho.get(i).getValor() * dados.vetorCarrinho.get(i).getQnt();
		}

		return vlTotal;
	}

	public void alterarQuantidade(int index, int novaQuantidade) {
		// Mtd para alterar a quantidade cadastrada

		// Instanciar
		Carrinho carrinho = new Carrinho();
		carrinho.setNomeProduto(dados.vetorCarrinho.get(index).getNomeProduto());
		carrinho.setValor(dados.vetorCarrinho.get(index).getValor());
		carrinho.setQnt(novaQuantidade);

		// Add Banco
		dados.vetorCarrinho.set(index, carrinho);

	}

}
