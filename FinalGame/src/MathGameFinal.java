
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.UIManager;

/**
 * @author MSFATA ProgrammingHelp
 *
 */
public class MathGameFinal extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	protected static ResultFrame rf = new ResultFrame();
	PracticeTipsFrame pt = new PracticeTipsFrame();
	private JPanel contentPane;
	private static JTextField firtsNum;
	private static JTextField secondNum;
	protected static JTextField answer;
	private static JTextField tfCorrect;
	private static JTextField tfIncorrect;
	protected static int counterCorrect = 1;
	protected static int uncorrectCounter = 1;
	private static int speed;
	private JButton btnEasy;
	private JButton btnHard;
	private JButton btnNormal;
	private JPanel hardnessLevelPanel;
	private JPanel rgbColorPanel;
	private JButton lblGreen;
	private JButton lblRed;
	private JButton lblBlue;
	private JTextField lbFreeLeft;
	public static JButton tfResult;
	private JTextField lbMissed;
	private JButton button9;
	private JButton button5;
	private JButton button0;
	protected String number;
	private JButton btnLevelThree;
	private JButton btnLevelOne;
	private JButton btnLevelTwo;
	private JPanel operationFrame;
	private JButton plusButton;
	private JButton minusButton;
	private JButton devisionButton;
	private JButton mutiplicationButton;
	static JLabel tfOperation;
	protected static boolean levelOne;
	protected static boolean levelTwo;
	protected static boolean levelThree;
	private JButton restartButton;
	private JButton exitButton;
	public static int uncor;
	public static int cor;
	private static double result;
	@SuppressWarnings("unused")
	private static int x = 1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static boolean running = false;
	protected static boolean TWENTY;
	protected static boolean SIXTEEN;
	protected static boolean TWELVE;
	protected static boolean TWENTYFOUR;
	static MathGameFinal frame;
	static Thread t;
	private static JTextField tfRoundCounter;
	private static int round = 1;
	private JButton buttonDecimal;
	private double result1;
	private double result2;
//	private static int missedCounter=-4;
	protected static boolean isSmallScreen;
	protected boolean roundIsCompleted;
	private JButton btnQ12;
	private JButton btnQ16;
	private JButton btnQ20;
	private JButton btnQ24;
	private boolean soundOn;
	private JButton label;
	private int numberOfFouls;
//	protected Filter f = new Filter();
	private static JLabel lblTime;
	private static JLabel lblDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
		frame = new MathGameFinal();
		frame.setVisible(true);
		levelOne = true;
		tfRoundCounter.setText("" + round);
//		MultiThreadFrame m=new MultiThreadFrame();
		t = new Thread(frame);
		running = true;
		CurrentDate();
		t.start();
//		MultiThreadFrame.startThread();
//		startThread();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public MathGameFinal() {
		setBackground(Color.BLACK);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(0, 0, 1010, 686);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int w = gd.getDisplayMode().getWidth();
		int h = gd.getDisplayMode().getHeight();
		setBounds(0, 0, w, h);// blocked
		isSmallScreen = false;
//		setBounds(0, 0, 1280, 800);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (isSmallScreen == false) {
					setBounds(0, 0, 1280, 800);
					isSmallScreen = true;
					answer.requestFocus();
					pt.setVisible(true);
				} else {
					setBounds(0, 0, w, h);
					isSmallScreen = false;
					answer.requestFocus();
					pt.setVisible(false);
				}
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(new CompoundBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 204), 5), new LineBorder(new Color(255, 255, 153), 4)), new CompoundBorder(new LineBorder(new Color(255, 204, 102), 15), new LineBorder(new Color(255, 255, 51), 9))), "Contact : msfata@me.com      +447421110333", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(211, 211, 211)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel upperPanel = new JPanel();
		upperPanel.setBorder(new LineBorder(new Color(248, 248, 255), 5));
		upperPanel.setBounds(34, 34, 1081, 276);
		contentPane.add(upperPanel);
		upperPanel.setLayout(new GridLayout(3, 0, 0, 0));

		firtsNum = new JTextField();
		firtsNum.setForeground(new Color(0, 0, 0));
		firtsNum.setBackground(new Color(255, 255, 204));
		firtsNum.setBorder(null);
//	tfFirstNumber.addCaretListener(new CaretListener() {
//		@Override
//		public void caretUpdate(CaretEvent arg0) {
//			try {
//				JOptionPane.showMessageDialog(null, "jjjd");
//			} catch (NumberFormatException e) {
//
//			}
//		}
//	});
//		
		firtsNum.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if (btnHard.isEnabled()==false || btnNormal.isEnabled()==false || btnEasy.isEnabled()==false){
//					tfAnswer.setEditable(false);
//					tfAnswer.setBackground(Color.YELLOW);
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				if (btnHard.isEnabled()==false || btnNormal.isEnabled()==false || btnEasy.isEnabled()==false) {
//					tfAnswer.setEditable(true);
//					tfAnswer.setBackground(Color.RED);
					answer.setText("");
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (btnHard.isEnabled()==false || btnNormal.isEnabled()==false || btnEasy.isEnabled()==false){
//					tfAnswer.setEditable(false);
//					tfAnswer.setBackground(Color.GREEN);
					answer.setText("");
				}
			}
		});

		firtsNum.setFont(new Font("DS-Digital", Font.BOLD, 60));
		upperPanel.add(firtsNum);
		firtsNum.setHorizontalAlignment(SwingConstants.CENTER);

		tfOperation = new JLabel("+");
		tfOperation.setBackground(Color.WHITE);
		tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/+.png")));
		tfOperation.setFont(new Font("Dialog", Font.BOLD, 1));
		tfOperation.setHorizontalAlignment(SwingConstants.CENTER);
		upperPanel.add(tfOperation);

		secondNum = new JTextField();
		secondNum.setForeground(new Color(0, 0, 0));
		secondNum.setBackground(new Color(255, 255, 204));
		secondNum.setBorder(null);
		secondNum.setFont(new Font("DS-Digital", Font.BOLD, 60));
		secondNum.setHorizontalAlignment(SwingConstants.CENTER);
		upperPanel.add(secondNum);

