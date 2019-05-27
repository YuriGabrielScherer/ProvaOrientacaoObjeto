package acao;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import beans.Funcionario;
import dados.Dados;

public class AcaoFuncionario {

	// Instanciando Classes
	Funcionario func = new Funcionario();
	Dados dados = new Dados();

	//
	// CRUD

	public boolean cadastrar(Funcionario func) {
		// Variavel verificadora
		boolean ver = false;

		// Verificando Dados OK
		if (situacaoVerificadoras() == true) {

			// Adicionando no Banco de Dados
			try {
				dados.vetorFuncionario.add(func);
				ver = true;
			} catch (Exception e) {
				ver = false;
			}

		} else {

			// Resetando valores nas Classes para nao dar Pau depois
			func.setVerDadosFunc(true);
			func.setVerDadosP(true);
		}

		return ver;
	}

	public boolean alterar(int index, Funcionario func) {
		// Metodo Alterar Funcionario

		// Temp
		boolean ver = false;

		// Verificando Variavel ok
		if (situacaoVerificadoras() == true) {
			try {
				// Alterando
				dados.vetorFuncionario.set(index, func);
				ver = true;
			} catch (Exception e) {
				ver = false;
			}
		}

		// Verificando mensagem
		if (ver == false)
			JOptionPane.showMessageDialog(null, "Erro ao alterar o funcionário, tente novamente.", "Alerta do Sistema",
					0);

		return ver;
	}

	// Metodo Selecionar funcionario
	public DefaultTableModel selecionar() {

		DefaultTableModel modelo = new DefaultTableModel();

		// Add Colunas
		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("Data Cadastro");
		modelo.addColumn("Função");
		modelo.addColumn("Salário");

		// Add Linhas ao Modelo
		for (int i = 0; i < (dados.vetorFuncionario.size()); i++) {
			modelo.addRow(new Object[] { // Add Linha
					dados.vetorFuncionario.get(i).getNomeP(), dados.vetorFuncionario.get(i).getCpfP(),
					dados.vetorFuncionario.get(i).getDtCadP(), dados.vetorFuncionario.get(i).getCodigoFunc(),
					dados.vetorFuncionario.get(i).getSalarioFunc(), });
		}

		// Retornando
		return modelo;
	}

	public void excluir(int index) {
		// Metodo Excluir Funcionario

		// Realizando a exclusão
		dados.vetorFuncionario.remove(index);
	}

	//
	// Metodos Verificadores
	//

	// Return Situacao Variaveis
	private boolean situacaoVerificadoras() {

		// Verificadora
		boolean ver = false;

		// Verificando
		if ((func.getVerDadosFunc() == true) && (func.getVerDadosP() == true)) {
			ver = true;
		}

		return ver;
	}

}
