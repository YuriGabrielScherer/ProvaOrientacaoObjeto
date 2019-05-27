package formulario;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import acao.AcaoCompra;
import acao.AcaoProdutos;
import beans.Carrinho;
import beans.TipoProdutos;
import dados.Dados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelPesquisaProduto extends JPanel {
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtProd;

	// Construtor

	public PainelPesquisaProduto() {
		painelPesquisaProduto();
	}

	// Componentes do Painel
	private JPanel PProduto;
	private JPanel PTipo;
	private JRadioButton rbNome;
	private JRadioButton rbTipo;

	private JButton btnAdicionar;
	private JButton btnMensagem;

	private JComboBox<TipoProdutos> cbbTipo;

	// Data e Hora

	// Instancias
	Dados dados = new Dados();
	AcaoProdutos acaoProdutos = new AcaoProdutos();
	AcaoCompra acaoCompra = new AcaoCompra();

	// Variaveis
	private static String nomeProduto;
	private static int qntProduto;

	private static int linha;
	private JLabel lblCarrinho;

	protected JPanel painelPesquisaProduto() {

		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 115, 764, 337);

		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("PESQUISAR PRODUTOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(290, 11, 192, 14);
		panel.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 146, 744, 180);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(acaoProdutos.selecionar());
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			// Click na Table
			public void mouseReleased(MouseEvent e) {
				// Mtd Click tabela
				clickTabela();

			}
		});

		rbTipo = new JRadioButton("Tipo de Produto");
		buttonGroup.add(rbTipo);
		rbTipo.setBounds(21, 34, 133, 23);
		panel.add(rbTipo);

		rbTipo.addMouseListener(new MouseAdapter() {
			// Acao do Click no
			public void mouseReleased(MouseEvent e) {
				// Verificacao
				if (rbTipo.isSelected() == true) {
					PTipo.setVisible(true);
					PProduto.setVisible(false);
				}
			}
		});

		PTipo = new JPanel();
		PTipo.setBounds(10, 64, 360, 43);
		panel.add(PTipo);
		PTipo.setLayout(null);
		PTipo.setVisible(false);

		JLabel lblNewLabel_1 = new JLabel("Selecione o tipo de produto:");
		lblNewLabel_1.setBounds(0, 15, 160, 14);
		PTipo.add(lblNewLabel_1);

		cbbTipo = new JComboBox<TipoProdutos>();
		cbbTipo.setBounds(170, 11, 182, 22);
		PTipo.add(cbbTipo);

		// Populando ComboBox
		cbbTipo.setModel(acaoProdutos.dadosTipoProdutos());

		JButton btnCadastrar = new JButton("Pesquisar");
		btnCadastrar.setBounds(44, 108, 133, 27);
		panel.add(btnCadastrar);

		btnCadastrar.addActionListener(new ActionListener() {
			// Acao do Botao Pesquisar
			public void actionPerformed(ActionEvent e) {
				realizarPesquisa();
			}
		});

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setEnabled(false);
		btnAdicionar.setBounds(606, 59, 128, 23);
		panel.add(btnAdicionar);

		btnAdicionar.addActionListener(new ActionListener() {
			// mtd do botao adicionar
			public void actionPerformed(ActionEvent e) {
				// mtd adicionar no carrinho
				adicionarCarrinho();
				JOptionPane.showMessageDialog(null,
						"Adicionado ao carrinho com sucesso! Vá a página de Compras para finalizar a compra!",
						"Alerta do Sistema", 1);

			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(203, 108, 128, 27);
		panel.add(btnLimpar);

		btnMensagem = new JButton("Ver Carrinho");
		btnMensagem.setEnabled(false);
		btnMensagem.setBounds(606, 93, 128, 23);
		panel.add(btnMensagem);

		lblCarrinho = new JLabel("Carrinho");
		lblCarrinho.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarrinho.setBounds(606, 23, 128, 25);
		panel.add(lblCarrinho);

		rbNome = new JRadioButton("Nome");
		rbNome.setBounds(154, 34, 113, 23);
		panel.add(rbNome);
		buttonGroup.add(rbNome);
		rbNome.setSelected(true);

		PProduto = new JPanel();
		PProduto.setBounds(10, 69, 360, 38);
		panel.add(PProduto);
		PProduto.setLayout(null);

		JLabel lblDigiteOProduto = new JLabel("Digite o produto:");
		lblDigiteOProduto.setHorizontalAlignment(SwingConstants.LEFT);
		lblDigiteOProduto.setBounds(0, 14, 101, 14);
		PProduto.add(lblDigiteOProduto);

		txtProd = new JTextField();
		txtProd.setBounds(100, 11, 231, 20);
		PProduto.add(txtProd);
		txtProd.setColumns(10);

		rbNome.addMouseListener(new MouseAdapter() {
			// Acao do Click do rbNome
			public void mouseReleased(MouseEvent e) {
				if (rbNome.isSelected() == true) {
					PTipo.setVisible(false);
					PProduto.setVisible(true);
				} else {
					PProduto.setVisible(false);
					PTipo.setVisible(true);
				}
			}
		});

		btnMensagem.addActionListener(new ActionListener() {
			// Acao do botao Finalizar
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Para finalizar a compra, vá para a tela Compra!",
						"Alerta do Sistema", 1);
			}
		});

		btnLimpar.addActionListener(new ActionListener() {
			// Acao do Botao Limpar
			public void actionPerformed(ActionEvent e) {
				// Mtd LimparCampos
				limparCampos();
			}
		});

		return panel;
	}

	private void realizarPesquisa() {
		// Metodo para realizar a pesquisa

		// Verificando qual tipo de pesquisa será
		if (rbNome.isSelected() == true) {
			if (txtProd.getText().equals("")) {
				// Atualizar a tabela
				table.setModel(acaoProdutos.selecionar());
			} else {

				// Realizar uma pesquisa no banco com base nisso
				String produto = txtProd.getText();
				String desc = txtProd.getText();
				table.setModel(acaoProdutos.selecionarFiltro(produto, desc));

				// Limpando campo de pesquisa
				txtProd.setText("");
			}

		} else { // Verificacao por tipo
			table.setModel(acaoProdutos.selecionarTipo(cbbTipo.getSelectedIndex()));

			// Limpando Selecao
			cbbTipo.setSelectedIndex(0);
		}
	}

	private void clickTabela() {
		// Metodo para o click na tabela

		linha = table.getSelectedRow();

		// Atribuindo o nome do Produto
		nomeProduto = (String) table.getValueAt(linha, 0);

		// Deixando o botao ok
		btnAdicionar.setEnabled(true);
		btnMensagem.setEnabled(true);

	}

	private void limparCampos() {
		// Metodo limpar campos

		// Att a tabela
		table.setModel(acaoProdutos.selecionar());

		// Retirando o selecionar da tabela
		table.clearSelection();

		// Limpando o Txt
		txtProd.setText("");
		cbbTipo.setSelectedIndex(0);

	}

	private void adicionarCarrinho() {
		// Mtd adicionar Carrinho

		// Perguntando a quantidade
		qntProduto = Integer.parseInt(
				JOptionPane.showInputDialog(null, "Digite a quantidade do produto escolhido.", "Alerta do Sistema", 3));

		// Verificacao de Quantidade
		if (acaoCompra.verificarQuantidade(nomeProduto, qntProduto) == false) {
			JOptionPane.showMessageDialog(null, "Favor verifique a quantidade disponível e tente novamente.",
					"Alerda do Sistema", 0);
		} else {
			// Jogando os dados para dentro do Carrinho
			acaoCompra.adicionarCarrinho(novoObjetoCarrinho());

			// Tentando mudar a Label
			PainelCompra pCompra = new PainelCompra();
			pCompra.lbTotal.setText("TESTE");

			// Habilitando botao
			btnMensagem.setEnabled(true);

			// limpando selecao
			limparCampos();

		}

	}

	private Carrinho novoObjetoCarrinho() {
		// Mtd novo Carrinho

		// Instanciando
		Carrinho carrinho = new Carrinho();
		carrinho.setNomeProduto(nomeProduto);
		carrinho.setQnt(qntProduto);
		carrinho.setValor(Double.parseDouble(table.getValueAt(linha, 4).toString()));

		// Retornando
		return carrinho;

	}

}
