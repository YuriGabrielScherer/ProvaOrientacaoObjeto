package formulario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import acao.AcaoCompra;
import acao.AcaoFuncionario;
import acao.AcaoPopularBanco;
import acao.AcaoProdutos;
import acao.AcaoValidaLogin;
import beans.Funcionario;
import beans.TipoProdutos;
import dados.Dados;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class Formulario extends JFrame {

	private JTextField txtLogin;
	private JPasswordField txtSenha;

	// Componentes do Sistema
	private JButton btnCancelar;
	private JButton btnLogin;

	// Paineis de outras Classes
	protected PainelCadastroCliente pCadCli;
	protected PainelCadastroFuncionario pCadFunc;
	protected PainelCadastroProdutos pCadProd;
	protected PainelCompra pCompra;
	protected PainelPesquisaProduto pPesquisa;

	// Paineis Deste Formulario
	private JPanel painelCadCli;
	private JPanel painelCadFunc;
	private JPanel painelSuperior;
	private JPanel painelCadProd;
	private JPanel painelLogin;
	protected JPanel painelCompra;
	private JPanel painelPesquisa;

	// Botoes
	protected JButton btnCompra;

	// Instancias para trabalhar com data
	private Date dataNow = new Date();
	DateFormat formatarData = DateFormat.getDateInstance();

	// Classe Popular
	AcaoPopularBanco popularBanco = new AcaoPopularBanco();
	AcaoCompra acaoCompra = new AcaoCompra();
	AcaoValidaLogin validaLogin = new AcaoValidaLogin();

	// usuario logado
	public static String usuLogado;

	public Formulario() {

		// Add Funcionarios
		popularBanco.popular();

		// PAINEL SUPERIOR
		painelSuperior = new JPanel();
		painelSuperior.setBorder(new LineBorder(new Color(0, 0, 0)));
		painelSuperior.setBounds(10, 11, 764, 97);
		painelSuperior.setVisible(false);
		painelSuperior.setLayout(null);

		JPanel painelIconeSuperior = new JPanel();
		painelIconeSuperior.setBounds(10, 11, 104, 75);
		painelSuperior.add(painelIconeSuperior);
		painelIconeSuperior.setLayout(null);

		// Definindo campos para efetuar o login
		JLabel lblIcone = new JLabel(new ImageIcon("C:/Users/i3i/Desktop/workspace/projetoLoja/img/JavaIcone.png"));

		lblIcone.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcone.setBounds(0, 0, 104, 75);
		painelIconeSuperior.add(lblIcone);

		JLabel lblPainelCabecalho = new JLabel("Loja de Produtos de Tecnologia do Yuri");
		lblPainelCabecalho.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPainelCabecalho.setHorizontalAlignment(SwingConstants.CENTER);
		lblPainelCabecalho.setBounds(144, 11, 421, 17);
		painelSuperior.add(lblPainelCabecalho);

		JButton btnPainelCadastro = new JButton("Cadastro");
		btnPainelCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Metodo Esconder
				esconderPaineis();
				painelCadFunc.setVisible(true);
			}
		});
		btnPainelCadastro.setBounds(124, 70, 89, 23);
		painelSuperior.add(btnPainelCadastro);

		JButton btnPainelCliente = new JButton("Cliente");
		btnPainelCliente.setBounds(223, 70, 89, 23);
		painelSuperior.add(btnPainelCliente);

		btnPainelCliente.addActionListener(new ActionListener() {
			// Acao do Botao Painel Cliente
			public void actionPerformed(ActionEvent e) {
				// Metodo Esconder
				esconderPaineis();
				painelCadCli.setVisible(true);
			}
		});

		JButton btnPainelProduto = new JButton("Produto");
		btnPainelProduto.setBounds(322, 70, 89, 23);
		painelSuperior.add(btnPainelProduto);

		btnPainelProduto.addActionListener(new ActionListener() {
			// Acao do Botao Painel Produto
			public void actionPerformed(ActionEvent e) {
				// Metodo Esconder
				esconderPaineis();
				painelCadProd.setVisible(true);
			}
		});

		// Add no Frame
		getContentPane().add(painelSuperior);

		btnCompra = new JButton("Compra");
		btnCompra.addActionListener(new ActionListener() {
			// ACao do Botao Painel Compra
			public void actionPerformed(ActionEvent arg0) {
				// limpar Tempa
				esconderPaineis();

				// Atualizando a Tabela
				pCompra.table.setModel(acaoCompra.selecionarCarrinho());
				pCompra.atualizarLabel();

				painelCompra.setVisible(true);
				pCompra.lbUsuario.setText(usuLogado);
			}
		});
		btnCompra.setBounds(465, 70, 89, 23);
		painelSuperior.add(btnCompra);

		JButton btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.setBounds(564, 70, 89, 23);
		painelSuperior.add(btnPesquisa);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(438, 39, 2, 54);
		painelSuperior.add(separator_1);

		JLabel lblNewLabel_2 = new JLabel("Cadastro");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(233, 45, 58, 14);
		painelSuperior.add(lblNewLabel_2);

		JLabel lblCompra = new JLabel("Compra");
		lblCompra.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompra.setBounds(527, 39, 58, 14);
		painelSuperior.add(lblCompra);

		btnPesquisa.addActionListener(new ActionListener() {
			// Acao do Botao Pesquisar
			public void actionPerformed(ActionEvent e) {

				// Esconder e exibir
				esconderPaineis();

				// Exibindo
				painelPesquisa.setVisible(true);

			}
		});

		// PAINEL SUPERIOR

		// Resto do Frame

		setTitle("Loja do Yuri");
		setSize(472, 249);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		painelLogin = new JPanel();
		painelLogin.setBounds(10, 11, 457, 208);
		getContentPane().add(painelLogin);
		painelLogin.setLayout(null);

		// creating JButton in the main JPanel (white)
		btnLogin = new JButton("Login");
		btnLogin.setBounds(183, 158, 100, 20);
		painelLogin.add(btnLogin);

		// Acao do Botao Login
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Chamando Metodo de Login
				if (validaLogin.validaLogin(txtLogin.getText(), txtSenha.getText()) == true) {
					// Usuario logado
					usuLogado = txtLogin.getText();

					// Redesenhando tela
					redesenharTela();

					// Click no Botao de Pesquisa
					btnPesquisa.doClick();

				} else {
					JOptionPane.showMessageDialog(null, "Dados de login incorretos. Tente novamente");
				}

			}
		});

		txtLogin = new JTextField();
		txtLogin.setBounds(242, 72, 150, 20);
		painelLogin.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(173, 75, 37, 14);
		painelLogin.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(173, 111, 46, 14);
		painelLogin.add(lblNewLabel_1);

		JPanel panelIconeLogin = new JPanel();
		panelIconeLogin.setBounds(10, 53, 138, 91);
		painelLogin.add(panelIconeLogin);
		panelIconeLogin.setLayout(null);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(242, 108, 150, 20);
		painelLogin.add(txtSenha);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(292, 159, 100, 20);
		painelLogin.add(btnCancelar);

		// Acao do Botao Cancelar
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Sair do Sistema
				System.exit(0);
			}
		});

		JLabel lblIcon = new JLabel(new ImageIcon("C:/Users/i3i/Desktop/workspace/projetoLoja/img/IconeLogin.png"));
		lblIcon.setBounds(0, 0, 140, 100);
		panelIconeLogin.add(lblIcon);
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);

		JSeparator separator = new JSeparator();
		separator.setBounds(158, -11, 2, 208);
		painelLogin.add(separator);
		separator.setOrientation(SwingConstants.VERTICAL);

	}

	private void redesenharTela() {
		// Redesenhar a tela
		setSize(800, 500);
		revalidate();
		repaint();

		// Escondendo o Painel Login
		painelLogin.setVisible(false);
		painelSuperior.setVisible(true);

		// Add Paineis ao Formulario
		pCadCliente();
		pCadFunc();
		pCadProd();
		pCompra();
		pPesquisa();

	}

	// -----------------
	// Metodos de Paineis
	// -----------------

	protected void esconderPaineis() {
		// Mtd Esconder Paineis

		painelCadCli.setVisible(false);
		painelCadFunc.setVisible(false);
		painelCadProd.setVisible(false);
		painelCompra.setVisible(false);
		painelPesquisa.setVisible(false);

	}

	protected void pCadCliente() {
		// Chamando Metodo Para retornar o Painel Cad Cliente

		// Instanciando
		pCadCli = new PainelCadastroCliente();

		// Jogando no Painel
		painelCadCli = pCadCli.painelCadCli();
		painelCadCli.setVisible(false);
		getContentPane().add(painelCadCli);
	}

	protected void pCadFunc() {
		// Chamando Metodo Para retornar o Painel Cad Funcionario

		// Instanciando
		pCadFunc = new PainelCadastroFuncionario();

		// Jogando no Painel
		painelCadFunc = pCadFunc.painelCadFunc();
		painelCadFunc.setVisible(false);
		getContentPane().add(painelCadFunc);
	}

	protected void pCadProd() {
		// Chamando o metodo para retornar o Painel Cad Produto

		// Instanciando
		pCadProd = new PainelCadastroProdutos();

		// Jogando no Painel
		painelCadProd = pCadProd.painelCadProdutos();
		painelCadProd.setVisible(false);
		getContentPane().add(painelCadProd);

	}

	protected void pCompra() {
		// Chamando o metodo para retornar o Painel Compra

		// Instanciando
		pCompra = new PainelCompra();

		// Jogando no Painel
		painelCompra = pCompra.painelPrincipal();
		painelCompra.setVisible(false);
		getContentPane().add(painelCompra);

	}

	protected void pPesquisa() {
		// Chamando o metodo para retornar o Painel

		// Instanciando
		pPesquisa = new PainelPesquisaProduto();

		// Jogando no Painel
		painelPesquisa = pPesquisa.painelPesquisaProduto();
		painelPesquisa.setVisible(false);
		getContentPane().add(painelPesquisa);
	}

}