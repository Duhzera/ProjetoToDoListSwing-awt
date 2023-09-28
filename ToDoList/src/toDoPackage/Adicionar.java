package toDoPackage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adicionar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JTextField txtTarefa;
	Main m1 = new Main();
	public JLabel lbTitle = new JLabel("Descreva sua tarefa de forma abreviada");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Main mainInstance = new Main(); // Crie uma instância de Main
	        Adicionar dialog = new Adicionar(mainInstance); // Passe a instância de Main para o construtor de Adicionar
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Adicionar(Main main) {
		this.m1= main;
		setBounds(100, 100, 450, 198);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtTarefa = new JTextField();
		txtTarefa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTarefa.setBounds(10, 53, 419, 41);
		contentPanel.add(txtTarefa);
		txtTarefa.setColumns(10);
		{
			
			lbTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitle.setBounds(37, 12, 338, 30);
			contentPanel.add(lbTitle);
			
			JButton btnAdicionar = new JButton("Adicionar");
			btnAdicionar.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        String texto = txtTarefa.getText();
			        if (m1.tarefa(texto)) {
			            lbTitle.setText("Adicionado com Sucesso!");
			            txtTarefa.setText("");
			        } else {
			            lbTitle.setText("Não foi adicionado!");
			            txtTarefa.setText("");
			        }
			    }
			});
			
			btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAdicionar.setBounds(102, 105, 95, 43);
			contentPanel.add(btnAdicionar);
			btnAdicionar.setActionCommand("OK");
			getRootPane().setDefaultButton(btnAdicionar);
		}
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setActionCommand("OK");
		btnCancelar.setBounds(230, 105, 95, 43);
		contentPanel.add(btnCancelar);
		
		
	}
}
