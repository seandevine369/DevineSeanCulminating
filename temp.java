import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class A6 extends  JFrame implements ActionListener{ 
  
  // Name-constants for the various dimensions
  public static final int CANVAS_WIDTH = 900;
  public static final int CANVAS_HEIGHT = 900;
  public static final Color CANVAS_BACKGROUND = Color.CYAN;
  
  private DrawCanvas canvas; // the custom drawing canvas (extends JPanel)
  
  // the buttons
  JButton btnQ1, btnQ2, btnQ3, btnExit;
  
  int progToRun;
  
  // timer to update the screen
  Timer timer;
  public A6() {
    
    // update the screen every 50 milliseconds
    timer =  new Timer(50, this);
    progToRun = -1;
    
    // Set up a panel for the buttons
    JPanel btnPanel = new JPanel(null);
    btnPanel.setBackground(Color.WHITE);
    
    btnPanel.setPreferredSize(new Dimension(160, CANVAS_HEIGHT));
    
    btnQ1 = new JButton("Circle");
    btnPanel.add(btnQ1);
    btnQ1.addActionListener(this);
    btnQ1.setBounds(5, 300, 150, 30);
    
    
    btnQ2 = new JButton("Ruler");
    btnPanel.add(btnQ2);
    btnQ2.addActionListener(this); 
    btnQ2.setBounds(5, 350, 150, 30);
        
    btnQ3 = new JButton("Flower");
    btnPanel.add(btnQ3);
    btnQ3.addActionListener(this); 
    btnQ3.setBounds(5, 400, 150, 30);
    
    btnExit = new JButton("Exit");
    btnPanel.add(btnExit);
    btnExit.addActionListener(this); 
    btnExit.setBounds(5, 450, 150, 30);
        
    // Set up a custom drawing JPanel
    canvas = new DrawCanvas();
    canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
    
    // Add both panels to this JFrame
    Container cp = getContentPane();
    cp.setLayout(new BorderLayout());
    cp.add(canvas, BorderLayout.CENTER);
    cp.add(btnPanel, BorderLayout.EAST);
    
    // "this" JFrame fires KeyEvent

    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    // Handle the CLOSE button
    setTitle("Assignment 6");
    pack();           // pack all the components in the JFrame
    setVisible(true); // show it
    requestFocus();
    
  }
  
 public void actionPerformed(ActionEvent e)
  {
    // check if restart button was pressed
    if (e.getSource()== btnQ1)
    {    
      progToRun = 0;
    }
    // check if restart button was pressed
    else if (e.getSource()== btnQ2)
    {    
      progToRun = 1;
    }
    else if (e.getSource()== btnQ3)
    {    
      progToRun = 2;
    }
      
    // check if exit button was pressed
    else if (e.getSource()==btnExit)
    { 
      System.exit(0);
    }
    else if (e.getSource()== timer){
      canvas.repaint();
    }
  }

  /**
   * DrawCanvas (inner class) is a JPanel used for custom drawing
   */
  class DrawCanvas extends JPanel {
        
    int fHeight= CANVAS_HEIGHT ;
    int fWidth = CANVAS_WIDTH ;
    
    
    ////////////////////// ONLY MODIFY THE BODY OF THESE 3 METHODS BELOW  /////////////////////
    // Q1
    public void drawCircle(Graphics g, double radius, int num){
      // INCOMPLETE - Write a recursive method to draw concentric circles
      g.drawString("Draw Circles Program", 40, 70);
      // erase this message above
      
    }
    
    // Q2
    public void drawRuler(Graphics g, double x, double y, double w, double height){
      // INCOMPLETE - Write a recursive method to draw a ruler as described
       g.drawString("Draw Ruler Program", 40, 140);
        // erase the message above
    }
    
    // Q3
    public void drawFlower(Graphics g, double x1, double y1, int length, double angleRad, int level){
      // INCOMPLETE - Write a recursive method to the flower as described
      g.drawString("Draw Flower Program", 40, 210);
      // erase the message above
      
    }
     ////////////////////// ONLY MODIFY THE BODY OF THESE 3 METHODS ABOVE  /////////////////////
    
    public void paintComponent(Graphics g) {
      // erase the screen 
      super.paintComponent(g);
                
      setBackground(CANVAS_BACKGROUND); 
      
      // draw the desired program
      if (progToRun == 0){
        // Set initial radius of circle
        int radius = CANVAS_WIDTH/2;
        int num = 1;
        drawCircle(g, radius, num); 
      } 
     
      else if (progToRun == 1){
        // draw ruler      
        double h = CANVAS_HEIGHT/2;
        double w = CANVAS_WIDTH;
        double x = 0;
        double y = 0;       
        drawRuler( g,  x,  y,  w,  h);        
      }
       else if (progToRun == 2){
         // draw flower
         // Set initial startig location of one end of the branch (bottom middle)
         // indicate 5 levels of branches
         int levels = 5;
         int x1 = fWidth/2;
         int y1 = fHeight;
         int length = CANVAS_WIDTH/2;
         int y2 =  CANVAS_HEIGHT/2;
         double angleRad = -Math.PI/2;
         
         drawFlower(g, x1, y1, length, angleRad, levels);  
      }      
    }    
  }
  
    
  public static void main(String[] args)
  {    
    A6 prog = new A6();
    prog.timer.start();
  }
  
  
}