//		lbFreeLeft = new JTextField();
		lbFreeLeft = new JTextField();
		lbFreeLeft.setEditable(false);
		lbFreeLeft.setEnabled(false);
		lbFreeLeft.setForeground(new Color(255, 255, 255));
		lbFreeLeft.setBorder(null);
		lbFreeLeft.setBackground(new Color(255, 255, 153));
		lbFreeLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lbFreeLeft.setFont(new Font("Bascula", Font.PLAIN, 14));
		upperPanel.add(lbFreeLeft);

		answer = new JTextField();
		answer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				number = "";
				answer.setText("");
			}
		});
		answer.setCaretColor(new Color(255, 255, 255));
		answer.setBackground(new Color(255, 255, 255));
		answer.setBorder(null);
		answer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculate();
			}
		});
		answer.setFont(new Font("Barron", Font.PLAIN, 40));
		answer.setHorizontalAlignment(SwingConstants.CENTER);
		upperPanel.add(answer);
		answer.setColumns(10);

//		lbMissed = new JTextField();
		lbMissed = new JTextField();
		lbMissed.setEditable(false);
		lbMissed.setEnabled(false);

		lbMissed.setBorder(null);
		lbMissed.setBackground(new Color(255, 255, 153));
		lbMissed.setHorizontalAlignment(SwingConstants.CENTER);
		lbMissed.setFont(new Font("Tahoma", Font.BOLD, 18));
		upperPanel.add(lbMissed);

		tfIncorrect = new JTextField();
		tfIncorrect.setBackground(new Color(255, 255, 204));
		tfIncorrect.setBorder(null);
		tfIncorrect.setForeground(new Color(0, 0, 0));
		tfIncorrect.setFont(new Font("DS-Digital", Font.BOLD, 60));
		tfIncorrect.setHorizontalAlignment(SwingConstants.CENTER);
		upperPanel.add(tfIncorrect);

		tfResult = new JButton();
		tfResult.setForeground(new Color(0, 128, 0));
		tfResult.setBorder(null);
		tfResult.setBackground(new Color(255, 255, 204));
		tfResult.setHorizontalAlignment(SwingConstants.CENTER);
		tfResult.setFont(new Font("Barron", Font.PLAIN, 40));
		upperPanel.add(tfResult);

		tfCorrect = new JTextField();
		tfCorrect.setBackground(new Color(255, 255, 204));
		tfCorrect.setBorder(null);
		tfCorrect.setForeground(new Color(0, 0, 0));
		tfCorrect.setFont(new Font("DS-Digital", Font.BOLD, 60));
		tfCorrect.setHorizontalAlignment(SwingConstants.CENTER);
		upperPanel.add(tfCorrect);

		hardnessLevelPanel = new JPanel();
		hardnessLevelPanel.setToolTipText("Last step of entering a challenge ");
		hardnessLevelPanel.setBackground(Color.WHITE);
		hardnessLevelPanel.setBorder(null);
		hardnessLevelPanel.setBounds(359, 491, 287, 262);
		contentPane.add(hardnessLevelPanel);
		hardnessLevelPanel.setLayout(new GridLayout(0, 1, 0, 0));

		btnEasy = new JButton("");
		btnEasy.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/easy.png")));
		btnEasy.setBorder(null);
		btnEasy.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEasy.setForeground(Color.BLACK);
		btnEasy.setBackground(Color.WHITE);
		hardnessLevelPanel.add(btnEasy);

		btnNormal = new JButton("");
		btnNormal.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/medium.png")));
		btnNormal.setBorder(null);
		btnNormal.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNormal.setForeground(Color.BLACK);
		btnNormal.setBackground(Color.WHITE);
		hardnessLevelPanel.add(btnNormal);

		btnHard = new JButton("");
		btnHard.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/hard.png")));
		btnHard.setBorder(null);
		btnHard.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHard.setForeground(Color.BLACK);
		btnHard.setBackground(Color.WHITE);
		hardnessLevelPanel.add(btnHard);

		JPanel numberButtonPanel = new JPanel();
		numberButtonPanel.setBorder(null);
		numberButtonPanel.setBackground(Color.WHITE);
		numberButtonPanel.setBounds(658, 323, 450, 431);
		contentPane.add(numberButtonPanel);

		JButton button1 = new JButton("");
		button1.setBorder(null);
		button1.setBackground(Color.WHITE);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					if (!number.equals(null)) {
						number = number + 1;
					}
				} catch (Exception any) {
					number = "1";
				}
				answer.setText(number);
				answer.requestFocus();
			}

		});
		numberButtonPanel.setLayout(new GridLayout(0, 3, 0, 0));
		button1.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/B1.png")));
		numberButtonPanel.add(button1);

		JButton button2 = new JButton("");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (!number.equals(null)) {
						number = number + 2;
					}
				} catch (Exception any) {
					number = "2";
				}

				answer.setText(number);
				answer.requestFocus();
			}

		});
		button2.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/b2.png")));
		button2.setBorder(new LineBorder(new Color(255, 255, 204), 3));
		button2.setBackground(Color.WHITE);
		numberButtonPanel.add(button2);

		JButton button3 = new JButton("");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!number.equals(null)) {
						number = number + 3;
					}
				} catch (Exception any) {
					number = "3";
				}

				answer.setText(number);
				answer.requestFocus();
			}
		});
		button3.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/B3.png")));
		button3.setBorder(null);
		button3.setBackground(Color.WHITE);
		numberButtonPanel.add(button3);

		JButton button4 = new JButton("");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!number.equals(null)) {
						number = number + 4;
					}
				} catch (Exception any) {
					number = "4";
				}

				answer.setText(number);
				answer.requestFocus();
			}
		});
		button4.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/b4.png")));
		button4.setBorder(new LineBorder(new Color(255, 255, 204), 3));
		button4.setBackground(Color.WHITE);
		numberButtonPanel.add(button4);

		button5 = new JButton("");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!number.equals(null)) {
						number = number + 5;
					}
				} catch (Exception any) {
					number = "5";
				}

				answer.setText(number);
				answer.requestFocus();
			}
		});
		button5.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/b5.png")));
		button5.setBorder(new LineBorder(new Color(255, 255, 204), 3));
		button5.setBackground(Color.WHITE);
		numberButtonPanel.add(button5);

		JButton button6 = new JButton("");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!number.equals(null)) {
						number = number + 6;
					}
				} catch (Exception any) {
					number = "6";
				}

				answer.setText(number);
				answer.requestFocus();
			}
		});
		button6.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/b6.png")));
		button6.setBorder(new LineBorder(new Color(255, 255, 204), 3));
		button6.setBackground(Color.WHITE);
		numberButtonPanel.add(button6);

		JButton button7 = new JButton("");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!number.equals(null)) {
						number = number + 7;
					}
				} catch (Exception any) {
					number = "7";
				}

				answer.setText(number);
				answer.requestFocus();
			}
		});
		button7.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/b7.png")));
		button7.setBorder(new LineBorder(new Color(255, 255, 204), 3));
		button7.setBackground(Color.WHITE);
		numberButtonPanel.add(button7);

		JButton button8 = new JButton("");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!number.equals(null)) {
						number = number + 8;
					}
				} catch (Exception any) {
					number = "8";
				}

				answer.setText(number);
				answer.requestFocus();
			}
		});
		button8.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/b8..png")));
		button8.setBorder(new LineBorder(new Color(255, 255, 204), 3));
		button8.setBackground(Color.WHITE);
		numberButtonPanel.add(button8);

		button9 = new JButton("");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!number.equals(null)) {
						number = number + 9;
					}
				} catch (Exception any) {
					number = "9";
				}

				answer.setText(number);
				answer.requestFocus();
			}
		});
		button9.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/b9.png")));
		button9.setBorder(new LineBorder(new Color(255, 255, 204), 3));
		button9.setBackground(Color.WHITE);
		numberButtonPanel.add(button9);
						
								button0 = new JButton("");
								button0.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										try {
											if (!number.equals(null)) {
												number = number + 0;
											}
										} catch (Exception any) {
											number = "0";
										}

										answer.setText(number);
										answer.requestFocus();
									}
								});
								
										buttonDecimal = new JButton("");
										numberButtonPanel.add(buttonDecimal);
										buttonDecimal.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
												try {
													if (!number.equals(null)) {
														number = number + ".";
													}
												} catch (Exception any) {
													number = ".";
												}

												answer.setText(number);
												answer.requestFocus();
											}
										});
										buttonDecimal.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/B00.png")));
										buttonDecimal.setBorder(null);
										buttonDecimal.setBackground(Color.WHITE);
								button0.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/B0.png")));
								button0.setBorder(new LineBorder(new Color(255, 255, 204), 3));
								button0.setBackground(Color.WHITE);
								numberButtonPanel.add(button0);
								
										label = new JButton("");
										numberButtonPanel.add(label);
										label.setBorder(null);
										label.setBackground(Color.WHITE);
										label.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
												if (soundOn) {
													soundOn = false;
													label.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/buttonSound/soundOff.png")));
													answer.requestFocus();
												} else {
													soundOn = true;
//													label.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/buttonSound/soundOn.png")));
													label.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/SPEAKER.png")));
													answer.requestFocus();
												}
											}
										});
										label.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/SPEAKER.png")));
										label.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel levelPanel = new JPanel();
		levelPanel.setBorder(null);
		levelPanel.setToolTipText("First step of entering a challenge.");
		levelPanel.setBounds(34, 314, 532, 76);
		contentPane.add(levelPanel);
		levelPanel.setLayout(new GridLayout(1, 0, 0, 0));

		btnLevelOne = new JButton("");
