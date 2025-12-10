



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class GUI_TP1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField raioTextFeild;
	private JTextField anguloTextFeild;
	private JTextField distanciaTextFeild;
	private JTextField robotTextFeild;
	private Dados dados;
	private JTextArea textArea;
	 private MovimentosAleatorios movimentosAl;
	
	
	  public void setMovimentosAl(MovimentosAleatorios movimentosAl) {
	        this.movimentosAl = movimentosAl;
	    }

	    public MovimentosAleatorios getMovimentosAl() {
	        return movimentosAl;
	    }
	    
	   
	
	public void run() {
		
	}
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
	}

	/**
	 * Create the frame.
	 */
	public GUI_TP1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 414);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		
		JLabel raioLable = new JLabel("Raio");
		raioLable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		raioLable.setBounds(10, 10, 34, 31);
		contentPane.add(raioLable);
		
		JLabel anguloLable = new JLabel("Ângulo");
		anguloLable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		anguloLable.setBounds(89, 10, 52, 31);
		contentPane.add(anguloLable);
		
		JLabel distanciaLabel = new JLabel("Distância");
		distanciaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		distanciaLabel.setBounds(180, 10, 66, 31);
		contentPane.add(distanciaLabel);
		
		raioTextFeild = new JTextField();
		
		raioTextFeild.setFont(new Font("Tahoma", Font.PLAIN, 15));
		raioTextFeild.setText("20");
		raioTextFeild.setBounds(37, 16, 34, 19);
		contentPane.add(raioTextFeild);
		raioTextFeild.setColumns(10);
		
		anguloTextFeild = new JTextField();
		
		anguloTextFeild.setText("20");
		anguloTextFeild.setFont(new Font("Tahoma", Font.PLAIN, 15));
		anguloTextFeild.setColumns(10);
		anguloTextFeild.setBounds(136, 16, 34, 19);
		contentPane.add(anguloTextFeild);
		
		distanciaTextFeild = new JTextField();
		
		distanciaTextFeild.setText("20");
		distanciaTextFeild.setFont(new Font("Tahoma", Font.PLAIN, 15));
		distanciaTextFeild.setColumns(10);
		distanciaTextFeild.setBounds(241, 16, 34, 19);
		contentPane.add(distanciaTextFeild);
		
		JLabel robotLable = new JLabel("Robot");
		robotLable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		robotLable.setBounds(365, 10, 39, 31);
		contentPane.add(robotLable);
		
		robotTextFeild = new JTextField();
		
		
		robotTextFeild.setText("ZE");
		robotTextFeild.setFont(new Font("Tahoma", Font.PLAIN, 15));
		robotTextFeild.setColumns(10);
		robotTextFeild.setBounds(405, 16, 34, 19);
		contentPane.add(robotTextFeild);
		
		
		
		//FALTA DESLIGAR SIMULADO QUANDO LIGA
		JCheckBox blueCheckBox = new JCheckBox("Ligar");
		blueCheckBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if(!dados.isOnOff()) {
		    		System.out.println("PRIMEIRO IF");
                    if(dados.getRobot().OpenEV3(dados.getNomeRobot())) {
                    	System.out.println("SEGUNDO IF");
                        dados.setOnOff(true);
                        consolePrint("open");
                    }
                    
                }
                else {
                	System.out.println("ELSE");
                    dados.getRobot().CloseEV3();
                    dados.setOnOff(false);
                    consolePrint("close");
                }
                blueCheckBox.setSelected(dados.isOnOff());
		    }
		});
		
		blueCheckBox.setContentAreaFilled(false);
		blueCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blueCheckBox.setBounds(365, 41, 97, 21);
		contentPane.add(blueCheckBox);
		
		JButton frenteButton = new JButton("FRENTE");
		frenteButton.setBackground(new Color(0, 255, 0));
		frenteButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frenteButton.setBounds(180, 86, 119, 37);
		contentPane.add(frenteButton);
		
		JButton pararButton = new JButton("STOP!");
		
		pararButton.setBackground(new Color(255, 0, 0));
		pararButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pararButton.setBounds(180, 125, 119, 37);
		contentPane.add(pararButton);
		
		JButton trasButton = new JButton("TRÁS");
		trasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		trasButton.setBackground(new Color(255, 255, 0));
		trasButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		trasButton.setBounds(180, 164, 119, 37);
		contentPane.add(trasButton);
		
		JButton direitaButton = new JButton("DIREITA");
		direitaButton.setBackground(new Color(0, 128, 255));
		direitaButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		direitaButton.setBounds(300, 125, 119, 37);
		contentPane.add(direitaButton);
		
		JButton esquerdaButton = new JButton("ESQUERDA");
		esquerdaButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)	);
		esquerdaButton.setBackground(new Color(255, 0, 255));
		esquerdaButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		esquerdaButton.setBounds(61, 125, 119, 37);
		contentPane.add(esquerdaButton);
		
		JScrollPane consolaPane = new JScrollPane();
		consolaPane.setBounds(37, 265, 402, 94);
		contentPane.add(consolaPane);
		
		textArea = new JTextArea();
		textArea.setRows(6);
		consolaPane.setViewportView(textArea);
		
		JLabel numeroLabel = new JLabel("Numero");
		numeroLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeroLabel.setBounds(187, 211, 59, 31);
		contentPane.add(numeroLabel);
		
		JSpinner numeroSpinner = new JSpinner();
		numeroSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int spinner = (Integer) numeroSpinner.getValue();
	            dados.setSpinner(spinner);
	            consolePrint("Spinner= " + dados.getSpinner());
				
			}
		});
		numeroSpinner.setModel(new SpinnerNumberModel(1, 1, 16, 1));
		numeroSpinner.setBounds(241, 215, 34, 28);
		contentPane.add(numeroSpinner);
		
		JRadioButton movAleatorioRadioButton = new JRadioButton("Movimentos Aleatorios");
		movAleatorioRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (movAleatorioRadioButton.isSelected()) {
			            
			            movimentosAl = new MovimentosAleatorios();
			            movimentosAl.setDados(dados);
			            movimentosAl.start();
			            System.out.println("Started random movements");
			        } else {
			            
			            if (movimentosAl != null) {
			                movimentosAl.stopRunning();
			                System.out.println("Stopped random movements");
			            }
			        }
			    }
			
		});
		movAleatorioRadioButton.setContentAreaFilled(false);
		movAleatorioRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		movAleatorioRadioButton.setBounds(281, 212, 181, 32);
		contentPane.add(movAleatorioRadioButton);
		
		JLabel consolaLabel = new JLabel("Consola");
		consolaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		consolaLabel.setBounds(38, 230, 61, 31);
		contentPane.add(consolaLabel);
		
		JCheckBox simulateCheckBox = new JCheckBox("Simular");
		
		simulateCheckBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
		});


		
		
		simulateCheckBox.setContentAreaFilled(false);
		simulateCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		simulateCheckBox.setBounds(10, 41, 93, 21);
		contentPane.add(simulateCheckBox);
		
