package formulario;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import acao.AcaoCliente;
import acao.AcaoCompra;
import acao.AcaoProdutos;
import dados.Dados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PainelCompra extends JPanel {
	protected JTable table;

	// Construtor
	public PainelCompra() {
		painelPrincipal();
	}

	// Componentes do Painel
	private JComboBox<String> cbbCliente;
	private JComboBox<String> cbbPgto;
	protected JLabel lbTotal;
	private JLabel lbProd;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JSpinner txtQuantidade;
	protected JLabel lbUsuario;

	// Instanciar
	AcaoCompra acaoCompra = new AcaoCompra();
	AcaoCliente acaoCliente = new AcaoCliente();
	Dados dados = new Dados();

	// Variaveis
	private static int codCarrinho;

	// Metodo para retornar o Painel
	protected JPanel painelPrincipal() {

		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 119, 764, 337);

		add(panel);
		panel.setLayout(null);

		JLabel R = new JLabel("Realizar Compra");
		R.setFont(new Font("Tahoma", Font.BOLD, 13));
		R.setBounds(298, 11, 120, 14);
		panel.add(R);

		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(27, 42, 71, 14);
		panel.add(lblNewLabel);

		lbUsuario = new JLabel("New label");
		lbUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbUsuario.setBounds(108, 42, 94, 14);
		panel.add(lbUsuario);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setBounds(27, 67, 71, 14);
		panel.add(lblCliente);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(298, 36, 170, 110);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lbIcone = new JLabel(new ImageIcon("C:/Users/i3i/Desktop/workspace/projetoLoja/img/Compra.png"));
		lbIcone.setBounds(0, 0, 170, 110);
		panel_1.add(lbIcone);

		JLabel lblValorTotal = new JLabel("Valor total:");
		lblValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorTotal.setBounds(10, 92, 88, 14);
		panel.add(lblValorTotal);

		lbTotal = new JLabel("New label");
		lbTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbTotal.setBounds(108, 92, 94, 14);
		panel.add(lbTotal);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Pergunta se Deseja mesmo finalizar
				if (JOptionPane.showConfirmDialog(null, "Deseja finalizar o pedido?", "Alerta do Sistema", 0, 3) == 0) {
					finalizaCompra();
				}

			}
		});
		btnFinalizar.setBounds(27, 146, 89, 23);
		panel.add(btnFinalizar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(126, 146, 89, 23);
		panel.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			// Acao do Botao Cancelar
			public void actionPerformed(ActionEvent e) {

				// pergunta
				if (JOptionPane.showConfirmDialog(null, "Deseja mesmo limpar o carrinho e cancelar a compra?",
						"Alerta do Sistema", 0, 3) == 0) {
					limparCarrinho();
					limparCampos();
				}
			}
		});

		JLabel lblFormaPagamento = new JLabel("Pagamento:");
		lblFormaPagamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormaPagamento.setBounds(0, 121, 98, 14);
		panel.add(lblFormaPagamento);

		cbbPgto = new JComboBox<String>();
		cbbPgto.setModel(new DefaultComboBoxModel(new String[] { "Dinheiro", "Cr\u00E9dito", "D\u00E9bito" }));
		cbbPgto.setSelectedIndex(0);
		cbbPgto.setBounds(108, 117, 141, 22);
		panel.add(cbbPgto);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 180, 744, 2);
		panel.add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 193, 692, 133);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			// Click na tabela
			public void mouseReleased(MouseEvent e) {

				clickTabela();
			}
		});

		// Populando tabela
		table.setModel(acaoCompra.selecionarCarrinho());

		cbbCliente = new JComboBox<String>();
		cbbCliente.setBounds(108, 67, 152, 22);
		panel.add(cbbCliente);

		// Populanndo
		cbbCliente.setModel(acaoCliente.selecionarCombo());

		JLabel lblNewLabel_2 = new JLabel("Itens do Carrinho");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(567, 42, 152, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Produto: ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(501, 67, 66, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Quantidade:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(488, 92, 79, 14);
		panel.add(lblNewLabel_4);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(501, 133, 89, 23);
		panel.add(btnAlterar);

		btnAlterar.addActionListener(new ActionListener() {
			// Acao do Botao alterar
			public void actionPerformed(ActionEvent e) {
				// Mtd Alterar
				acaoCompra.alterarQuantidade(codCarrinho, Integer.parseInt(txtQuantidade.getValue().toString()));

				// Att Tabela
				atualizarTabela();

				// LimparCampos
				limparCampos();
			}
		});

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(600, 133, 89, 23);
		panel.add(btnExcluir);

		btnExcluir.addActionListener(new ActionListener() {
			// Acao Excluir
			public void actionPerformed(ActionEvent e) {
				// Excluindo
				acaoCompra.excluirItemCarrinho(codCarrinho);
				// Att Tabela
				atualizarTabela();

			}
		});

		lbProd = new JLabel("");
		lbProd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbProd.setBounds(577, 67, 142, 14);
		panel.add(lbProd);

		JLabel lblNewLabel_1 = new JLabel("Icone");
		lblNewLabel_1.setBounds(308, 36, 170, 110);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		txtQuantidade = new JSpinner();
		txtQuantidade.setEnabled(false);
		txtQuantidade.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		txtQuantidade.setBounds(587, 89, 64, 20);
		panel.add(txtQuantidade);

		return panel;

	}

	private void limparCarrinho() {
		// Mtd para limpar o carrinho

		acaoCompra.limparCarrinho();
	}

	private void atualizarTabela() {
		// Mtd Atualizar tabela

		table.setModel(acaoCompra.selecionarCarrinho());
	}

	private void limparCampos() {

		// Mtd para Limpar os campos
		cbbCliente.setSelectedIndex(-1);
		txtQuantidade.setEnabled(false);
		lbProd.setText("");

		// Atualizar table
		atualizarTabela();

		// Limpando Total
		atualizarLabel();
	}

	private void reduzirQuantidade() {
		// Mtd para reduzir a quantidade do estoque

		// Percorrendo o vetor Carrinho
		for (int i = 0; i < (dados.vetorCarrinho.size()); i++) {
			acaoCompra.reduzirEstoque(dados.vetorCarrinho.get(i).getNomeProduto(), dados.vetorCarrinho.get(i).getQnt());
		}

	}

	private void finalizaCompra() {
		// Mtd Finalizar compra

		// temporaria
		boolean ver = false;

		// Verificando tipo de PGTO
		if (cbbPgto.getSelectedIndex() == 0) {
			ver = false;
			while (ver == false) {
				double dinheiro = Double.parseDouble(
						JOptionPane.showInputDialog(null, "Digite o valor pago pelo cliente", "Alerta do Sistema", 3));

				// Montante ok
				if (dinheiro < Double.parseDouble(lbTotal.getText())) {
					ver = false;
					JOptionPane.showMessageDialog(null, "Digite um valor mínimo para o pagamento", "Alerta do Sistema",
							0);
				} else {
					ver = true;
				}
			}
		} else { // Se for no cartao
			JOptionPane.showMessageDialog(null, "Insira o cartão na leitora", "Alerta do Sistema", 1);
		}

		// Metodo para Reduzir a Quantidade
		reduzirQuantidade();

		// Limpando o Carrinho
		acaoCompra.limparCarrinho();

		// Limpando Campos e o JPanel
		limparCampos();
		atualizarTabela();
		// Mensagem Final para o Usuario
		JOptionPane.showMessageDialog(null, "Obrigado por realizar uma compra conosco!", "Alerta do Sistema", 1);

	}

	private void clickTabela() {
		// Mtd Para Click Tabela

		// Codigo
		codCarrinho = table.getSelectedRow();

		// Populando
		lbProd.setText(table.getValueAt(codCarrinho, 0).toString());
		txtQuantidade.setValue(table.getValueAt(codCarrinho, 2));

		// Habilitando botoes
		btnAlterar.setEnabled(true);
		btnExcluir.setEnabled(true);
		txtQuantidade.setEnabled(true);

	}

	protected void atualizarLabel() {
		// Mtd para atualizar label de PrecoTotal

		if (dados.vetorCarrinho.isEmpty()) {
			lbTotal.setText("TOTAL");
		} else {
			lbTotal.setText(String.valueOf(acaoCompra.calcularTotal()));
		}

	}
}
