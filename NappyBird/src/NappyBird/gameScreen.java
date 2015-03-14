package NappyBird;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class gameScreen {
	JFrame frame;
    DrawPanel drawPanel;

    private int aX = 400;
    private int bX = 650;
    
    boolean aXScored;
    boolean bXScored;
    
    private int aY = 300;
    private int bY = 250;
    
    private int bird1Y = 200;
    private int bird1Vel = 0;
    
    private int bird2Y = 300;
    private int bird2Vel = 0;
    
    private int bird1Acc;
    private int bird2Acc = 1;
    
    boolean gameEnded = true;
    boolean startGame;
    boolean singlePlayer;
    boolean collisionsOn;
    
    int difficulty;
    
    boolean p1Dead;
    boolean p2Dead;
    
    Integer p1Score = 0;
    Integer p2Score = 0;
    
    Integer score = 0;
    Integer eHighscore = 0;
    Integer mHighscore = 0;
    Integer hHighscore = 0;
    final JFrame parent = new JFrame();
    final JFrame charSelect = new JFrame();
    final JFrame aDifficulty = new JFrame();
    
    int character1 = 1;
    boolean characterOneSelected = false;
    int character2 = 2;
    
    public static void main(String... args)
    {
        new gameScreen().go();
    }
    
    public int[] x = new int[600];
    
    int stars = 0;
    
    Image bird1 = null;
    Image bird2 = null;
    Image bird3 = null;
    Image bird4 = null;
    Image bird5 = null;
    Image bird6 = null;
    Image bird7 = null;
    Image bird8 = null;
    Image bird9 = null;
    Image moon = null;
    
    private void go()
    {
    	for(int i = 0; i < 600; i++){
    		x[i] = randInt(1,150);
    	}
    	gameEnded = true;
        frame = new JFrame("Nappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawPanel = new DrawPanel();
        drawPanel.setBackground(Color.BLACK);

        frame.add(drawPanel);

        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocationByPlatform(true);
       
        JPanel pSelect = new JPanel();
        
        charSelect.add(pSelect);
        ImageIcon bird1 = new ImageIcon(this.getClass().getResource("/images/bird1.jpg"));
        ImageIcon bird2 = new ImageIcon(this.getClass().getResource("/images/bird2.jpg"));
        ImageIcon bird3 = new ImageIcon(this.getClass().getResource("/images/bird3.jpg"));
        ImageIcon bird4 = new ImageIcon(this.getClass().getResource("/images/bird4.jpg"));
        ImageIcon bird5 = new ImageIcon(this.getClass().getResource("/images/bird5.jpg"));
        ImageIcon bird6 = new ImageIcon(this.getClass().getResource("/images/bird6.jpg"));
        ImageIcon bird7 = new ImageIcon(this.getClass().getResource("/images/bird7.jpg"));
        ImageIcon bird8 = new ImageIcon(this.getClass().getResource("/images/bird8.jpg"));
        ImageIcon bird9 = new ImageIcon(this.getClass().getResource("/images/bird9.jpg"));
        
        Image birds1 = bird1.getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
        Image birds2 = bird2.getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
        Image birds3 = bird3.getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
        Image birds4 = bird4.getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
        Image birds5 = bird5.getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
        Image birds6 = bird6.getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
        Image birds7 = bird7.getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
        Image birds8 = bird8.getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
        Image birds9 = bird9.getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
        
        bird1 = new ImageIcon(birds1);
        bird2 = new ImageIcon(birds2);
        bird3 = new ImageIcon(birds3);
        bird4 = new ImageIcon(birds4);
        bird5 = new ImageIcon(birds5);
        bird6 = new ImageIcon(birds6);
        bird7 = new ImageIcon(birds7);
        bird8 = new ImageIcon(birds8);
        bird9 = new ImageIcon(birds9);
        
        JButton char1 = new JButton();
        char1.setIcon(bird1);
        char1.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e){
        		if(characterOneSelected){
        			character2 = 1;
        			charSelect.setVisible(false);
        			aDifficulty.setVisible(true);
        		}else{
        			character1 = 1;
        			characterOneSelected = true;
        			if(singlePlayer){
        				charSelect.setVisible(false);
        				aDifficulty.setVisible(true);
        			}
        		}
        	}
        });
        
        JButton char2 = new JButton();
        char2.setIcon(bird2);
        char2.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e){
        		if(characterOneSelected){
        			character2 = 2;
        			charSelect.setVisible(false);
        			aDifficulty.setVisible(true);
        		}else{
        			character1 = 2;
        			characterOneSelected = true;
        			if(singlePlayer){
        				charSelect.setVisible(false);
        				aDifficulty.setVisible(true);
        			}
        		}
        	}
        });
        
        JButton char3 = new JButton();
        char3.setIcon(bird3);
        char3.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e){
        		if(characterOneSelected){
        			character2 = 3;
        			charSelect.setVisible(false);
        			aDifficulty.setVisible(true);
        		}else{
        			character1 = 3;
        			characterOneSelected = true;
        			if(singlePlayer){
        				charSelect.setVisible(false);
        				aDifficulty.setVisible(true);
        			}
        		}
        	}
        });
        
        JButton char4 = new JButton();
        char4.setIcon(bird4);
        char4.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e){
        		if(characterOneSelected){
        			character2 = 4;
        			charSelect.setVisible(false);
        			aDifficulty.setVisible(true);
        		}else{
        			character1 = 4;
        			characterOneSelected = true;
        			if(singlePlayer){
        				charSelect.setVisible(false);
        				aDifficulty.setVisible(true);
        			}
        		}
        	}
        });
        
        JButton char5 = new JButton();
        char5.setIcon(bird5);
        char5.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e){
        		if(characterOneSelected){
        			character2 = 5;
        			charSelect.setVisible(false);
        			aDifficulty.setVisible(true);
        		}else{
        			character1 = 5;
        			characterOneSelected = true;
        			if(singlePlayer){
        				charSelect.setVisible(false);
        				aDifficulty.setVisible(true);
        			}
        		}
        	}
        });
        
        JButton char6 = new JButton();
        char6.setIcon(bird6);
        char6.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e){
        		if(characterOneSelected){
        			character2 = 6;
        			charSelect.setVisible(false);
        			aDifficulty.setVisible(true);
        		}else{
        			character1 = 6;
        			characterOneSelected = true;
        			if(singlePlayer){
        				charSelect.setVisible(false);
        				aDifficulty.setVisible(true);
        			}
        		}
        	}
        });
        
        JButton char7 = new JButton();
        char7.setIcon(bird7);
        char7.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e){
        		if(characterOneSelected){
        			character2 = 7;
        			charSelect.setVisible(false);
        			aDifficulty.setVisible(true);
        		}else{
        			character1 = 7;
        			characterOneSelected = true;
        			if(singlePlayer){
        				charSelect.setVisible(false);
        				aDifficulty.setVisible(true);
        			}
        		}
        	}
        });
        
        JButton char8 = new JButton();
        char8.setIcon(bird8);
        char8.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e){
        		if(characterOneSelected){
        			character2 = 8;
        			charSelect.setVisible(false);
        			aDifficulty.setVisible(true);
        		}else{
        			character1 = 8;
        			characterOneSelected = true;
        			if(singlePlayer){
        				charSelect.setVisible(false);
        				aDifficulty.setVisible(true);
        			}
        		}
        	}
        });
        
        JButton char9 = new JButton();
        char9.setIcon(bird9);
        char9.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e){
        		if(characterOneSelected){
        			character2 = 9;
        			charSelect.setVisible(false);
        			aDifficulty.setVisible(true);
        		}else{
        			character1 = 9;
        			characterOneSelected = true;
        			if(singlePlayer){
        				charSelect.setVisible(false);
            			aDifficulty.setVisible(true);
        			}
        		}
        	}
        });
        
        pSelect.add(char1);
        pSelect.add(char2);
        pSelect.add(char3);
        pSelect.add(char4);
        pSelect.add(char5);
        pSelect.add(char6);
        pSelect.add(char7);
        pSelect.add(char8);
        pSelect.add(char9);
        
        JPanel panel = new JPanel();
        JButton button1 = new JButton();
        button1.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e){
        		singlePlayer = true;
        		charSelect.setVisible(true);
        		parent.setVisible(false);
        	}
        });
        JButton button2 = new JButton();
        button2.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e){
        		singlePlayer = false;
        		collisionsOn = false;
        		charSelect.setVisible(true);
        		parent.setVisible(false);
        		
        	}
        });
        JButton button3 = new JButton();
        button3.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e){
        		singlePlayer = false;
        		collisionsOn = true;
        		charSelect.setVisible(true);
        		parent.setVisible(false);
        	}
        });

        button1.setText("Single Player");
        button2.setText("Multiplayer");
        button3.setText("Multi-Battle");
        
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        parent.add(panel);
        parent.pack();
        charSelect.pack();
        parent.setVisible(true);
        
        JPanel dSelect = new JPanel();
        
        JButton easy = new JButton();
        easy.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e){
        		difficulty = 10;
        		aDifficulty.setVisible(false);
        		frame.setVisible(true);
        	}
        });
        JButton medium = new JButton();
        medium.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e){
        		difficulty = 7;
        		aDifficulty.setVisible(false);
        		frame.setVisible(true);
        	}
        });
        JButton hard = new JButton();
        hard.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e){
        		difficulty = 5;
        		aDifficulty.setVisible(false);
        		frame.setVisible(true);
        	}
        });
        
        aDifficulty.add(dSelect);
        easy.setText("Easy");
        medium.setText("Medium");
        hard.setText("Hard");
        dSelect.add(easy);
        dSelect.add(medium);
        dSelect.add(hard);
        
        aDifficulty.pack();

        
        AbstractAction spacePressed = new AbstractAction(){
        	public void actionPerformed(ActionEvent e){
        		if(singlePlayer){
        			bird1Vel -= 15;
        		}else{
        			bird1Vel += 15;
        		}
        	}};
 		drawPanel.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "fly1");
 		drawPanel.getActionMap().put("fly1", spacePressed);
 		AbstractAction ctrl = new AbstractAction(){
        	public void actionPerformed(ActionEvent e){
        		bird2Vel = bird2Vel - 15;
        	}};
 		drawPanel.getInputMap().put(KeyStroke.getKeyStroke('s'), "fly2");
 		drawPanel.getActionMap().put("fly2", ctrl);
 		drawPanel.requestFocus();
 		drawPanel.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "start");
 		drawPanel.getActionMap().put("start", new AbstractAction(){
        	public void actionPerformed(ActionEvent e){
        		startGame = !startGame;
        		System.out.println("Enter pressed");
        		System.out.println(startGame);
        	}});
        
	 		new Thread(new Runnable()
	 		{
	 			public void run()
	 			{
	 				startGame = false;
	 				int i = 0;
	 				while(true){
	 					while(!startGame){
	 						drawPanel.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "start");
	 						drawPanel.getInputMap().put(KeyStroke.getKeyStroke('m'), "menu");
	 						drawPanel.getActionMap().put(("menu"), new AbstractAction(){
	 				        	public void actionPerformed(ActionEvent e){
	 				        		characterOneSelected = false;
	 				        		parent.setVisible(true);
	 				        	}});
	 					}
	 					if(gameEnded){
	 			 			gameEnded = false;
	 			 			aX = 400;
	 			 			aY = randInt(20,300);;
	 			 			bX = 650;
	 			 			bY = randInt(20,300);
	 			 			bird1Vel = 0;
	 			 			bird2Vel = 0;
	 			 			if(singlePlayer){bird1Acc = 1;}
	 			 			else{
	 			 			bird1Acc = -1;
	 			 			}
	 			 			if(singlePlayer){bird2Acc = 0;}else{bird2Acc = 1;}
	 			 			bird1Y = 100;
	 			 			if(!singlePlayer){bird2Y = 400;}else{bird2Y = 5000;}
	 			 			aXScored = false;
	 			 			aXScored = false;
	 			 			score = 0;
	 			 			p1Dead = false;
	 			 			p2Dead = false;
	 					}
	 					
	 					aX--;
	 					bX--;
			        	
	 					if(i == 3){
	 						detectCollision();
	 						if(bird1Y > 20){
	 							bird1Y += bird1Vel;
	 						} else {
	 							if(bird1Vel >= 0){
	 								bird1Y += bird1Vel;
	 							} else {
	 								bird1Vel = 0;
	 							}
	 						}
	 						bird1Vel += bird1Acc;
	 						if(bird2Y < 450){
	 							bird2Y = bird2Y + bird2Vel;
	 						} else {
	 							if(bird2Vel <= 0){
	 								bird2Y = bird2Y + bird2Vel;
	 							} else {
	 								bird2Vel = 0;
	 							}
	 						}
	 						bird2Vel += bird2Acc;
	 					}
			        	
	 					frame.repaint();
	 					i++;
	 					if(difficulty > 4){
	 						i = i%4;
	 					}
	 					
	 					if(170 >= aX && aX >= 130 && !(bird1Y <= aY + 81 && bird1Y >= aY) && !p1Dead){
	 						p1Dead = true;
	 						p2Score++;
	 						if(p2Dead || singlePlayer){
	 							gameEnded = true;
	 							startGame = false;
	 						}
	 					}
	 					if(170 >= bX && bX >= 130 && !(bird1Y <= bY + 81 && bird1Y >= bY && !p1Dead)){
	 						p1Dead = true;
	 						p2Score++;
	 						if(p2Dead || singlePlayer){
	 							gameEnded = true;
	 							startGame = false;
	 						}
	 					}
	 					if(singlePlayer){
	 						if(bird1Y >= 485){
	 							gameEnded = true;
	 							startGame = false;
	 						}
	 					}
	 					if(!singlePlayer){
	 						if(170 >= aX && aX >= 130 && !(bird2Y <= aY + 81 && bird2Y >= aY  && !p2Dead)){
	 							p2Dead = true;
	 							if(p1Dead){
	 								gameEnded = true;
	 								startGame = false;
	 							}
	 						}
	 						if(170 >= bX && bX >= 130 && !(bird2Y <= bY + 81 && bird2Y >= bY  && !p2Dead)){
	 							p2Dead = true;
	 							if(p1Dead){
	 								gameEnded = true;
	 								startGame = false;
	 							}
	 						}
	 					}
	 					if(aX <= 130 && !aXScored){
	 						score++;
	 						aXScored = true;
	 						if(!p1Dead){
	 							p1Score++;
	 						}
	 						if(!p2Dead){
	 							p2Score++;
	 						}
	 					}
	 					if(bX <= 130 && !bXScored){
	 						score++;
	 						bXScored = true;
	 						if(!p1Dead){
	 							p1Score++;
	 						}
	 						if(!p2Dead){
	 							p2Score++;
	 						}
	 					}
	 					
	 					if(difficulty == 10){
	 						if (score > eHighscore){
		 						eHighscore = score;
		 					}
	 	        		}
	 	        		if(difficulty == 7){
	 	        			if (score > mHighscore){
		 						mHighscore = score;
		 					}
	 	        		}
	 	        		if(difficulty == 5){
	 	        			if (score > hHighscore){
		 						hHighscore = score;
		 					}
	 	        		}
	 					try {
	 						Thread.sleep(difficulty);
	 					} catch (InterruptedException e) {
	 						// TODO Auto-generated catch block
	 						e.printStackTrace();
	 					}
	 				}	
					
	 			}
	 		}).start();
    }
    
    public void detectCollision(){
    	if(!collisionsOn){return;}
    	if(p1Dead || p2Dead){return;}
    	if(bird1Y >= bird2Y - 20){
    		
    		int temp = bird1Vel/2 + 2;
    		bird1Vel = bird2Vel/2 - 2;
    		bird2Vel = temp;
    	}
    	
    }
    
    class DrawPanel extends JPanel
    {
        private static final long serialVersionUID = 1L;
        
        DrawPanel(){
        	frame.setBackground(Color.BLACK);
        	ImageIcon abird1 = new ImageIcon(this.getClass().getResource("/images/bird1.jpg"));
            ImageIcon abird2 = new ImageIcon(this.getClass().getResource("/images/bird2.jpg"));
            ImageIcon abird3 = new ImageIcon(this.getClass().getResource("/images/bird3.jpg"));
            ImageIcon abird4 = new ImageIcon(this.getClass().getResource("/images/bird4.jpg"));
            ImageIcon abird5 = new ImageIcon(this.getClass().getResource("/images/bird5.jpg"));
            ImageIcon abird6 = new ImageIcon(this.getClass().getResource("/images/bird6.jpg"));
            ImageIcon abird7 = new ImageIcon(this.getClass().getResource("/images/bird7.jpg"));
            ImageIcon abird8 = new ImageIcon(this.getClass().getResource("/images/bird8.jpg"));
            ImageIcon abird9 = new ImageIcon(this.getClass().getResource("/images/bird9.jpg"));
            ImageIcon amoon = new ImageIcon(this.getClass().getResource("/images/moon.jpg"));
            
            bird1 = abird1.getImage();
            bird2 = abird2.getImage();
            bird3 = abird3.getImage();
            bird4 = abird4.getImage();
            bird5 = abird5.getImage();
            bird6 = abird6.getImage();
            bird7 = abird7.getImage();
            bird8 = abird8.getImage();
            bird9 = abird9.getImage();
            moon = amoon.getImage();
            
            
        	
        }

        public void paintComponent(Graphics g)
        {
        	
        	g.setColor(Color.RED);
        	if(singlePlayer){
        		g.drawString("Current: " + score.toString(),241, 50);
        		if(difficulty == 10){
        			g.drawString("Highscore: " + eHighscore.toString(),225, 30);
        			g.drawString("Difficulty: Easy",239, 70);
        		}
        		if(difficulty == 7){
        			g.drawString("Highscore: " + mHighscore.toString(),225, 30);
        			g.drawString("Difficulty: Medium",239, 70);
        		}
        		if(difficulty == 5){
        			g.drawString("Highscore: " + hHighscore.toString(),225, 30);
        			g.drawString("Difficulty: Hard",239, 70);
        		}
        		
        	}else{
        		g.drawString("Player One: " + p1Score.toString(),225, 30);
        		g.drawString("Player Two: " + p2Score.toString(),225, 50);
        		if(difficulty == 10){
        			g.drawString("Difficulty: Easy",239, 70);
        		}
        		if(difficulty == 7){
        			g.drawString("Difficulty: Medium",239, 70);
        		}
        		if(difficulty == 5){
        			g.drawString("Difficulty: Hard",239, 70);
        		}
        	}
        	g.setColor(Color.WHITE);
        	g.drawImage(moon,0, 0, 200, 200, null);
        	
        	for(int i = 0; i < 1500;){
        		g.drawLine((i - stars) % 500, x[i/4], (i - stars) % 500, x[i/4] + 1);
        		i += 4;
        	}
        	
        	if(!p1Dead){
        		if(character1 == 1){
        			g.drawImage(bird1,150, bird1Y, 20, 20, null);
        		}
        		if(character1 == 2){
        			g.drawImage(bird2,150, bird1Y, 20, 20, null);
        		}
        		if(character1 == 3){
        			g.drawImage(bird3,150, bird1Y, 20, 20, null);
        		}
        		if(character1 == 4){
        			g.drawImage(bird4,150, bird1Y, 20, 20, null);
        		}
        		if(character1 == 5){
        			g.drawImage(bird5,150, bird1Y, 20, 20, null);
        		}
        		if(character1 == 6){
        			g.drawImage(bird6,150, bird1Y, 20, 20, null);
        		}
        		if(character1 == 7){
        			g.drawImage(bird7,150, bird1Y, 20, 20, null);
        		}
        		if(character1 == 8){
        			g.drawImage(bird8,150, bird1Y, 20, 20, null);
        		}
        		if(character1 == 9){
        			g.drawImage(bird9,150, bird1Y, 20, 20, null);
        		}
        	}
        	
        	if(!singlePlayer && !p2Dead){
        		if(character2 == 1){
        			g.drawImage(bird1,150, bird2Y, 20, 20, null);
        		}
        		if(character2 == 2){
        			g.drawImage(bird2,150, bird2Y, 20, 20, null);
        		}
        		if(character2 == 3){
        			g.drawImage(bird3,150, bird2Y, 20, 20, null);
        		}
        		if(character2 == 4){
        			g.drawImage(bird4,150, bird2Y, 20, 20, null);
        		}
        		if(character2 == 5){
        			g.drawImage(bird5,150, bird2Y, 20, 20, null);
        		}
        		if(character2 == 6){
        			g.drawImage(bird6,150, bird2Y, 20, 20, null);
        		}
        		if(character2 == 7){
        			g.drawImage(bird7,150, bird2Y, 20, 20, null);
        		}
        		if(character2 == 8){
        			g.drawImage(bird8,150, bird2Y, 20, 20, null);
        		}
        		if(character2 == 9){
        			g.drawImage(bird9,150, bird2Y, 20, 20, null);
        		}
        	}
        	
            g.drawRect(aX, 0, 20, aY);
            g.drawRect(aX, aY + 100, 20, 400 - aY);
            
            
            g.drawRect(bX, 0, 20, bY);
            g.drawRect(bX, bY + 100, 20, 400 - bY);
            if (aX <= 0 ){
            	aX = 500;
            	aY = randInt(20,300);
            	aXScored = false;
            }
            if(bX <= 0){
            	bX = 500;
            	bY = randInt(20,300);
            	bXScored = false;
            }
            stars++; 
            stars = stars % 500;
        }
        
    }
    public static int randInt(int min, int max) {
    	
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

}


