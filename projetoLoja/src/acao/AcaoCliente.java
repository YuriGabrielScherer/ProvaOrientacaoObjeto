package acao;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import beans.Cliente;
import dados.Dados;

public class AcaoCliente {

	// Instanciando classes
	Cliente cliente = new Cliente();
	Dados dados = new Dados();

	// CRUD

	public boolean cadastrar(Cliente cli) {
		// Metodo Cadastrar Cliente

		// Variavel temporaria
		boolean ver = false;

		try {

			// Verificando dados
			if (situacaoVerificadoras() == true) {

				// Adicionando no Banco de Dados
				try {
					dados.vetorCliente.add(cli);
					ver = true;
				} catch (Exception e) {
					ver = false;
				}
			} else {
				cliente.setVerDadosCli(true);
				cliente.setVerDadosP(true);
			}

		} catch (Exception e2) {
			ver = false;
		}

		// Verificacao para mensagem
		if (ver == false)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente. Tente novamente.", "Alerta do Sistema", 0);

		return ver;

	}

	public boolean alterar(int index, Cliente cli) {
		// Metodo Alterar Cliente

		// Temp
		boolean ver = false;
		// Verificando variaveis ok
		if (situacaoVerificadoras() == true) {
			try {
				dados.vetorCliente.set(index, cli);
				ver = true;
			} catch (Exception e) {
				ver = false;
			}
		}

		// Mensagem
		if (ver == false)
			JOptionPane.showMessageDialog(null, "Erro ao alterar o cliente, tente novamente.", "Alerta do Sistema", 0);

		return ver;
	}

	// Metodo Selecionar Cliente
	public DefaultTableModel selecionar() {
		DefaultTableModel modelo = new DefaultTableModel();

		// Add Colunas
		modelo.addColumn("Nome");
		modelo.addColumn("Endereço");
		modelo.addColumn("Telefone");
		modelo.addColumn("CPF");
		modelo.addColumn("Data Cad.");
		modelo.addColumn("Cooperado");

		// Add Linhas
		for (int i = 0; i < (dados.vetorCliente.size()); i++) {
			modelo.addRow(new Object[] {

					dados.vetorCliente.get(i).getNomeP(), dados.vetorCliente.get(i).getEnderecoP(),
					dados.vetorCliente.get(i).getTelefoneP(), dados.vetorCliente.get(i).getCpfP(),
					dados.vetorCliente.get(i).getDtCadP(),
					(dados.vetorCliente.get(i).getCooperadoCli() == true ? "Sim" : "Não")

			});
		}

		return modelo;
	}

	public boolean excluir(int index) {
		// Metodo Excluir Cliente

		// Temp
		boolean ver = false;

		// Excluindo
		try {
			dados.vetorCliente.remove(index);
			ver = true;
		} catch (Exception e) {
			ver = false;
		}

		if (ver == false)
			JOptionPane.showMessageDialog(null, "Erro ao excluir o cliente. Tente novamente.", "Alerta do Sistema", 0);

		return ver;
	}

	// -------------------------
	// OUTROS METODOS
	// --------------------------

	private boolean situacaoVerificadoras() {
		// Metodo para retornar antes de cadastrar no banco

		// temp
		boolean ver = false;

		if ((cliente.getVerDadosCli() == true) && (cliente.getVerDadosP() == true)) {
			ver = true;
		}

		return ver;
	}

	public DefaultComboBoxModel<String> selecionarCombo() {
		// Mtd Retornar Modelo

		// Instanciando
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>();
		modelo.addElement("Sem cadastro");
		// Percorrendo o Vetor
		for (int i = 0; i < (dados.vetorCliente.size()); i++) {
			modelo.addElement(dados.vetorCliente.get(i).getNomeP());
		}

		return modelo;

	}

}
