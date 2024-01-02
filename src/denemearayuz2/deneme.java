package denemearayuz2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class deneme {
	

	

	public static void main(String[] args) {
		JFrame f= new JFrame();
		JLabel l1=new JLabel("Kullanıcı adı");
		l1.setBounds(150,50,200,50);
		JTextField t1=new JTextField();
		t1.setBounds(150,100,200,50);
		JButton b1=new JButton("Giriş");
		b1.setBounds(150,300,200,50);
		
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Btona tıklandı");
				f.setVisible(false);
				JFrame f2=new JFrame();
				JLabel l2=new JLabel(l1.getText());
				
				String kelime="dunya";
				JLabel Tahminedilecekkelime=new JLabel();
				
				f2.setSize(500, 500);
	            f2.setVisible(true);
			}
			
		});
			
		
		
		
		
		f.add(l1);
		f.add(t1);
		f.add(b1);
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
		
		
	}

}