JButton esquerdaloop = new JButton("\u21BA");
        
        esquerdaloop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dados.getRobot().CurvarEsquerda(dados.getRaio(), dados.getAngulo());
                
            }
        });
        esquerdaloop.setFont(new Font("Dialog", Font.PLAIN, 20));
        esquerdaloop.setBackground(new Color(255, 0, 255));
        esquerdaloop.setBounds(61, 86, 52, 37);
        contentPane.add(esquerdaloop);
        
        JButton direitaloop = new JButton("\u21BB");
        direitaloop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dados.getRobot().CurvarDireita(dados.getRaio(), dados.getAngulo());
            }
        });
        direitaloop.setFont(new Font("Dialog", Font.PLAIN, 20));
        direitaloop.setBackground(new Color(0, 128, 255));
        direitaloop.setBounds(367, 86, 52, 37);
        contentPane.add(direitaloop);
		
		
		//EVENTS
		
		raioTextFeild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int raio = Integer.parseInt(raioTextFeild.getText());
	            dados.setRaio(raio);
	            consolePrint("Raio= " + dados.getRaio());
			}
		});

		
		anguloTextFeild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int angulo = Integer.parseInt(anguloTextFeild.getText());
	            dados.setAngulo(angulo);
	            consolePrint("Angulo= " + dados.getAngulo());
			}
		});
		
		
		
		distanciaTextFeild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int distancia = Integer.parseInt(distanciaTextFeild.getText());
	            dados.setDistancia(distancia);
	            consolePrint("Distancia= " + dados.getDistancia());
			}
		});
		
		frenteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Runnable frenteTarefa = new Runnable() {
					public void run() {
						frenteAction();
					}
				};
				new Thread(frenteTarefa).start();
				
				
			}
			
		});
		
		
		esquerdaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Runnable esquerdaTarefa = new Runnable() {
					public void run() {
						esquerdaAction();
					}
				};
				new Thread(esquerdaTarefa).start();
				
			}
		});
		
		direitaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Runnable direitaTarefa = new Runnable() {
					public void run() {
						direitaAction();
					}
				};
				new Thread(direitaTarefa).start();
				
				
				
		    }
				
				
				
		
		});
		
		
		trasButton.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	Runnable trasTarefa = new Runnable() {
					public void run() {
						trasAction();
					}
				};
				new Thread(trasTarefa).start();
		        
		    }
		});
		
		
		pararButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dados.getRobot().PararSensor(true);
				consolePrint("Parou!");
			}
		});
		
		robotTextFeild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeRobot = robotTextFeild.getText();
				dados.setNomeRobot(nomeRobot);
				consolePrint("Nome do Robo= " + dados.getNomeRobot() + "\n");
				consolePrint("on and off=" + dados.isOnOff() + "\n");
				
				
			}
		});
		
	
		
		
		
		
		
		setVisible(true);
	}

	public Dados getDados() {
		return dados;
	}

	public void setDados(Dados dados) {
		this.dados = dados;
	}
	
	public void consolePrint(String s) {
		textArea.append(s + "\n");
	}
	
	
	private  void frenteAction() {
		try {
        	
            dados.getGestor().pedirRobot();
            consolePrint("Frente, Distancia=" + dados.getDistancia() + "\n");
			dados.getRobot().Reta(dados.getDistancia());
			dados.getRobot().Parar(false);

		} finally {
            
            try {
	            dados.getGestor().devolverRobot();
            } catch (Exception ex) {
                System.err.println("Erro ao liberar semáforo em escrever: " + ex.getMessage());
            }
        }
		
	}
		
		
		
	private void esquerdaAction() {
		try {
        	
        	dados.getGestor().pedirRobot();
            consolePrint("Esquerda, Angulo=" + dados.getAngulo() + ", Raio=" + dados.getRaio() + "\n");
			dados.getRobot().CurvarEsquerda(dados.getRaio(), dados.getAngulo());
			dados.getRobot().Parar(false);

		} finally {
            
            try {
            	dados.getGestor().devolverRobot();
            } catch (Exception ex) {
                System.err.println("Erro ao liberar semáforo em escrever: " + ex.getMessage());
            }
        }
	}
	
	
	private void direitaAction() {
		try {
        	
        	dados.getGestor().pedirRobot();
			consolePrint("Direita, Angulo=" + dados.getAngulo() + ", Raio=" + dados.getRaio() + "\n");
			dados.getRobot().CurvarDireita(dados.getRaio(), dados.getAngulo());
			dados.getRobot().Parar(false);

		} finally {
            
            try {
            	dados.getGestor().devolverRobot();
            } catch (Exception ex) {
                System.err.println("Erro ao liberar semáforo em escrever: " + ex.getMessage());
            }
        }
	}
	
	private void trasAction() {
		try {
        	
        	dados.getGestor().pedirRobot();
            consolePrint("Tras, Distancia=" + dados.getDistancia() + "\n");
            int temp = dados.getDistancia();
            dados.getRobot().Reta(-temp);
            dados.getRobot().Parar(false);
        } finally {
            
            try {
            	dados.getGestor().devolverRobot();
            } catch (Exception ex) {
                System.err.println("Erro ao liberar semáforo em escrever: " + ex.getMessage());
            }
        }
	}
	
	
	
		
	
	
		
		
	
	
	
	
	
	
	
	
	
	
	
}