//		btnLevelOne.setEnabled(false);
		btnLevelOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				restartButton.setEnabled(true);
				answer.setText("");
				levelOne = true;
				levelTwo = false;
				levelThree = false;
				answer.requestFocus();
				controlLevels(false, true, true);
				rf.dispose();
			}
		});
		btnLevelOne.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/button_level.png")));
		btnLevelOne.setBorder(null);
		btnLevelOne.setBackground(Color.WHITE);
		levelPanel.add(btnLevelOne);

		btnLevelTwo = new JButton("");
		btnLevelTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartButton.setEnabled(true);
				answer.setText("");
				answer.requestFocus();
				levelOne = false;
				levelTwo = true;
				levelThree = false;
				controlLevels(true, false, true);
				rf.dispose();
			}
		});
		btnLevelTwo.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/button_level 2.png")));
		btnLevelTwo.setBorder(null);
		btnLevelTwo.setBackground(Color.WHITE);
		levelPanel.add(btnLevelTwo);

		btnLevelThree = new JButton("");
		btnLevelThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartButton.setEnabled(true);
				answer.setText("");
				answer.requestFocus();
				levelOne = false;
				levelTwo = false;
				levelThree = true;
				controlLevels(true, true, false);
				rf.dispose();
			}
		});
		btnLevelThree.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/button_level 3.png")));
		btnLevelThree.setBorder(null);
		btnLevelThree.setBackground(Color.WHITE);
		levelPanel.add(btnLevelThree);

		operationFrame = new JPanel();
		operationFrame.setToolTipText("Manually Playing Math's ");
		operationFrame.setBorder(new LineBorder(Color.WHITE, 5));
		operationFrame.setBounds(34, 394, 154, 368);
		contentPane.add(operationFrame);
		operationFrame.setLayout(new GridLayout(4, 0, 0, 0));

		plusButton = new JButton("");
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfOperation.setText("+");
				tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/+.png")));
				answer.requestFocus();
			}
		});
		plusButton.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/OP+.png")));
		plusButton.setBorder(null);
		plusButton.setBackground(Color.WHITE);
		operationFrame.add(plusButton);

		devisionButton = new JButton("");
		devisionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfOperation.setText("/");
				tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/++.png")));
				answer.requestFocus();
			}
		});
		
				minusButton = new JButton("");
				minusButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tfOperation.setText("-");
						tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/-.png")));
						answer.requestFocus();
					}
				});
				minusButton.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/OP-.png")));
				minusButton.setBorder(null);
				minusButton.setBackground(Color.WHITE);
				operationFrame.add(minusButton);
		devisionButton.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/OPDEV.png")));
		devisionButton.setBorder(null);
		devisionButton.setBackground(Color.WHITE);
		operationFrame.add(devisionButton);

		mutiplicationButton = new JButton("");
		mutiplicationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfOperation.setText("*");
				tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/x.png")));
				answer.requestFocus();
			}
		});
		mutiplicationButton.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/OPX.png")));
		mutiplicationButton.setBorder(null);
		mutiplicationButton.setBackground(Color.WHITE);
		operationFrame.add(mutiplicationButton);

		JPanel quizFrame = new JPanel();
		quizFrame.setToolTipText("Second step of Challenge Q ( question ❔)");
		quizFrame.setBorder(null);
		quizFrame.setBounds(185, 402, 162, 352);
		contentPane.add(quizFrame);
		quizFrame.setLayout(new GridLayout(4, 0, 0, 0));

		btnQ24 = new JButton("");
		btnQ24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TWENTYFOUR = true;
				answer.requestFocus();

				setNumberOfQuestions(true, true, true, false);
				restartButton.setEnabled(true);
				rf.dispose();
			}
		});
		buttonGroup.add(btnQ24);
		btnQ24.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/q24.png")));
		btnQ24.setBorder(new LineBorder(Color.WHITE, 3));
		btnQ24.setBackground(Color.WHITE);
		quizFrame.add(btnQ24);

		btnQ20 = new JButton("");
		btnQ20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TWENTY = true;
				answer.requestFocus();
				setNumberOfQuestions(true, true, false, true);
				restartButton.setEnabled(true);
				rf.dispose();
			}
		});
		buttonGroup.add(btnQ20);
		btnQ20.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/q20.png")));
		btnQ20.setBorder(new LineBorder(Color.WHITE, 3));
		btnQ20.setBackground(Color.WHITE);
		quizFrame.add(btnQ20);

		btnQ16 = new JButton("");
		btnQ16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SIXTEEN = true;
				answer.requestFocus();
				setNumberOfQuestions(true, false, true, true);
				restartButton.setEnabled(true);
				rf.dispose();
			}
		});
		buttonGroup.add(btnQ16);
		btnQ16.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/q16.png")));
		btnQ16.setBorder(new LineBorder(Color.WHITE, 3));
		btnQ16.setBackground(Color.WHITE);
		quizFrame.add(btnQ16);

		btnQ12 = new JButton("");
		btnQ12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TWELVE = true;
				answer.requestFocus();
				setNumberOfQuestions(false, true, true, true);
				restartButton.setEnabled(true);
				rf.dispose();
			}
		});
		buttonGroup.add(btnQ12);
		btnQ12.setIcon(new ImageIcon(MathGameFinal.class.getResource("/BUTTONS/q12.png")));
		btnQ12.setBorder(new LineBorder(Color.WHITE, 3));
		btnQ12.setBackground(Color.WHITE);
		quizFrame.add(btnQ12);

		JPanel exitPanel = new JPanel();
		exitPanel.setBounds(1117, 39, 112, 262);
		contentPane.add(exitPanel);
		exitPanel.setLayout(new GridLayout(0, 1, 0, 0));

		restartButton = new JButton("");
		restartButton.setToolTipText("Resetting to defaults ");
		restartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SoundUtils.resetSound();
				if (roundIsCompleted == true) {
					tfRoundCounter.setText("" + ++round);
					roundIsCompleted = false;
				}
				resetLevels();
				resetQuestions();
				btnEasy.setEnabled(true);
				btnNormal.setEnabled(true);
				btnHard.setEnabled(true);

				roundIsCompleted = false;
