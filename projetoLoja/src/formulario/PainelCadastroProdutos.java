package formulario;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import acao.AcaoProdutos;
import beans.Produto;
import beans.TipoProdutos;
import dados.Dados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PainelCadastroProdutos extends JPanel {
	private JTable tableProd;
	private JTextField txtProd;
	private JTextField txtImagem;

	// Construtor
	public PainelCadastroProdutos() {
		painelCadProdutos();
	}

	// Componentes
	private JComboBox<TipoProdutos> cbbTipo;
	private JTextPane txtDesc;
	private JSpinner spQnt;
	private JButton btnCadastrar;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnCancelar;
	private JTextField txtValor;

	// Instanciando Classes
	AcaoProdutos acaoProd = new AcaoProdutos();
	Dados dados = new Dados();

	// Classes de Data
	private Date dataNow = new Date();
	DateFormat formatarData = DateFormat.getDateInstance();

	// Variaveis
	private static int codigoProduto;

	// Retornar o Painel
	protected JPanel painelCadProdutos() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 113, 764, 337);

		add(panel);
		panel.setLayout(null);

		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeProdutos.setBounds(302, 11, 165, 14);
		panel.add(lblCadastroDeProdutos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 180, 695, 146);
		panel.add(scrollPane);

		tableProd = new JTable();
		tableProd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				// Mtd ClickTabela
				clickTabela();
			}
		});
		scrollPane.setViewportView(tableProd);

		// Table Produto
		tableProd.setModel(acaoProd.selecionar());

		JSeparator separator = new JSeparator();
		separator.setBounds(34, 168, 695, 44);
		panel.add(separator);

		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(0, 41, 71, 14);
		panel.add(lblProduto);

		JLabel lblDescProd = new JLabel("Desc. Prod:");
		lblDescProd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescProd.setBounds(0, 69, 71, 14);
		panel.add(lblDescProd);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(81, 69, 165, 87);
		panel.add(scrollPane_1);

		txtDesc = new JTextPane();
		scrollPane_1.setViewportView(txtDesc);

		txtProd = new JTextField();
		txtProd.setBounds(81, 38, 165, 20);
		panel.add(txtProd);
		txtProd.setColumns(10);

		JLabel lblImagem = new JLabel("Imagem:");
		lblImagem.setBounds(302, 38, 58, 14);
		panel.add(lblImagem);

		txtImagem = new JTextField();
		txtImagem.setColumns(10);
		txtImagem.setBounds(370, 35, 165, 20);
		panel.add(txtImagem);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(288, 66, 72, 14);
		panel.add(lblQuantidade);

		spQnt = new JSpinner();
		spQnt.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spQnt.setBounds(370, 63, 48, 20);
		panel.add(spQnt);

		JLabel tpProduto = new JLabel("Tipo Produto:");
		tpProduto.setBounds(276, 98, 84, 14);
		panel.add(tpProduto);

		cbbTipo = new JComboBox<TipoProdutos>();
		cbbTipo.setBounds(370, 94, 165, 22);
		panel.add(cbbTipo);

		// Populando o ComboBox
		cbbTipo.setModel(acaoProd.dadosTipoProdutos());

		// Set Index
		cbbTipo.setSelectedIndex(-1);

		JLabel lblValorProduto = new JLabel("Valor Produto:");
		lblValorProduto.setBounds(276, 130, 84, 14);
		panel.add(lblValorProduto);

		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(370, 127, 165, 20);
		panel.add(txtValor);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(610, 37, 106, 23);
		panel.add(btnCadastrar);

		btnCadastrar.addActionListener(new ActionListener() {
			// Acao do Botao Cadastrar
			public void actionPerformed(ActionEvent e) {

				// Chamando o metodo Cadastrar
				if (acaoProd.cadastrarProd(novoObjeto()) == true) {

					limparCampos();
				}
			}
		});

		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(610, 69, 106, 23);
		panel.add(btnAlterar);

		btnAlterar.addActionListener(new ActionListener() {
			// Acao do Botao Alterar
			public void actionPerformed(ActionEvent e) {

				// Tentando alterar
				try {
					if (acaoProd.alterarProduto(codigoProduto, novoObjeto())) {
						limparCampos();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,
							"Erro ao alterar produto. Verifique os campos e tente novamente.nErro: " + e2.getMessage(),
							"Alerta do Sistema", 0);
				}
			}
		});

		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(610, 100, 106, 23);
		panel.add(btnExcluir);

		btnExcluir.addActionListener(new ActionListener() {
			// Acao do Botao excluir
			public void actionPerformed(ActionEvent e) {

				// Chamando metodo
				acaoProd.excluirProduto(codigoProduto);
				limparCampos();

			}
		});
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(610, 130, 106, 23);
		panel.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			// Acao do Botao Cancelar
			public void actionPerformed(ActionEvent arg0) {
				// Mtd LimparCampos
				limparCampos();

			}
		});

		return panel;

	}

	private Produto novoObjeto() {
		// Metodo novo Objeto

		// Instanciando
		Produto prod = new Produto();
		prod.setNomeProd(txtProd.getText());
		prod.setDescProd(txtDesc.getText());
		prod.setImgProd(txtImagem.getText());
		prod.setVlProd(Double.parseDouble(txtValor.getText()));
		prod.setDtCadProd(formatarData.format(dataNow));
		prod.setQntProd(Integer.parseInt(spQnt.getValue().toString()));
		prod.setTpProd(cbbTipo.getSelectedIndex());

		return prod;

	}

	private void limparCampos() {
		// Metodo Limpar Campos

		// Limpando
		txtProd.setText("");
		txtDesc.setText("");
		txtImagem.setText("");
		txtValor.setText("");

		cbbTipo.setSelectedIndex(-1);
		spQnt.setValue(0);

		// Att Table
		atualizarTabela();

		// Focus
		txtProd.requestFocus();

		// Painel
		painelNormal();
	}

	private void atualizarTabela() {
		// Table Produto
		tableProd.setModel(acaoProd.selecionar());
	}

	private void painelNormal() {
		// Metodo para deixar a tela como nova

		// Zerando os botoes
		btnExcluir.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnCadastrar.setEnabled(true);
		btnAlterar.setEnabled(false);

	}

	private void clickTabela() {
		// Metodo do Click da Tabela

		codigoProduto = tableProd.getSelectedRow();

		// Populando Campos
		txtProd.setText(tableProd.getValueAt(codigoProduto, 0).toString());
		txtDesc.setText(tableProd.getValueAt(codigoProduto, 1).toString());
		spQnt.setValue(tableProd.getValueAt(codigoProduto, 3));
		txtValor.setText(tableProd.getValueAt(codigoProduto, 4).toString());

		// Banco de Dados
		txtImagem.setText(dados.vetorProduto.get(codigoProduto).getImgProd());
		cbbTipo.setSelectedIndex(dados.vetorProduto.get(codigoProduto).getTpProd());

		// Habilitando botoes
		btnAlterar.setEnabled(true);
		btnCadastrar.setEnabled(false);
		btnCancelar.setEnabled(true);
		btnExcluir.setEnabled(true);

		// Focus
		txtProd.requestFocus();

		// Tirando o foco da Tabela
		tableProd.clearSelection();

	}

}
