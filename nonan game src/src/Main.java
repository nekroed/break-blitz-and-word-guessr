import java.awt.Color;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame obj=new JFrame();
		Gameplay gamePlay = new Gameplay();
		
		obj.setBounds(10, 10, 700, 600);
		obj.setTitle("Breakout Ball");		
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
                obj.setVisible(true);
		
	}

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