//				running = false;
				TWELVE = false;
				SIXTEEN = false;
				TWENTY = false;
				TWENTYFOUR = false;

				speed = 0;
				levelOne = true;
				levelTwo = false;
				levelThree = false;

				lblGreen.setBackground(Color.WHITE);
				lblBlue.setBackground(Color.WHITE);
				lblRed.setBackground(Color.WHITE);

				cor = 0;
				uncor = 0;
				counterCorrect = 1;
				uncorrectCounter = 1;
				tfCorrect.setText("");
				tfIncorrect.setText("");
				tfResult.setText("");
				answer.requestFocus();
				tfResult.setIcon(new ImageIcon(MathGameFinal.class.getResource("")));
				tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/+.png")));
				answer.setText("");
				Thread t2 = new Thread();
				t2.start();
				running = true;
				tfOperation.setText("+");
				tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/+.png")));
				answer.requestFocus();
//				rf.setVisible(false);
//				running =true;
				rf.dispose();
			
			}
		});

		exitPanel.add(restartButton);
		restartButton.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/button_restart (1).png")));
		restartButton.setBorder(null);
		restartButton.setBackground(Color.WHITE);

		tfRoundCounter = new JTextField("");
		tfRoundCounter.setEditable(false);
		tfRoundCounter.setToolTipText("Round Indicator");
		tfRoundCounter.setHorizontalAlignment(SwingConstants.CENTER);
		tfRoundCounter.setFont(new Font("DS-Digital", Font.BOLD, 50));
		tfRoundCounter.setBorder(new LineBorder(Color.WHITE, 9));
		tfRoundCounter.setBackground(new Color(238, 232, 170));
		exitPanel.add(tfRoundCounter);

		exitButton = new JButton("");
		exitButton.setToolTipText("Exiting Programme ");
		exitPanel.add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitButton.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/button_exit (1).png")));
		exitButton.setBorder(null);
		exitButton.setBackground(Color.WHITE);

		rgbColorPanel = new JPanel();
		rgbColorPanel.setToolTipText("Active Level Indicators");
		rgbColorPanel.setBounds(341, 497, 14, 246);
		contentPane.add(rgbColorPanel);
		rgbColorPanel.setBackground(Color.WHITE);
		rgbColorPanel.setLayout(new GridLayout(3, 0, 0, 0));

		lblGreen = new JButton("");
		lblGreen.setToolTipText("Easy Level Indicator");
		lblGreen.setBackground(Color.WHITE);
		lblGreen.setBorder(null);
		rgbColorPanel.add(lblGreen);

		lblBlue = new JButton("");
		lblBlue.setToolTipText("Normal Level Indicator");
		lblBlue.setBackground(Color.WHITE);
		lblBlue.setBorder(null);
		rgbColorPanel.add(lblBlue);

		lblRed = new JButton("");
		lblRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				pt.setVisible(true);
			}
		});
		lblRed.setToolTipText("Hard Level Indicator");
		lblRed.setBackground(Color.WHITE);
		lblRed.setBorder(null);
		rgbColorPanel.add(lblRed);
		
		JSlider slider = new JSlider(SwingConstants.VERTICAL);
		slider.setBackground(Color.WHITE);
		slider.setForeground(Color.BLACK);
		slider.setName("SPEEDY ");
		slider.setMinorTickSpacing(2);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
              speed=slider.getValue()*100;
              answer.requestFocus();
			}
		});
	    slider.setMajorTickSpacing(10);
        slider.setMaximum(100);
        slider.isCursorSet();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 204), 5), "\uD83C\uDFC3 SPEED", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 200, 0)));
        Font font = new Font("Serif", Font.ITALIC, 15);
        slider.setFont(font);
		slider.setBounds(1120, 314, 109, 440);
		contentPane.add(slider);
		
				lblTime = new JLabel("");
				lblTime.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
