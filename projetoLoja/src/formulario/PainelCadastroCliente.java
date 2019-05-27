package formulario;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import acao.AcaoCliente;
import beans.Cliente;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PainelCadastroCliente extends JPanel {

	// Construtor
	public PainelCadastroCliente() {
		painelCadCli();
	}

	private JTextField txtNomeCli;
	private JTextField txtEndCli;
	private JTextField txtTelCli;
	private JTextField txtCpfCli;
	private JTable tableCadFunc;

	// Componentes do Painel
	private JCheckBox cckCoopCli;

	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnCancelar;
	private JButton btnCadastrar;

	// Variaveis necessarias
	private static int codigoCli;

	// Classes de Data
	private Date dataNow = new Date();
	DateFormat formatarData = DateFormat.getDateInstance();

	// Instanciando a classe Acao
	AcaoCliente acaoCli = new AcaoCliente();

	protected JPanel painelCadCli() {
		setLayout(null);

		JPanel panelCadCli = new JPanel();
		panelCadCli.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCadCli.setBounds(10, 112, 764, 337);
		add(panelCadCli);
		panelCadCli.setLayout(null);

		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		lblCadastroDeClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCadastroDeClientes.setBounds(321, 11, 140, 14);
		panelCadCli.add(lblCadastroDeClientes);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 47, 48, 14);
		panelCadCli.add(lblNome);

		JLabel txt = new JLabel("Endere\u00E7o:");
		txt.setBounds(10, 72, 77, 14);
		panelCadCli.add(txt);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 103, 58, 14);
		panelCadCli.add(lblTelefone);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(39, 128, 48, 14);
		panelCadCli.add(lblCpf);

		cckCoopCli = new JCheckBox("Cooperado");
		cckCoopCli.setBounds(78, 149, 97, 23);
		panelCadCli.add(cckCoopCli);

		txtNomeCli = new JTextField();
		txtNomeCli.setBounds(78, 44, 96, 20);
		panelCadCli.add(txtNomeCli);
		txtNomeCli.setColumns(10);

		txtEndCli = new JTextField();
		txtEndCli.setColumns(10);
		txtEndCli.setBounds(78, 72, 96, 20);
		panelCadCli.add(txtEndCli);

		txtTelCli = new JTextField();
		txtTelCli.setColumns(10);
		txtTelCli.setBounds(78, 97, 96, 20);
		panelCadCli.add(txtTelCli);

		txtCpfCli = new JTextField();
		txtCpfCli.setColumns(10);
		txtCpfCli.setBounds(78, 125, 96, 20);
		panelCadCli.add(txtCpfCli);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 179, 734, 53);
		panelCadCli.add(separator);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Chamando o Metodo Cadastrar CLiente
				if (acaoCli.cadastrar(novoObjeto()) == true) {
					// Limpando Campos
					limparCampos();
				}

			}
		});
		btnCadastrar.setBounds(610, 56, 105, 23);
		panelCadCli.add(btnCadastrar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(610, 121, 105, 23);
		panelCadCli.add(btnExcluir);

		// Acao do Botao Excluir
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Chamando o metodo Excluir
				if (acaoCli.excluir(codigoCli) == true) {
					limparCampos();
				}
			}
		});

		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(610, 87, 105, 23);
		panelCadCli.add(btnAlterar);

		// Acao do Botao Alterar
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Chamando o metodo alterar
				if (acaoCli.alterar(codigoCli, novoObjeto()) == true) {
					limparCampos();
				}

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 194, 719, 132);
		panelCadCli.add(scrollPane);

		tableCadFunc = new JTable();
		tableCadFunc.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {

				// Metodo ClicarTablea
				clickTabela();
			}
		});
		scrollPane.setViewportView(tableCadFunc);
		
		//Popular table
		tableCadFunc.setModel(acaoCli.selecionar());

		JPanel panel = new JPanel();
		panel.setBounds(279, 36, 182, 115);
		panelCadCli.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon("C:/Users/i3i/Desktop/workspace/projetoLoja/img/CadCli.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 182, 115);
		panel.add(lblNewLabel);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(610, 149, 105, 23);
		panelCadCli.add(btnCancelar);

		// Acao do Botao Cancelar

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acao do Botao Cancelar

				// Chamando metodo Zerar Painel
				limparCampos();
			}
		});

		return panelCadCli;

	}

	private Cliente novoObjeto() {
		// Metodo NovoObjeto

		// Instanciando
		Cliente cliente = new Cliente();
		cliente.setNomeP(txtNomeCli.getText());
		cliente.setEnderecoP(txtEndCli.getText());
		cliente.setCpfP(txtCpfCli.getText());
		cliente.setDtCadP(formatarData.format(dataNow));
		cliente.setTelefoneP(Integer.parseInt(txtTelCli.getText()));
		cliente.setCooperado(cckCoopCli.isSelected() ? true : false);

		return cliente;
	}

	private void limparCampos() {
		// Limpar Campos

		txtNomeCli.setText("");
		txtCpfCli.setText("");
		txtEndCli.setText("");
		txtTelCli.setText("");
		cckCoopCli.setSelected(false);

		// Att Tabela
		tableCadFunc.setModel(acaoCli.selecionar());

		// Limpando selecao da Tabela
		tableCadFunc.clearSelection();

		// Focus
		txtNomeCli.requestFocus();

		// Botoes
		painelNormal();
	}

	private void clickTabela() {
		// Metodo para ClickTabela

		// Codigo
		codigoCli = tableCadFunc.getSelectedRow();

		// Add nos EDTS
		txtNomeCli.setText(tableCadFunc.getValueAt(codigoCli, 0).toString());
		txtEndCli.setText(tableCadFunc.getValueAt(codigoCli, 1).toString());
		txtTelCli.setText(tableCadFunc.getValueAt(codigoCli, 2).toString());
		txtCpfCli.setText(tableCadFunc.getValueAt(codigoCli, 3).toString());
		cckCoopCli.setSelected(tableCadFunc.getValueAt(codigoCli, 5).toString().equals("Sim") ? true : false);

		// Focus
		txtNomeCli.requestFocus();

		// Habilitando botoes
		btnAlterar.setEnabled(true);
		btnExcluir.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnCadastrar.setEnabled(false);
	}

	private void painelNormal() {
		// Metodo para deixar a tela como nova

		// Zerando os botoes
		btnExcluir.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnCadastrar.setEnabled(true);
		btnAlterar.setEnabled(false);

	}
}
