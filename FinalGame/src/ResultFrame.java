import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Window.Type;

/**
 * 
 */

/**
 * @author 44742
 *
 */
public class ResultFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField correct;
	public JTextField fouls;
	public JTextField incotect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultFrame frame = new ResultFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ResultFrame() {
		setType(Type.UTILITY);
		setFont(new Font("Barron", Font.PLAIN, 29));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(410, 70, 465, 235);
		setBounds(340, 30, 465, 235);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		//contentPane.setBorder(new TitledBorder(new CompoundBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 5), new LineBorder(new Color(204, 204, 255), 4)), new CompoundBorder(new LineBorder(new Color(191, 205, 219), 15), new LineBorder(new Color(204, 204, 255), 9))), "Contact : msfata@me.com      +447421110333", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(211, 211, 211)));
		contentPane.setBorder(new TitledBorder(new CompoundBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 204), 5), new LineBorder(new Color(255, 255, 153), 4)), new CompoundBorder(new LineBorder(new Color(255, 204, 102), 15), new LineBorder(new Color(255, 255, 51), 9))), "Contact : msfata@me.com      +447421110333", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(211, 211, 211)));
		
		//contentPane.setBorder(new TitledBorder(new CompoundBorder(new CompoundBorder(new LineBorder(new Color(102, 102, 102), 5), new LineBorder(new Color(153, 153, 153), 4)), new CompoundBorder(new LineBorder(new Color(119, 136, 153), 15), new LineBorder(new Color(230, 230, 250), 9))), "Contact : msfata@me.com      +447421110333", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(211, 211, 211)));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 0, 0, 0));

		JTextField lblCorrcetAnswers = new JTextField("  CORRECT");
		lblCorrcetAnswers.setForeground(Color.BLACK);
		lblCorrcetAnswers.setBackground(Color.WHITE);
		lblCorrcetAnswers.setBorder(null);
		lblCorrcetAnswers.setFont(new Font("4114 Blaster Bold", Font.PLAIN, 20));
		panel.add(lblCorrcetAnswers);

		correct = new JTextField();
		correct.setForeground(Color.BLACK);
		correct.setBorder(null);
		correct.setBackground(Color.WHITE);
		correct.setEditable(false);
		correct.setFont(new Font("DS-Digital", Font.PLAIN, 40));
		correct.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(correct);
		correct.setColumns(10);

		JTextField lblIncorrcetAnswers = new JTextField("  INCORRECT");
		lblIncorrcetAnswers.setBorder(null);
		lblIncorrcetAnswers.setForeground(Color.BLACK);
		lblIncorrcetAnswers.setBackground(Color.WHITE);
		lblIncorrcetAnswers.setFont(new Font("4114 Blaster Bold", Font.PLAIN, 20));
		panel.add(lblIncorrcetAnswers);

		incotect = new JTextField();
		incotect.setForeground(Color.BLACK);
		incotect.setBorder(null);
		incotect.setBackground(Color.WHITE);
		incotect.setEditable(false);
		incotect.setFont(new Font("DS-Digital", Font.PLAIN, 40));
		incotect.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(incotect);
		incotect.setColumns(10);

		JTextField lblFouls = new JTextField("  FOULS");
		lblFouls.setBorder(null);
		lblFouls.setForeground(Color.BLACK);
		lblFouls.setBackground(Color.WHITE);
		lblFouls.setFont(new Font("4114 Blaster Bold", Font.PLAIN, 20));
		panel.add(lblFouls);

		fouls = new JTextField();
		fouls.setForeground(Color.BLACK);
		fouls.setBorder(null);
		fouls.setBackground(Color.WHITE);
		fouls.setEditable(false);
		fouls.setFont(new Font("DS-Digital", Font.PLAIN, 40));
		fouls.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(fouls);
		fouls.setColumns(10);
		setUndecorated(true);
	}

}