//						new ResultFrame().setVisible(true);
					}
				});
				lblTime.setBounds(410, 403, 236, 38);
				contentPane.add(lblTime);
				lblTime.setForeground(Color.BLUE);
				lblTime.setFont(new Font("DS-Digital", Font.BOLD, 30));
				lblTime.setHorizontalAlignment(SwingConstants.LEFT);
				
						lblDate = new JLabel("");
						lblDate.setBounds(410, 440, 236, 38);
						contentPane.add(lblDate);
						lblDate.setHorizontalAlignment(SwingConstants.LEFT);
						lblDate.setForeground(Color.BLUE);
						lblDate.setFont(new Font("DS-Digital", Font.BOLD, 30));
		setUndecorated(true);
		setType(Type.UTILITY);
		btnHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfResult.setText("");
				if (levelOne) {
					speed = 2000;
				} else if (levelTwo) {
					speed = 4000;
				} else if (levelThree) {
					speed = 8000;
				}

				lblRed.setBackground(Color.RED);
				lblBlue.setBackground(Color.WHITE);
				lblGreen.setBackground(Color.WHITE);
				btnEasy.setEnabled(true);
				btnNormal.setEnabled(true);
				btnHard.setEnabled(false);
				answer.requestFocus();
				restartButton.setEnabled(true);
				rf.dispose();
			}
		});
		btnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfResult.setText("");
				if (levelOne) {
					speed = 4000;
				} else if (levelTwo) {
					speed = 6000;
				} else if (levelThree) {
					speed = 90000;
				}
				answer.requestFocus();
				lblBlue.setBackground(Color.BLUE);
				lblGreen.setBackground(Color.WHITE);
				lblRed.setBackground(Color.WHITE);
				btnEasy.setEnabled(true);
				btnNormal.setEnabled(false);
				btnHard.setEnabled(true);
				restartButton.setEnabled(true);
				rf.dispose();
			}
		});
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfResult.setText("");
				if (levelOne) {
					speed = 5000;
				} else if (levelTwo) {
					speed = 8000;
				} else if (levelThree) {
					speed = 12000;
				}
				answer.requestFocus();
				lblGreen.setBackground(Color.GREEN);
				lblBlue.setBackground(Color.WHITE);
				lblRed.setBackground(Color.WHITE);

				//

