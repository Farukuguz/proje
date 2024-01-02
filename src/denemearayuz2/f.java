package denemearayuz2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class f extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					f frame = new f();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public f() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 395);
		contentPane = 	new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel isim = new JLabel("Oyunucu Adı");
		isim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		isim.setHorizontalAlignment(SwingConstants.CENTER);
		isim.setBounds(173, 84, 121, 27);
		contentPane.add(isim);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setToolTipText("Boş Olamaz");
		textField.setBounds(160, 135, 146, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton basla = new JButton("Oyuna Başla");
		basla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		basla.setBounds(160, 201, 146, 23);
		contentPane.add(basla);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(136, 166, 170, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton kural = new JButton("Oyun Kuralları");
		kural.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kural.setBounds(160, 249, 146, 23);
		contentPane.add(kural);
		kural.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame kurallar=new kural();
				kurallar.setVisible(true);
				
				
				
			}
			
		});
		
		basla.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!textField.getText().equals("")) {
				setVisible(false);
				JFrame f2=new f2(textField.getText(),0);
				f2.setVisible(true);
			}else {
				lblNewLabel_1.setText("Kullanıcı Adı Boş Olamaz");
			}
				
				}
			
		});
	}
}
