package beans;

import dados.Dados;

public class TipoProdutos {

	// Instanciando
	Dados dado = new Dados();

	// Tipos de Produtos
	private String tipoProduto;

	// Metodos Get e Set
	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String toString() {
		return this.tipoProduto;
	}

}