//				startThread();
				//
				btnEasy.setEnabled(false);
				btnNormal.setEnabled(true);
				btnHard.setEnabled(true);
				restartButton.setEnabled(true);
				rf.setVisible(false);
				// calculate();
				rf.dispose();
			}
		});

	}

	/**
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 */
	protected void setNumberOfQuestions(boolean b, boolean c, boolean d, boolean e) {
		btnQ12.setEnabled(b);
		btnQ16.setEnabled(c);
		btnQ20.setEnabled(d);
		btnQ24.setEnabled(e);

	}

	/**
	 * @param b
	 * @param c
	 * @param d
	 */
	protected void controlLevels(boolean b, boolean c, boolean d) {
		btnLevelOne.setEnabled(b);
		btnLevelTwo.setEnabled(c);
		btnLevelThree.setEnabled(d);
		tfResult.setIcon(new ImageIcon(MathGameFinal.class.getResource("")));
	}

	/**
	 * 
	 */
	protected void calculate() {

		if (Filter.allowNumbersOnly(answer.getText()) == false) {
			answer.setText("");
		} else {
			try {
				NumberFormat formatter = new DecimalFormat("#0.0");
				String fcor = "";
				String ncor = "";
				if (result == (Double.parseDouble(firtsNum.getText())
						+ Double.parseDouble(secondNum.getText()))
						&& result1 == Double.parseDouble(firtsNum.getText())
						&& result2 == Double.parseDouble(secondNum.getText())) {
					numberOfFouls++;
				} else {
					char[] op = tfOperation.getText().toCharArray();
					Double correct = 0.0, incorrect = 0.0;
					switch (op[0]) {
					case '+':
						if (Double.parseDouble(firtsNum.getText()) + Double
								.parseDouble(secondNum.getText()) == Double.parseDouble(answer.getText())) {
							result = Double.parseDouble(firtsNum.getText())
									+ Double.parseDouble(secondNum.getText());
							result1 = Double.parseDouble(firtsNum.getText());
							result2 = Double.parseDouble(secondNum.getText());
							tfCorrect.setText("" + counterCorrect++);
  
						} else {
							// from here setting tips table
							result = Double.parseDouble(firtsNum.getText())
									+ Double.parseDouble(secondNum.getText());
							correct = result;
							incorrect = Double.parseDouble(answer.getText());
							fcor = formatter.format(correct);
							ncor = formatter.format(incorrect);
							pt.model = (DefaultTableModel) pt.table.getModel();
							pt.model.insertRow(pt.model.getRowCount(), new Object[] { firtsNum.getText(),
									tfOperation.getText(), secondNum.getText(), ncor, fcor });
							// upto here setting tips table
							tfIncorrect.setText("" + uncorrectCounter++);
							answer.setText("");
							answer.requestFocus();
						}

						break;
					case '-':
						if (Double.parseDouble(firtsNum.getText()) - Double
								.parseDouble(secondNum.getText()) == Double.parseDouble(answer.getText())) {
							result = Double.parseDouble(firtsNum.getText())
									- Double.parseDouble(secondNum.getText());
							result1 = Double.parseDouble(firtsNum.getText());
							result2 = Double.parseDouble(secondNum.getText());
							tfCorrect.setText("" + counterCorrect++);
						} else {
							// from here setting tips table
							result = Double.parseDouble(firtsNum.getText())
									- Double.parseDouble(secondNum.getText());
							correct = result;
							incorrect = Double.parseDouble(answer.getText());
							fcor = formatter.format(correct);
							ncor = formatter.format(incorrect);
							pt.model = (DefaultTableModel) pt.table.getModel();
							pt.model.insertRow(pt.model.getRowCount(), new Object[] { firtsNum.getText(),
									tfOperation.getText(), secondNum.getText(), ncor, fcor });
							// upto here setting tips table
							tfIncorrect.setText("" + uncorrectCounter++);
							answer.setText("");
							answer.requestFocus();
						}
						break;
					case '/':

						if (Double.parseDouble(firtsNum.getText()) / Double
								.parseDouble(secondNum.getText()) == Double.parseDouble(answer.getText())) {
							result = Double.parseDouble(firtsNum.getText())
									/ Double.parseDouble(secondNum.getText());
							result1 = Double.parseDouble(firtsNum.getText());
							result2 = Double.parseDouble(secondNum.getText());
							tfCorrect.setText("" + counterCorrect++);
						} else {
							// from here setting tips table
							result = Double.parseDouble(firtsNum.getText())
									/ Double.parseDouble(secondNum.getText());
							correct = result;
							incorrect = Double.parseDouble(answer.getText());
							fcor = formatter.format(correct);
							ncor = formatter.format(incorrect);
							pt.model = (DefaultTableModel) pt.table.getModel();
							pt.model.insertRow(pt.model.getRowCount(), new Object[] { firtsNum.getText(),
									tfOperation.getText(), secondNum.getText(), ncor, fcor });
							// upto here setting tips table
							tfIncorrect.setText("" + uncorrectCounter++);
							answer.setText("");
							answer.requestFocus();
						}

						break;
					case '*':
						if (Double.parseDouble(firtsNum.getText()) * Double
								.parseDouble(secondNum.getText()) == Double.parseDouble(answer.getText())) {
							result = Double.parseDouble(firtsNum.getText())
									* Double.parseDouble(secondNum.getText());
							result1 = Double.parseDouble(firtsNum.getText());
							result2 = Double.parseDouble(secondNum.getText());
							tfCorrect.setText("" + counterCorrect++);
						} else {
							// from here setting tips table
							result = Double.parseDouble(firtsNum.getText())
									* Double.parseDouble(secondNum.getText());
							correct = result;
							incorrect = Double.parseDouble(answer.getText());
							fcor = formatter.format(correct);
							ncor = formatter.format(incorrect);
							pt.model = (DefaultTableModel) pt.table.getModel();
							pt.model.insertRow(pt.model.getRowCount(), new Object[] { firtsNum.getText(),
									tfOperation.getText(), secondNum.getText(), ncor, fcor });
							// upto here setting tips table
							tfIncorrect.setText("" + uncorrectCounter++);
							answer.setText("");
							answer.requestFocus();
						}
						break;
					}
					answer.setText("");
				}
				number = "";
				answer.setText("");

			} catch (NumberFormatException e) {
			}
			answer.requestFocus();
		}
	}

	@Override
	public void run() {
//		calculate();removed 
		while (running == true) {

			try {
				String x1 = tfCorrect.getText();
				cor = Integer.parseInt(String.valueOf(x1));
				String x2 = tfIncorrect.getText();
				uncor = Integer.parseInt(String.valueOf(x2));

				calculate();
			} catch (NumberFormatException e1) {
				calculate();
			}

			/*
			 * sound on all the time
			 */
			if (soundOn == true) {
				try {
//					JOptionPane.showMessageDialog(null, "j");
//				    tfAnswer.setEditable(true);

					SoundUtils.operationSound();

				} catch (Exception e) {
				}
			} // end sound on all the time

			if (TWELVE == true) {

				if (cor == 3) {
					try {
						SoundUtils.operationSound();
//						missedCounter++;
//						lbMissed.setText(""+missedCounter);
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfOperation.setText("-");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/-.png")));
					answer.requestFocus();
				}
				if (cor == 6) {
					try {
						SoundUtils.operationSound();
//						missedCounter++;
//						lbMissed.setText(""+missedCounter);
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfOperation.setText("*");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/x.png")));
					answer.requestFocus();
				}
				if (cor == 9) {
					try {
						SoundUtils.operationSound();
//						missedCounter++;
//						lbMissed.setText(""+missedCounter);
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfOperation.setText("/");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/++.png")));
					answer.requestFocus();
				}

				if (cor == 12 && uncor == 0) {
					openResult();
					resetCorrectUncorrect();

					tfOperation.setText("+");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/+.png")));
					answer.requestFocus();
					tfResult.setText("Good Job  !!! ");
					speed = 0;
					roundIsCompleted = true;
					tfResult.setIcon(new ImageIcon(MathGameFinal.class.getResource("/DigitsImages/FU8l.gif")));
					answer.requestFocus();

					resetHardnes();
					resetQuestions();
					resetLevels();
					makeLablesWhite();
					resetSound();
					try {
						SoundUtils.winingSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (roundIsCompleted == true) {
						tfRoundCounter.setText("" + ++round);
						roundIsCompleted = false;
					}

				}

				if (cor == 12 && uncor > 0) {
					openResult();

					tfOperation.setText("+");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/+.png")));
					answer.requestFocus();
					resetCorrectUncorrect();
					try {
						SoundUtils.lossingSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfResult.setText("Try again !!! ");
					restartButton.setEnabled(false);
					speed = 0;
					roundIsCompleted = true;
//					round++;
//					tfRound.setText("" + round);
					answer.requestFocus();

					makeLablesWhite();
					resetHardnes();
					resetQuestions();
					resetLevels();
					resetSound();
					if (roundIsCompleted == true) {
						tfRoundCounter.setText("" + ++round);
						roundIsCompleted = false;
					}

				}

			}

			if (SIXTEEN == true) {

				if (cor == 4) {
					try {
						SoundUtils.operationSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfOperation.setText("-");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/-.png")));
					answer.requestFocus();
				}
				if (cor == 8) {
					try {
						SoundUtils.operationSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfOperation.setText("*");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/x.png")));
					answer.requestFocus();
				}
				if (cor == 12) {
					try {
						SoundUtils.operationSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfOperation.setText("/");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/++.png")));
					answer.requestFocus();
				}
				if (cor == 16 && uncor == 0) {
					openResult();
					resetCorrectUncorrect();

					roundIsCompleted = true;
					tfOperation.setText("+");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/+.png")));
					answer.requestFocus();
					tfResult.setText("Good Job  !!! ");
					resetHardnes();
					resetSound();
					resetQuestions();
					resetLevels();
					speed = 0;
					roundIsCompleted = true;
					tfResult.setIcon(new ImageIcon(MathGameFinal.class.getResource("/DigitsImages/FU8l.gif")));
					try {
						SoundUtils.winingSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					answer.requestFocus();
					makeLablesWhite();
					if (roundIsCompleted == true) {
						tfRoundCounter.setText("" + ++round);
						roundIsCompleted = false;
					}
				}
				if (cor == 16 && uncor > 0) {
					openResult();
					roundIsCompleted = true;
					tfOperation.setText("+");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/+.png")));
					answer.requestFocus();
					resetCorrectUncorrect();
					try {
						SoundUtils.lossingSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfResult.setText("Try again !!! ");
					restartButton.setEnabled(false);

					resetHardnes();

					resetQuestions();
					resetSound();
					resetLevels();
					speed = 0;
					roundIsCompleted = true;
					answer.requestFocus();
					makeLablesWhite();
					if (roundIsCompleted == true) {
						tfRoundCounter.setText("" + ++round);
						roundIsCompleted = false;
					}
				}

			}
			if (TWENTY == true) {

				if (cor == 5) {
					try {
						SoundUtils.operationSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfOperation.setText("-");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/-.png")));
					answer.requestFocus();
				}
				if (cor == 10) {
					try {
						SoundUtils.operationSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfOperation.setText("*");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/x.png")));
					answer.requestFocus();
				}
				if (cor == 15) {
					try {
						SoundUtils.operationSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfOperation.setText("/");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/++.png")));
					answer.requestFocus();
				}
				if (cor == 20 && uncor == 0) {
					openResult();
					resetCorrectUncorrect();

					roundIsCompleted = true;
					tfOperation.setText("+");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/+.png")));
					answer.requestFocus();
					answer.setText("Good Job  !!! ");

					resetHardnes();
					resetSound();
					resetQuestions();
					resetLevels();
					speed = 0;
					roundIsCompleted = true;
					tfResult.setIcon(new ImageIcon(MathGameFinal.class.getResource("/DigitsImages/FU8l.gif")));
					try {
						SoundUtils.winingSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					answer.requestFocus();
					makeLablesWhite();
					if (roundIsCompleted == true) {
						tfRoundCounter.setText("" + ++round);
						roundIsCompleted = false;
					}
				}
				if (cor == 20 && uncor > 0) {
					openResult();
					roundIsCompleted = true;
					tfOperation.setText("+");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/+.png")));
					answer.requestFocus();
					resetCorrectUncorrect();
					try {
						SoundUtils.lossingSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfResult.setText("Try again !!! ");
					restartButton.setEnabled(false);

					resetHardnes();
					resetSound();
					resetQuestions();

					resetLevels();
					speed = 0;
					roundIsCompleted = true;
					answer.requestFocus();
					makeLablesWhite();
					if (roundIsCompleted == true) {
						tfRoundCounter.setText("" + ++round);
						roundIsCompleted = false;
					}
				}

			}
			if (TWENTYFOUR == true) {

				if (cor == 6) {
					try {
						SoundUtils.operationSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfOperation.setText("-");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/-.png")));
					answer.requestFocus();
				}
				if (cor == 12) {
					try {
						SoundUtils.operationSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfOperation.setText("*");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/x.png")));
					answer.requestFocus();
				}
				if (cor == 18) {
					try {
						SoundUtils.operationSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfOperation.setText("/");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/++.png")));
					answer.requestFocus();
				}
				if (cor == 24 && uncor == 0) {
					openResult();
					resetCorrectUncorrect();

					roundIsCompleted = true;
					tfOperation.setText("+");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/+.png")));
					answer.requestFocus();
					answer.setText("Good Job  !!! ");

					resetHardnes();
					resetSound();
					resetQuestions();
					resetLevels();
					speed = 0;
					roundIsCompleted = true;
					tfResult.setIcon(new ImageIcon(MathGameFinal.class.getResource("/DigitsImages/FU8l.gif")));
					try {
						SoundUtils.winingSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					answer.requestFocus();
					makeLablesWhite();
					if (roundIsCompleted == true) {
						tfRoundCounter.setText("" + ++round);
						roundIsCompleted = false;
					}
				}
				if (cor == 24 && uncor > 0) {
					openResult();
					roundIsCompleted = true;
					tfOperation.setText("+");
					tfOperation.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/+.png")));
					answer.requestFocus();
					resetCorrectUncorrect();
					try {
						SoundUtils.lossingSound();
					} catch (Exception e) {
						e.printStackTrace();
					}
					tfResult.setText("Try again !!! ");
					restartButton.setEnabled(false);
					resetHardnes();
					resetQuestions();
					resetSound();
					resetLevels();
					speed = 0;
					roundIsCompleted = true;
					answer.requestFocus();
					makeLablesWhite();
					if (roundIsCompleted == true) {
						tfRoundCounter.setText("" + ++round);
						roundIsCompleted = false;
					}
				}

			}

			int easyDigits = 9;
			int midDigits = 99;
			int hardDigit = 999;
			Random rand = new Random();

			if (levelOne == true) {
				int x = rand.nextInt(easyDigits);
				int y = rand.nextInt(easyDigits);

				if (x <= 0) {
					x = 9;
				}
				if (y <= 0) {
					y = 1;
				}
				if (x > y) {
					firtsNum.setText("" + x);
					secondNum.setText("" + y);
				} else {
					firtsNum.setText("" + y);
					secondNum.setText("" + x);
				}

			} else if (levelTwo == true) {
				int x = rand.nextInt(midDigits);
				int y = rand.nextInt(easyDigits);
				if (x <= 0) {
					x = 9;
				}
				if (y <= 0) {
					y = 1;
				}
				if (x > y && y > 0) {
					firtsNum.setText("" + x);
					secondNum.setText("" + y);
				} else {
					firtsNum.setText("" + y);
					secondNum.setText("" + x);
				}
			} else if (levelThree == true) {
				int x = rand.nextInt(hardDigit);
				int y = rand.nextInt(midDigits);
				if (x <= 0) {
					x = 9;
				}
				if (y <= 0) {
					y = 1;
				}
				if (x > y && y > 0) {
					firtsNum.setText("" + x);
					secondNum.setText("" + y);
				} else {
					firtsNum.setText("" + y);
					secondNum.setText("" + x);
				}
			}

			try {

				Thread.sleep(speed);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}// end run

	/**
	 * 
	 */
	private void openResult() {
		rf.setVisible(true);
		rf.correct.setText("" + cor);
		rf.incotect.setText("" + uncor);
		rf.fouls.setText("" + numberOfFouls);
		rf.setVisible(true);
		pt.setVisible(true);
	}

	/**
	 * 
	 */
	private void resetSound() {
		soundOn = false;
		label.setIcon(new ImageIcon(MathGameFinal.class.getResource("/buttons/buttonSound/soundOff.png")));
		answer.requestFocus();

	}

	/**
	 * 
	 */
	private void resetCorrectUncorrect() {
		tfCorrect.setText("0");
		tfIncorrect.setText("0");
		counterCorrect = 0;
		uncorrectCounter = 0;
		numberOfFouls = 0;
	}

	/**
	 * 
	 */
	private void resetHardnes() {
		btnEasy.setEnabled(true);
		btnNormal.setEnabled(true);
		btnHard.setEnabled(true);
	}

	/**
	 * 
	 */
	private void resetLevels() {
		btnLevelOne.setEnabled(true);
		btnLevelTwo.setEnabled(true);
		btnLevelThree.setEnabled(true);
		tfResult.setIcon(new ImageIcon(MathGameFinal.class.getResource("")));
	}

	/**
	 * 
	 */
	private void resetQuestions() {
		btnQ12.setEnabled(true);
		btnQ16.setEnabled(true);
		btnQ20.setEnabled(true);
		btnQ24.setEnabled(true);
		tfResult.setIcon(new ImageIcon(MathGameFinal.class.getResource("")));
	}

	/**
	 * 
	 */
	private void makeLablesWhite() {
		lblRed.setBackground(Color.WHITE);
		lblBlue.setBackground(Color.WHITE);
		lblGreen.setBackground(Color.WHITE);
		tfResult.setIcon(new ImageIcon(MathGameFinal.class.getResource("")));
	}

	public static void CurrentDate() {
		new Thread() {
			public void run() {
				for (;;) {
					Calendar cal = new GregorianCalendar();
					int year = cal.get(Calendar.YEAR);
					int month = cal.get(Calendar.MONTH);
					int day = cal.get(Calendar.DAY_OF_MONTH);
					lblDate.setText("" + day + " / " + (month + 1) + " / " + year);
					int second = cal.get(Calendar.SECOND);
					int minute = cal.get(Calendar.MINUTE);
					int hour = cal.get(Calendar.HOUR);
					lblTime.setText("" + hour + "  :  " + (minute) + "  :   " + second);
				}
			}
		}.start();
	}
}