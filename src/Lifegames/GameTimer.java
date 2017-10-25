package Lifegames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
public class GameTimer {
	private static Timer timer;
	private final static int DELAY_TIME = 1000;

	public static void init(final GameMap lifegame) {
		timer = new Timer(DELAY_TIME, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cycle();
			}
			private void cycle() {
				// TODO Auto-generated method stub
				lifegame.game_cycle();
				lifegame.repaint();

			}
		});
		// ¿ªÆô¼ÆÊ±Æ÷
		timer.start();
	}

}
