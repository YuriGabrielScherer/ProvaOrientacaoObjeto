package beans;

import javax.swing.JOptionPane;

public class Pessoa {

	// Atributos
	private String nomeP, enderecoP, cpfP;
	private int telefoneP;
	private String dtCadP;
	private static boolean verDadosP = true;

	//
	// Método Get
	//
	public String getNomeP() {
		return nomeP;
	}

	public String getDtCadP() {
		return dtCadP;
	}

	public static boolean getVerDadosP() {
		return verDadosP;
	}

	public String getEnderecoP() {
		return enderecoP;
	}

	public int getTelefoneP() {
		return telefoneP;
	}

	public String getCpfP() {
		return cpfP;
	}

	//
	// Metodos Set

	public static void setVerDadosP(boolean verDadosP) {
		Pessoa.verDadosP = verDadosP;
	}

	public void setNomeP(String nomeP) {

		// Verificando a integridade do Nome
		if (!nomeP.equals("")) {

			try {
				this.nomeP = nomeP;
			} catch (Exception e) {
				verDadosP = false;
			}

		} else {
			verDadosP = false;
		}

		// Verificacao para Mensagem
		if (verDadosP == false)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o nome. Tente novamente.", "Alerta do Sistema", 0);

	}

	public void setEnderecoP(String enderecoP) {

		// Verificacao do Campo Email
		if (!enderecoP.equals("")) {
			try {
				this.enderecoP = enderecoP;
			} catch (Exception e) {
				verDadosP = false;
			}
		} else {
			verDadosP = false;
		}

		// Verificacao para Mensagem
		if (verDadosP == false)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o endereço. Tente novamente.", "Alerta do Sistema",
					0);

	}

	public void setTelefoneP(int telefoneP) {

		// Verificacao do Campo telefone
		if (telefoneP > 0) {
			try {
				this.telefoneP = telefoneP;
			} catch (Exception e) {
				verDadosP = false;
				JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta do Sistema", 0);
			}
		} else {
			verDadosP = false;
		}

		// Verificacao para mensagem
		if (verDadosP == false)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o telefone. Tente novamente.", "Alerta do Sistema",
					0);

	}

	public void setCpfP(String cpfP) {

		// Verificacao do Campo CPF
		if (!(cpfP.equals(""))) {
			try {
				this.cpfP = cpfP;
			} catch (Exception e) {
				verDadosP = false;
			}
		} else {
			verDadosP = false;
		}

		// Verificacao para Mensagem
		if (verDadosP == false)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o CPF. Tente novamente.", "Alerta do Sistema", 0);
	}

	public void setDtCadP(String dtCadP) {

		// Verificacao do Campo Data Nascimento
		// Implementar

		this.dtCadP = dtCadP;
	}

}
