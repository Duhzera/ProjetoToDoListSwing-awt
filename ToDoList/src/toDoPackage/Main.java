package toDoPackage;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	
	private JFrame frame;
	DefaultListModel<String> listaModel = new DefaultListModel<>();
	JList list = new JList(listaModel);
	String tarefa;
	
	public  boolean tarefa(String tarefa) {
		this.tarefa = tarefa;
		  if (tarefa != null && !tarefa.isEmpty()) {
			  // Adicione o texto à lista usando o DefaultListModel
              this.listaModel.addElement(this.tarefa);
              return(true);
          }else {
        	  return (false);
          }
    }
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
			    
		
		list.setBounds(10, 72, 364, 515);
		frame.getContentPane().add(list);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adicionar adjanela = new Adicionar(Main.this);
				adjanela.setVisible(true);
			}
		});
		btnAdicionar.setBounds(10, 598, 98, 29);
		frame.getContentPane().add(btnAdicionar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(144, 598, 98, 29);
		frame.getContentPane().add(btnEditar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(276, 598, 98, 29);
		frame.getContentPane().add(btnLimpar);
		
		JLabel lblNewLabel = new JLabel("Gerenciador de atividades");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 364, 50);
		frame.getContentPane().add(lblNewLabel);
	}
}
