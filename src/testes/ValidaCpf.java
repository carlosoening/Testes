package testes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ValidaCpf {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblValidador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValidaCpf window = new ValidaCpf();
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
	public ValidaCpf() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 444, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btn = new JButton("Verificar");
		btn.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa p = new Pessoa();
				if (p.validaCpf(textField.getText())) {
					lblValidador.setText("Válido!");
					lblValidador.setForeground(new Color(30,205,30));
					panel.add(lblValidador);
					lblValidador.setVisible(true);
					frame.repaint();
				} else {
					lblValidador.setText("Inválido!");
					lblValidador.setForeground(new Color(255,0,0));
					panel.add(lblValidador);
					frame.repaint();
				}
			}
		});
		btn.setBounds(150, 173, 119, 50);
		panel.add(btn);
		
		textField = new JTextField();
		textField.setBounds(128, 102, 217, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Digite o CPF:");
		lblNewLabel.setBounds(51, 105, 70, 14);
		panel.add(lblNewLabel);
		
		lblValidador = new JLabel("");
		lblValidador.setHorizontalAlignment(SwingConstants.CENTER);
		lblValidador.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblValidador.setBounds(150, 43, 119, 14);
		panel.add(lblValidador);
	}
}
