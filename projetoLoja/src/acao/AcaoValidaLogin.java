package acao;

import dados.Dados;

public class AcaoValidaLogin {

	// Instanciando Classe Banco
	Dados dados = new Dados();

	// Metodo para Validar o Login
	public boolean validaLogin(String login, String senha) {

		// Variavel temporaria
		boolean ver = false;
		// Retornando valores do Banco

		for (int i = 0; i < (dados.vetorFuncionario.size()); i++) {
			if (login.equals(dados.vetorFuncionario.get(i).getNomeP())
					&& (senha.equals(dados.vetorFuncionario.get(i).getSenhaFunc()))) {
				ver = true;
				break;
			}
		}

		return ver;

	}

}
