package br.edu.ifpe.paulista.sample.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;

import br.edu.ifpe.paulista.model.User;
import br.edu.ifpe.paulista.sample.business.BusinessException;
import br.edu.ifpe.paulista.sample.business.UserController;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField loginTextField;
	private JPasswordField passwordTextField;
	private JPasswordField confirmPasswordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 886, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("CREATE USER");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(50, 0, 50, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 10, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		loginTextField = new JTextField();
		loginTextField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_loginTextField = new GridBagConstraints();
		gbc_loginTextField.insets = new Insets(0, 0, 10, 50);
		gbc_loginTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_loginTextField.gridx = 1;
		gbc_loginTextField.gridy = 1;
		frame.getContentPane().add(loginTextField, gbc_loginTextField);
		loginTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 50, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_passwordTextField = new GridBagConstraints();
		gbc_passwordTextField.insets = new Insets(0, 0, 10, 50);
		gbc_passwordTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordTextField.gridx = 1;
		gbc_passwordTextField.gridy = 2;
		frame.getContentPane().add(passwordTextField, gbc_passwordTextField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Confirm Password:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.insets = new Insets(0, 50, 30, 5);
		gbc_lblNewLabel_2_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1.gridx = 0;
		gbc_lblNewLabel_2_1.gridy = 3;
		frame.getContentPane().add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
		
		confirmPasswordTextField = new JPasswordField();
		confirmPasswordTextField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_confirmPasswordTextField = new GridBagConstraints();
		gbc_confirmPasswordTextField.insets = new Insets(0, 0, 30, 50);
		gbc_confirmPasswordTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_confirmPasswordTextField.gridx = 1;
		gbc_confirmPasswordTextField.gridy = 3;
		frame.getContentPane().add(confirmPasswordTextField, gbc_confirmPasswordTextField);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String login = loginTextField.getText();
				String password = new String(passwordTextField.getPassword());
				String confirmPassword = new String(confirmPasswordTextField.getPassword());
				
				UserController controller = new UserController();
				try {
					controller.createUser(login, password, confirmPassword);
					JOptionPane.showMessageDialog(null, "The user was successfully created.", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch (BusinessException be) {
					JOptionPane.showMessageDialog(null, be.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "An error occurred, the user was not created.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 4;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
	}

}
