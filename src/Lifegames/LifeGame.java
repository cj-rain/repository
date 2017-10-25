package Lifegames;
import javax.swing.JFrame;
public class LifeGame extends JFrame{ 
	public static GameMap gamemap=new GameMap();
	LifeGame(){
		this.setSize(450,470);
		this.setTitle("…˙√¸”Œœ∑[LifeGame]DEMO2");
		this.add(gamemap);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setLocationRelativeTo(null);  
        this.setResizable(false);  
    } 
	public static void main(String[] args){  
		LifeGame game = new LifeGame();  
        game.setVisible(true);
        init();
    }  
	 public static void init (){
		 gamemap.setVisible(true); 
		 gamemap.init();
		 GameTimer.init(gamemap);
		// System.exit(0);
	 }
}
