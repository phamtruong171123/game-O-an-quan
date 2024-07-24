package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Menu extends JFrame implements IFrame, IMenu {
	
	private INewGame newGame;
	private IHelp help;
	private JButton btNewGame,btHelp,btExit;
	
	public Menu() {

		setLayout(new BorderLayout());

        // Load and resize background image
        ImageIcon originalImage = new ImageIcon("menu.png");
        Image scaledImage = originalImage.getImage().getScaledInstance(WIDTHJF, HEIGHTJF, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout());
        setContentPane(backgroundLabel);

        initComps();
        newGame();
        help();

        setSize(WIDTHJF, HEIGHTJF);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Cờ Ô Quan");
	}

	public void initComps() {
		// TODO Auto-generated method stub
		getContentPane().setLayout(new BorderLayout(0, 50));
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblnQuan = new JLabel("\u00D4 \u0102n Quan ");
		lblnQuan.setForeground(Color.RED);
		lblnQuan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 70));
		//panel.add(lblnQuan);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(300, 50));



		JPanel panel_3 = new JPanel(); 
		panel_3.setOpaque(false);
		panel_1.add(panel_3, BorderLayout.SOUTH);

		JLabel lblNewLabel_1 = new JLabel(" Version 1 ");
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_3.add(lblNewLabel_1);

		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_1.add(panel_6, BorderLayout.WEST);
		panel_6.setLayout(new GridLayout(5, 1, 10, 10));

		JLabel non=new JLabel("");
		panel_6.add(non);
		JLabel non1=new JLabel("");
		panel_6.add(non1);
		btNewGame = new JButton("Chơi mới");
		btNewGame.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btNewGame.setForeground(Color.RED);
		btNewGame.setBackground(Color.CYAN);
		panel_6.add(btNewGame);

	

		btHelp = new JButton("Hướng dẫn");
		btHelp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btHelp.setForeground(Color.RED);
		btHelp.setBackground(Color.CYAN);
		panel_6.add(btHelp);

		btExit = new JButton("Thoát");
		btExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		btExit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btExit.setForeground(Color.RED);
		btExit.setBackground(Color.CYAN);

		
		panel_6.add(btExit); // thêm nút exit


	}

	@Override
	public void newGame() {
		btNewGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				newGame = new NewGame();
				newGame.setVisible(true);
			}
		});
	}



	@Override
	public void help() {
		btHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				help = new Help();
				help.setVisible(true);
			}
		});
	}
}