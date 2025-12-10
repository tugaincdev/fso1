



import java.awt.EventQueue;
import java.awt.FileDialog;

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
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class GUI_TP2_Gravador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField raioTextFeild;
	private JTextField anguloTextFeild;
	private JTextField distanciaTextFeild;
	private JTextField robotTextFeild;
	private Dados dados;
	private JTextArea textArea;
	private MovimentosAleatorios movimentosAl;
	private JTextField ficheiroTextField;
	private JCheckBox printConsolaCheckBox;
	
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
	public GUI_TP2_Gravador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 544);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		
		JLabel raioLable = new JLabel("Raio");
		raioLable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		raioLable.setBounds(34, 24, 34, 31);
		contentPane.add(raioLable);
		
		JLabel anguloLable = new JLabel("Angulo");
		anguloLable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		anguloLable.setBounds(113, 24, 52, 31);
		contentPane.add(anguloLable);
		
		JLabel distanciaLabel = new JLabel("Distancia");
		distanciaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		distanciaLabel.setBounds(204, 24, 66, 31);
		contentPane.add(distanciaLabel);
		
		raioTextFeild = new JTextField();
		
		raioTextFeild.setFont(new Font("Tahoma", Font.PLAIN, 15));
		raioTextFeild.setText("20");
		raioTextFeild.setBounds(61, 30, 34, 19);
		contentPane.add(raioTextFeild);
		raioTextFeild.setColumns(10);
		
		anguloTextFeild = new JTextField();
		
		anguloTextFeild.setText("20");
		anguloTextFeild.setFont(new Font("Tahoma", Font.PLAIN, 15));
		anguloTextFeild.setColumns(10);
		anguloTextFeild.setBounds(160, 30, 34, 19);
		contentPane.add(anguloTextFeild);
		
		distanciaTextFeild = new JTextField();
		
		distanciaTextFeild.setText("20");
		distanciaTextFeild.setFont(new Font("Tahoma", Font.PLAIN, 15));
		distanciaTextFeild.setColumns(10);
		distanciaTextFeild.setBounds(265, 30, 34, 19);
		contentPane.add(distanciaTextFeild);
		
		JLabel robotLable = new JLabel("Robot");
		robotLable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		robotLable.setBounds(365, 24, 39, 31);
		contentPane.add(robotLable);
		
		robotTextFeild = new JTextField();
		
		
		robotTextFeild.setText("ZE");
		robotTextFeild.setFont(new Font("Tahoma", Font.PLAIN, 15));
		robotTextFeild.setColumns(10);
		robotTextFeild.setBounds(402, 30, 34, 19);
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
                        System.out.println(dados.isOnOff());
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
		blueCheckBox.setBounds(365, 55, 97, 21);
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
		
		JButton trasButton = new JButton("TRÀS");
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
		consolaPane.setBounds(37, 374, 402, 94);
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
		
		JCheckBox simulateCheckBox = new JCheckBox("Simular");
		
		simulateCheckBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
		});


		
		
		simulateCheckBox.setContentAreaFilled(false);
		simulateCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		simulateCheckBox.setBounds(34, 55, 93, 21);
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
        
        JButton limparConsolaButton = new JButton("Limpar");
        limparConsolaButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        limparConsolaButton.setBackground(new Color(192, 192, 192));
        limparConsolaButton.setBounds(89, 478, 85, 21);
        contentPane.add(limparConsolaButton);
        
        Box robotBox = Box.createHorizontalBox();
        robotBox.setBorder(new LineBorder(new Color(0, 0, 0)));
        robotBox.setBounds(10, 20, 470, 234);
        contentPane.add(robotBox);
        
        printConsolaCheckBox = new JCheckBox("Imprimir");
        printConsolaCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        printConsolaCheckBox.setBackground(new Color(192, 192, 192));
        printConsolaCheckBox.setBounds(241, 478, 93, 21);
        contentPane.add(printConsolaCheckBox);
        
        Box consolaBox = Box.createHorizontalBox();
        consolaBox.setBorder(new LineBorder(new Color(0, 0, 0)));
        consolaBox.setBounds(10, 368, 470, 132);
        contentPane.add(consolaBox);
        
        JButton gravarButton = new JButton("Gravar");
        gravarButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        gravarButton.setBounds(89, 322, 129, 21);
        contentPane.add(gravarButton);
        
        JButton reproduzirButton = new JButton("Reproduzir");
        reproduzirButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        reproduzirButton.setBounds(226, 322, 146, 21);
        contentPane.add(reproduzirButton);
        
        JButton tresPontosButton = new JButton("...");
        tresPontosButton.setVerticalAlignment(SwingConstants.BOTTOM);
        tresPontosButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tresPontosButton.setBounds(425, 291, 39, 21);
        contentPane.add(tresPontosButton);
        
        JLabel ficheiroLabel = new JLabel("Ficheiro");
        ficheiroLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        ficheiroLabel.setBounds(15, 296, 61, 13);
        contentPane.add(ficheiroLabel);
        
        ficheiroTextField = new JTextField();
        ficheiroTextField.setBounds(69, 293, 350, 19);
        contentPane.add(ficheiroTextField);
        ficheiroTextField.setColumns(10);
        
        Box gravadorBox = Box.createHorizontalBox();
        gravadorBox.setBorder(new LineBorder(new Color(0, 0, 0)));
        gravadorBox.setBounds(10, 276, 470, 72);
        contentPane.add(gravadorBox);
		
		
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
				consolePrint("Nome do Robo= " + dados.getNomeRobot());
				consolePrint("on and off=" + dados.isOnOff());
				
				
			}
		});
		
		
		
		//AGORA TP2 EVENTOS:
		
		
		tresPontosButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				consolePrint("Carregou no botão três pontos");
				
				FileDialog dialog = new FileDialog(GUI_TP2_Gravador.this); //this is a file explorer window
                String path;
                dialog.setMode(FileDialog.LOAD);
                dialog.setVisible(true); 
                
                
                
                //put the fileName in textField if fileIsSelected
                if (dialog.getFile() != null) {
                    path = dialog.getDirectory() + dialog.getFile();
                    consolePrint("Selecionou o ficheiro: " + path);
                    ficheiroTextField.setText(path);
                    try {
						dados.getReplay().setFileName(path);
						dados.getRecorder().setFileName(path);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    
                } else {
                    consolePrint("Não selecionou nenhum ficheiro");
                }        		
      		
        		
        	}
        });
		
		ficheiroTextField.addActionListener(e -> {
		    String path = ficheiroTextField.getText().trim();
		    if (!path.isEmpty()) {
		        consolePrint("Using new file path from textbox: " + path);

		        try {
		            // Update both recorder and replay threads
		            dados.getRecorder().setFileName(path);
		            dados.getReplay().setFileName(path);

		            consolePrint("File path updated successfully.");
		        } catch (IOException ex) {
		            ex.printStackTrace();
		            consolePrint("Error setting new file path!");
		        }
		    } else {
		        consolePrint("Textbox is empty. No path set.");
		    }
		});
		
		gravarButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
	            RecorderThread recorder = dados.getRecorder();
	            if (recorder.getEstado() == Estado.ACTIVE) {
	                recorder.setEstado(Estado.NOT_ACTIVE);  
	                consolePrint("Recorder estado NOT_ACTIVE");
	               
	            } else {
	                recorder.setEstado(Estado.ACTIVE);  
	                consolePrint("Recorder estado ACTIVE");
	                
	            }
	            
	            
	            
	        }
		    
		});
		
		reproduzirButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 ReplayThread replay = dados.getReplay();
 	            if (replay.getEstado() == Estado.ACTIVE) {
 	                replay.setEstado(Estado.NOT_ACTIVE);  
 	                consolePrint("Replay estado NOT_ACTIVE");
 	               
 	            } else {
 	                replay.setEstado(Estado.ACTIVE);  
 	                consolePrint("Replay  estado ACTIVE");
 	                
 	            }
				
        	}
        });
		
		limparConsolaButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				consolePrint("Carregou no botão limpar consola");
				textArea.setText("");
        	}
        });
		
		printConsolaCheckBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				consolePrint("Carregou na checkBox imprimir da consola");
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
		if (printConsolaCheckBox.isSelected()) {
			textArea.append(s + "\n");
		}
	}
	
	
	private  void frenteAction() {
		try {
        	
			dados.getGestor().pedirRobot();
            consolePrint("Frente, Distancia=" + dados.getDistancia());
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
            consolePrint("Esquerda, Angulo=" + dados.getAngulo() + ", Raio=" + dados.getRaio());
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
			consolePrint("Direita, Angulo=" + dados.getAngulo() + ", Raio=" + dados.getRaio());
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
            consolePrint("Tras, Distancia=" + dados.getDistancia());
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
	
	
	private void pararAction() {
		dados.getRobot().PararSensor(true);
		consolePrint("Parou!");
	}
}
