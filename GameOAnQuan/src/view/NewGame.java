package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class NewGame extends JFrame implements IFrame, INewGame {
	private INumber_Player number_Player;
	private IMenu menu;

	private JButton btTwoPlayer,btOnePlayer;
	private JButton btBack;
    private INewGame newGame;

	/**
	 * Create the panel.
	 */
	public NewGame() {
        getContentPane().setBackground(Color.WHITE);
        setTitle("Cờ Ô Quan");
        setSize(WIDTHJF, HEIGHTJF);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        initComps();
        onePlayer();
        twoPlayer();
        back();
    }

    public void initComps() {
        getContentPane().setLayout(new BorderLayout(50, 50));
        JPanel panel_4 = new JPanel();
        panel_4.setOpaque(false);
        getContentPane().add(panel_4, BorderLayout.CENTER);
        panel_4.setLayout(new GridLayout(3, 1, 0, 0)); // Thay đổi số hàng thành 3
    
        JPanel panel_6_1 = new JPanel();
        panel_6_1.setOpaque(false);
        panel_6_1.setLayout(new GridBagLayout());
        panel_4.add(panel_6_1); // Thêm panel vào frame
    
        // Thiết lập các nút và các thuộc tính của GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
    
        btOnePlayer = new JButton("1 Người chơi");
        btOnePlayer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        btOnePlayer.setForeground(Color.RED);
        btOnePlayer.setBackground(Color.CYAN);
        panel_6_1.add(btOnePlayer, gbc);
    
        gbc.gridy = 1;
        btTwoPlayer = new JButton("2 Người chơi");
        btTwoPlayer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        btTwoPlayer.setForeground(Color.RED);
        btTwoPlayer.setBackground(Color.CYAN);
        panel_6_1.add(btTwoPlayer, gbc);
    
        gbc.gridy = 2;
        btBack = new JButton("Trở về");
        btBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        btBack.setForeground(Color.RED);
        btBack.setBackground(Color.CYAN);
        panel_6_1.add(btBack, gbc);
    
        // Đặt panel_6_1 vào giữa
        getContentPane().add(panel_6_1, BorderLayout.CENTER);
    }
    

    @Override
	public void onePlayer() {
		btOnePlayer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createNumber_Player_Game(Number_Player_Type.ONEPLAYER);
			}
		});

	}


    @Override
    public void twoPlayer() {
        btTwoPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNumber_Player_Game(Number_Player_Type.TWOPLAYER);
            }
        });
    }

    public void createNumber_Player_Game(Number_Player_Type numberType) {
		switch (numberType) {
		case ONEPLAYER:
			dispose();
			number_Player = new OnePlayer();
			number_Player.setVisible(true);
			break;
		case TWOPLAYER:
			dispose();
			number_Player = new TwoPlayer();
			number_Player.setVisible(true);
			break;

		default:
			break;
		}
	}

	@Override
	public void back() {
		btBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				menu = new Menu();
				menu.setVisible(true);
				;
			}
		});
	}
}
