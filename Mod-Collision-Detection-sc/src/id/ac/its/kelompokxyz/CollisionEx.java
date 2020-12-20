package id.ac.its.kelompokxyz;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class CollisionEx extends JFrame {
	private static final long serialVersionUID = 1L;

	public CollisionEx() {
		initUI();
	}
	
	private void initUI() {
		
		add(new Board());
		setResizable(false);
		pack();
		
		setTitle("Collision");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            CollisionEx ex = new CollisionEx();
            ex.setVisible(true);
        });
	}
	
}
