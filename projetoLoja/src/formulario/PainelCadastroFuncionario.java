package formulario;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import acao.AcaoFuncionario;
import beans.Funcionario;
import dados.Dados;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class PainelCadastroFuncionario extends JPanel {

	// Construtor
	public PainelCadastroFuncionario() {
		painelCadFunc();
	}

	private JTextField txtNomeFunc;
	private JTextField txtEndFunc;
	private JTextField txtTelFunc;
	private JTextField txtCpfFunc;
	private JTextField txtSalarioFunc;
	private JPasswordField txtSenhaFunc;
	private JTable tableFunc;
	private JComboBox<String> cbbFuncaoFunc;

	// Comp do Painel
	private JButton btnAlterarFunc;
	private JButton btnExcluirFunc;
	private JButton btnCancelarFunc;
	private JButton btnCadastrarFunc;

	// Classes de Data
	private Date dataNow = new Date();
	DateFormat formatarData = DateFormat.getDateInstance();

	// Instanciar classes
	AcaoFuncionario acaoFunc = new AcaoFuncionario();
	Dados dados = new Dados();

	// Variaveis
	private static int codigoFunc;

	// Metodo para chamar o Painel de Cadastro de Func
	protected JPanel painelCadFunc() {

		JPanel panelCadFunc = new JPanel();
		panelCadFunc.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCadFunc.setBounds(10, 113, 764, 337);
		panelCadFunc.setLayout(null);

		JLabel lblCadastroDeFuncionrios = new JLabel("Cadastro de Funcion\u00E1rios");
		lblCadastroDeFuncionrios.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCadastroDeFuncionrios.setBounds(252, 11, 216, 14);
		panelCadFunc.add(lblCadastroDeFuncionrios);

		JLabel lbNomeFunc = new JLabel("Nome:");
		lbNomeFunc.setBounds(22, 53, 46, 14);
		panelCadFunc.add(lbNomeFunc);

		JLabel lbEndFunc = new JLabel("Endereço:");
		lbEndFunc.setBounds(10, 81, 58, 14);
		panelCadFunc.add(lbEndFunc);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 109, 58, 14);
		panelCadFunc.add(lblTelefone);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(22, 140, 46, 14);
		panelCadFunc.add(lblCpf);

		JLabel lblSalrio = new JLabel("Sal\u00E1rio:");
		lblSalrio.setBounds(311, 53, 46, 14);
		panelCadFunc.add(lblSalrio);

		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o:");
		lblFuno.setBounds(311, 81, 46, 14);
		panelCadFunc.add(lblFuno);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(311, 109, 46, 14);
		panelCadFunc.add(lblSenha);

		txtNomeFunc = new JTextField();
		txtNomeFunc.setBounds(78, 50, 173, 20);
		panelCadFunc.add(txtNomeFunc);
		txtNomeFunc.setColumns(10);

		txtEndFunc = new JTextField();
		txtEndFunc.setColumns(10);
		txtEndFunc.setBounds(78, 78, 173, 20);
		panelCadFunc.add(txtEndFunc);

		txtTelFunc = new JTextField();
		txtTelFunc.setColumns(10);
		txtTelFunc.setBounds(78, 106, 173, 20);
		panelCadFunc.add(txtTelFunc);

		txtCpfFunc = new JTextField();
		txtCpfFunc.setColumns(10);
		txtCpfFunc.setBounds(78, 137, 173, 20);
		panelCadFunc.add(txtCpfFunc);

		txtSalarioFunc = new JTextField();
		txtSalarioFunc.setColumns(10);
		txtSalarioFunc.setBounds(367, 50, 173, 20);
		panelCadFunc.add(txtSalarioFunc);

		cbbFuncaoFunc = new JComboBox<String>();
		cbbFuncaoFunc
				.setModel(new DefaultComboBoxModel(new String[] { "CEO", "Atendente", "Frente de Caixa", "Gerente" }));
		cbbFuncaoFunc.setBounds(367, 78, 173, 20);
		panelCadFunc.add(cbbFuncaoFunc);
		cbbFuncaoFunc.setSelectedIndex(-1);

		txtSenhaFunc = new JPasswordField();
		txtSenhaFunc.setBounds(367, 106, 173, 20);
		panelCadFunc.add(txtSenhaFunc);

		JPanel painelIconeFunc = new JPanel();
		painelIconeFunc.setBounds(573, 43, 180, 115);
		panelCadFunc.add(painelIconeFunc);
		painelIconeFunc.setLayout(null);

		JLabel lblCon = new JLabel(new ImageIcon("C:/Users/i3i/Desktop/workspace/projetoLoja/img/CadCli.png"));
		lblCon.setHorizontalAlignment(SwingConstants.CENTER);
		lblCon.setBounds(0, 0, 180, 115);
		painelIconeFunc.add(lblCon);

		JScrollPane scrollTableFunc = new JScrollPane();
		scrollTableFunc.setBounds(22, 229, 718, 97);
		panelCadFunc.add(scrollTableFunc);

		tableFunc = new JTable();

		atualizarTabela();

		tableFunc.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {

				// Metodo Click Tabela
				clickTabela();
			}
		});
		scrollTableFunc.setViewportView(tableFunc);

		btnCadastrarFunc = new JButton("Cadastrar");
		btnCadastrarFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Chamando o metodo Cadastrar
				try {
					if (acaoFunc.cadastrar(novoObjeto()) == true) {
						// Limpar Campos
						limparCampos();

					}
					// Mensagem de erro
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Erro ao gerar novo objeto. Verifique os campos e tente novamente.\nErro: "
									+ e.getMessage(),
							"Alerta do Sistema", 0);
				}

			}
		});
		btnCadastrarFunc.setBounds(336, 185, 107, 23);
		panelCadFunc.add(btnCadastrarFunc);

		btnAlterarFunc = new JButton("Alterar");
		btnAlterarFunc.setEnabled(false);
		btnAlterarFunc.setBounds(453, 185, 89, 23);
		panelCadFunc.add(btnAlterarFunc);

		btnAlterarFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acao do Botao Alterar
				// Chamando metodo Alterar
				if (acaoFunc.alterar(codigoFunc, novoObjeto())) {
					limparCampos();
				}

			}
		});

		btnExcluirFunc = new JButton("Excluir");
		btnExcluirFunc.setEnabled(false);
		btnExcluirFunc.setBounds(552, 185, 89, 23);
		panelCadFunc.add(btnExcluirFunc);

		btnExcluirFunc.addActionListener(new ActionListener() {
			// Acao do btn excluir
			public void actionPerformed(ActionEvent e) {
				// Chamando o metodo excluir
				acaoFunc.excluir(codigoFunc);
				limparCampos();
			}
		});

		btnCancelarFunc = new JButton("Cancelar");
		btnCancelarFunc.setEnabled(false);
		btnCancelarFunc.setBounds(651, 185, 89, 23);
		panelCadFunc.add(btnCancelarFunc);

		btnCancelarFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// acao do botao Cancelar
				limparCampos();
			}
		});

		return panelCadFunc;
	}

	private Funcionario novoObjeto() {
		// New Object
		Funcionario func = new Funcionario();

		// Dados da Pessoa

		func.setNomeP(txtNomeFunc.getText());
		func.setCpfP(txtCpfFunc.getText());
		func.setEnderecoP(txtEndFunc.getText());
		func.setTelefoneP(Integer.parseInt(txtTelFunc.getText()));
		func.setDtCadP(formatarData.format(dataNow));

		// Dados de Funcionario
		func.setCodigoFunc(cbbFuncaoFunc.getSelectedIndex());
		func.setSalarioFunc(Double.parseDouble(txtSalarioFunc.getText()));
		func.setSenhaFunc(new String(txtSenhaFunc.getPassword()));

		return func;
	}

	private void limparCampos() {

		// Metodo para limpar Campos Funcionario

		// Limpando os campos
		txtNomeFunc.setText("");
		txtCpfFunc.setText("");
		txtEndFunc.setText("");
		txtSalarioFunc.setText("");
		txtSenhaFunc.setText("");
		txtTelFunc.setText("");
		cbbFuncaoFunc.setSelectedIndex(-1);

		// Atualizar a Tabela
		atualizarTabela();

		// Focus
		txtNomeFunc.requestFocus();

		// Botoes
		btnAlterarFunc.setEnabled(false);
		btnExcluirFunc.setEnabled(false);
		btnCancelarFunc.setEnabled(false);
		btnCadastrarFunc.setEnabled(true);
	}

	private void atualizarTabela() {
		// Metodo Atualizar Tabela

		tableFunc.setModel(acaoFunc.selecionar());
	}

	private void clickTabela() {
		// Metodo para o click da tabela

		// Codigo
		codigoFunc = tableFunc.getSelectedRow();

		// Populando Campos
		txtNomeFunc.setText(tableFunc.getValueAt(codigoFunc, 0).toString().toString());
		txtCpfFunc.setText(tableFunc.getValueAt(codigoFunc, 1).toString().toString());
		txtSalarioFunc.setText(tableFunc.getValueAt(codigoFunc, 4).toString().toString());

		// Direto do Banco
		txtSenhaFunc.setText(dados.vetorFuncionario.get(codigoFunc).getSenhaFunc());
		txtEndFunc.setText(dados.vetorFuncionario.get(codigoFunc).getEnderecoP());
		txtTelFunc.setText(String.valueOf(dados.vetorFuncionario.get(codigoFunc).getTelefoneP()));

		// Cbb
		cbbFuncaoFunc.setSelectedIndex(Integer.parseInt(tableFunc.getValueAt(codigoFunc, 3).toString()));

		// Focus
		txtNomeFunc.requestFocus();

		// Botoes Enabled
		btnAlterarFunc.setEnabled(true);
		btnExcluirFunc.setEnabled(true);
		btnCancelarFunc.setEnabled(true);
		btnCadastrarFunc.setEnabled(false);

	}

}
