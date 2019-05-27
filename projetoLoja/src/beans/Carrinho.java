package beans;

public class Carrinho {

	// Atributos do Carrinho

	private String nomeProduto;
	private int qnt;
	private double valor;

	// Metodos Get
	public String getNomeProduto() {
		return nomeProduto;
	}

	public int getQnt() {
		return qnt;
	}

	public double getValor() {
		return valor;
	}

	// Metodos SET

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
