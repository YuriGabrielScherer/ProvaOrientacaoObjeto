package beans;

public class Compra {

	// atributos
	private int codVendedor, codCli;
	private String dtCompra;
	private Carrinho carrinho;
	private double totalCompra;

	// Metodos GET

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public int getCodVendedor() {
		return codVendedor;
	}

	public int getCodCli() {
		return codCli;
	}

	public String getDtCompra() {
		return dtCompra;
	}

	public double getTotalCompra() {
		return totalCompra;
	}

	// Mtds SET

	public void setCodVendedor(int codVendedor) {
		this.codVendedor = codVendedor;
	}

	public void setCodCli(int codCli) {
		this.codCli = codCli;
	}

	public void setDtCompra(String dtCompra) {
		this.dtCompra = dtCompra;
	}

	public void setTotalCompra(double totalCompra) {
		this.totalCompra = totalCompra;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
}
