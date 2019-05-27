package beans;

import javax.swing.JOptionPane;

public class Produto {

	// Loja de Conveniencia Tecnologica

	// Atributos de Produtos

	private String nomeProd, descProd, dtCadProd, imgProd;
	private int qntProd, tpProd;
	private double vlProd;

	// Variavel verificadora
	public static boolean verDadosProd = true;

	// Metodos GET
	public static boolean getVerDadosProd() {
		return verDadosProd;
	}

	public int getTpProd() {
		return tpProd;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public String getDescProd() {
		return descProd;
	}

	public String getDtCadProd() {
		return dtCadProd;
	}

	public String getImgProd() {
		return imgProd;
	}

	public int getQntProd() {
		return qntProd;
	}

	public double getVlProd() {
		return vlProd;
	}

	// Metodos SET

	public void setNomeProd(String nomeProd) {

		// Verificacao
		if (!nomeProd.equals("")) {
			this.nomeProd = nomeProd;
		} else {
			verDadosProd = false;
		}

	}

	public void setDescProd(String descProd) {

		// Verificacao
		if (!descProd.equals("")) {
			this.descProd = descProd;
		} else {
			verDadosProd = false;
		}

	}

	public void setDtCadProd(String dtCadProd) {

		this.dtCadProd = dtCadProd;
	}

	public void setImgProd(String imgProd) {
		this.imgProd = imgProd;
	}

	public void setQntProd(int qntProd) {

		// Verificacao de quantidade
		if (qntProd == 0) {
			if (JOptionPane.showConfirmDialog(null, "Deseja cadastrar um produto com 0 de estoque?",
					"Alerta do Sistema", 0, 3) == 0) {
				this.qntProd = qntProd;
			} else {
				verDadosProd = false;
			}
		} else {
			this.qntProd = qntProd;
		}

	}

	public void setQntProdAlterada(int qntProd) {

		// Verificacao de quantidade
		this.qntProd = qntProd;

	}

	public void setVlProd(double vlProd) {

		// Verificacao
		if (vlProd != 0) {
			this.vlProd = vlProd;
		} else {
			verDadosProd = false;
		}

	}

	public static void setVerDadosProd(boolean verDadosProd) {
		Produto.verDadosProd = verDadosProd;
	}

	public void setTpProd(int tpProd) {

		// Verificacao
		if (tpProd >= 0) {
			this.tpProd = tpProd;
		} else {
			verDadosProd = false;
		}

	}

	// ----------
	// Metodos de Verificacao
	// --------

}
