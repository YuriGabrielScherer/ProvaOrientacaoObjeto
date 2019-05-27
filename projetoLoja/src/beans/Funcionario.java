package beans;

import javax.swing.JOptionPane;

import acao.AcaoFuncionario;

public class Funcionario extends Pessoa {

	// Atributos
	private String senhaFunc;
	private int codigoFunc;
	private double salarioFunc;

	// CODIGO FUNCIONARIO
	// 1 - CHEFE EU
	// 2 - Atendente de Caixa
	// 3 - Gerente

	// Variavel Verificadora
	private static boolean verDadosFunc = true;

	// Metodo Get

	public String getSenhaFunc() {
		return senhaFunc;

	}

	public static boolean getVerDadosFunc() {
		return verDadosFunc;
	}

	public int getCodigoFunc() {
		return codigoFunc;
	}

	public double getSalarioFunc() {
		return salarioFunc;
	}

	// Metodos SET

	public void setSenhaFunc(String senhaFunc) {
		this.senhaFunc = senhaFunc;
	}

	public static void setVerDadosFunc(boolean verDados) {
		Funcionario.verDadosFunc = verDados;
	}

	public void setCodigoFunc(int codigoFunc) {

		// Verificacao do Código
		if (codigoFunc >= 0) {
			try {
				this.codigoFunc = codigoFunc;
			} catch (Exception e) {
				verDadosFunc = false;
			}
		} else {
			verDadosFunc = false;
		}

		// Verificacao para Mensagem
		if (verDadosFunc == false)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o código. Tente novamente.", "Alerta do Sistema", 0);
	}

	public void setSalarioFunc(double salarioFunc) {

		// Verificacao de Salario
		if (salarioFunc > 998.00) {
			try {
				this.salarioFunc = salarioFunc;
			} catch (Exception e) {
				verDadosFunc = false;
			}
		} else {
			verDadosFunc = false;
		}

		// Verificacao para Mensagem
		if (verDadosFunc == false)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o salário. Tente novamente.", "Alerta do Sistema",
					0);
	}

}
