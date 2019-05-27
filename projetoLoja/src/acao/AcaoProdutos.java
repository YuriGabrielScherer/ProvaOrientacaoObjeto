package acao;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import beans.Produto;
import beans.TipoProdutos;
import dados.Dados;

public class AcaoProdutos {

	// Instanciando Classes
	Dados dados = new Dados();
	Produto prod = new Produto();

	// Metodos CRUD

	public boolean cadastrarProd(Produto prod) {
		// Metodo Cadastrar

		// Temp
		boolean ver = false;

		// Verificacao
		if (verificaVariaveis() == true) {

			// Tentando jogar no banco
			try {
				dados.vetorProduto.add(prod);
				ver = true;
			} catch (Exception e) {
			}
		} else {
			prod.setVerDadosProd(true);
		}

		// Verificacao Mensagem
		if (ver == false)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto, verifique os campos e tente novamente.",
					"Alerta do Sistema", 0);

		return ver;
	}

	public DefaultTableModel selecionar() {
		// Selecionar no Banco

		DefaultTableModel modelo = new DefaultTableModel();

		// Colunas
		modelo.addColumn("Produto");
		modelo.addColumn("Desc");
		modelo.addColumn("Tipo");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Valor");

		// Linhas
		for (int i = 0; i < (dados.vetorProduto.size()); i++) {
			modelo.addRow(new Object[] { // Add linhas
					dados.vetorProduto.get(i).getNomeProd(), // --
					dados.vetorProduto.get(i).getDescProd(), // --
					dados.vetorTipoProduto.get(dados.vetorProduto.get(i).getTpProd()).getTipoProduto(),
					dados.vetorProduto.get(i).getQntProd(), // --
					dados.vetorProduto.get(i).getVlProd() // --
			});
		}

		return modelo;
	}

	public DefaultTableModel selecionarFiltro(String nome, String desc) {
		// Selecionar no Banco

		DefaultTableModel modelo = new DefaultTableModel();

		// Colunas
		modelo.addColumn("Produto");
		modelo.addColumn("Desc");
		modelo.addColumn("Tipo");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Valor");

		// Variavel temp
		String temp = "";

		// Linhas
		for (int i = 0; i < (dados.vetorProduto.size()); i++) {

			// Verificando igual ou nao
			if (nome.equalsIgnoreCase(dados.vetorProduto.get(i).getNomeProd().substring(0, nome.length())) ||
			// Verificando na descricao
					desc.equalsIgnoreCase(dados.vetorProduto.get(i).getDescProd().substring(0, nome.length()))) {
				// Add
				modelo.addRow(new Object[] { // Add linhas
						dados.vetorProduto.get(i).getNomeProd(), // --
						dados.vetorProduto.get(i).getDescProd(), // --
						dados.vetorTipoProduto.get(dados.vetorProduto.get(i).getTpProd()).getTipoProduto(),
						dados.vetorProduto.get(i).getQntProd(), // --
						dados.vetorProduto.get(i).getVlProd() // --
				});
			}

		}

		return modelo;

	}

	public DefaultTableModel selecionarTipo(int index) {
		// Selecionar no Banco

		DefaultTableModel modelo = new DefaultTableModel();

		// Colunas
		modelo.addColumn("Produto");
		modelo.addColumn("Desc");
		modelo.addColumn("Tipo");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Valor");

		// Linhas
		for (int i = 0; i < (dados.vetorProduto.size()); i++) {

			// Verificando Tipo
			if (index == dados.vetorProduto.get(i).getTpProd()) {

				// Add
				modelo.addRow(new Object[] { // Add linhas
						dados.vetorProduto.get(i).getNomeProd(), // --
						dados.vetorProduto.get(i).getDescProd(), // --
						dados.vetorTipoProduto.get(dados.vetorProduto.get(i).getTpProd()).getTipoProduto(),
						dados.vetorProduto.get(i).getQntProd(), // --
						dados.vetorProduto.get(i).getVlProd() // --
				});
			}

		}

		return modelo;

	}

	public boolean alterarProduto(int index, Produto prod) {
		// Mtd Alterar Prod

		// Tmp
		boolean ver = false;

		// Verificacao
		if (verificaVariaveis() == true) {

			// Tentando alterar
			try {
				dados.vetorProduto.set(index, prod);
				ver = true;
			} catch (Exception e) {
			}
		} else {
			prod.setVerDadosProd(true);
		}

		// Verificacao para Mensagem
		if (ver == false)
			JOptionPane.showMessageDialog(null, "Erro ao alterar usuário, tente novamente.", "Alerta do Sistema", 0);

		return ver;

	}

	public void excluirProduto(int index) {
		// Mtd Excluir Produto

		// Excluindo
		dados.vetorProduto.remove(index);

	}

	public DefaultComboBoxModel<TipoProdutos> dadosTipoProdutos() {
		// Retornando modelo para o Combo Box

		DefaultComboBoxModel<TipoProdutos> modelo = new DefaultComboBoxModel<TipoProdutos>();
		for (int i = 0; i < dados.vetorTipoProduto.size(); i++) {
			modelo.addElement(dados.vetorTipoProduto.get(i));
		}

		return modelo;

	}

	// Verificacao das Variaveis
	private boolean verificaVariaveis() {

		// temp
		boolean ver = true;

		if (prod.getVerDadosProd() == false) {
			ver = false;
		}

		return ver;

	}

}
