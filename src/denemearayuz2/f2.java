package denemearayuz2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class f2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	public char[] tahminarray;
	public ArrayList<String> yanlistahminler = new ArrayList<String>();
	public Integer Kalantahminsayisi = 5;
	public boolean Oyundurumu = false;
	public Veritabanibaglant veritabani = new Veritabanibaglant();
	public String[] kelimeler={"java","programlama","oop","yazılım","python","algoritma","mysql","gui"};
	private JButton ipucuLabel;
	private boolean ipucuVerildi = false;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					f2 frame = new f2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public f2(String name, Integer skor) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("İsim:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(31, 11, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(name);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(62, 11, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Kelime");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(77, 62, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setToolTipText("Tahmin Edilecek Kelime");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(153, 53, 132, 33);
		contentPane.add(lblNewLabel_3);
		String kelime = rastgelekelime();
		tahminarray = Kelimeolustur(kelime);
		lblNewLabel_3.setText(new String(tahminarray));

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setToolTipText("Kelime Giriniz");
		textField.setBounds(77, 161, 105, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton tahmin = new JButton("Tahmin Et");
		tahmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tahmin.setBounds(208, 160, 132, 23);
		contentPane.add(tahmin);
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setBounds(77, 217, 263, 55);
		contentPane.add(lblNewLabel_5);
		JLabel lblNewLabel_6 = new JLabel("Kalan Tahmin Sayısı:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(77, 133, 142, 20);
		contentPane.add(lblNewLabel_6);
		JLabel lblNewLabel_4 = new JLabel("Tahminler");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(77, 192, 64, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(371, 79, 132, 47);
		contentPane.add(lblNewLabel_10);
		
		ipucuLabel = new JButton("");
		ipucuLabel.setToolTipText("İpucu");
		ipucuLabel.setIcon(new ImageIcon("C:\\Users\\faruk\\OneDrive\\Masaüstü\\Magnifying-Glass-icon.png"));
		ipucuLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        ipucuLabel.setBounds(381, 144, 55, 47); 
        contentPane.add(ipucuLabel);
        ipucuLabel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ipucuOlustur(kelime);
				if(!ipucuVerildi) {
					lblNewLabel_10.setText(" İpucu: "+ ipucuOlustur(kelime));
					ipucuVerildi = true;
				}
				else
					lblNewLabel_10.setText("İpucu zaten verildi");
				    
			}
        	
        });
        
		JButton yenikelime = new JButton("Yeni Kelime");
		yenikelime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		yenikelime.setBounds(77, 283, 123, 25);
		contentPane.add(yenikelime);
		yenikelime.setVisible(false);
		yenikelime.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sifirla(name, skor);

			}

		});

		JLabel lblNewLabel_7 = new JLabel(Kalantahminsayisi.toString());
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(229, 136, 23, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Skor:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(321, 11, 46, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel(skor.toString());
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(361, 11, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JButton puantablo = new JButton("Puan Tablosu");
		puantablo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		puantablo.setBounds(371, 284, 123, 24);
		contentPane.add(puantablo);
		
		
		
		
		
		puantablo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame skorekrani= new puantablosu(veritabani);
				skorekrani.setVisible(true);
				
			}
			
		});
		tahmin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String bosluksuztahmin = textField.getText().trim();
				if (!bosluksuztahmin.isEmpty() && !yanlistahminler.contains(bosluksuztahmin)) {
					if (bosluksuztahmin.length() == 1) {
						if (kelimedeara(tahminarray, bosluksuztahmin, kelime)) {
							tahminarray = harfdegistir(tahminarray, bosluksuztahmin, kelime);
							lblNewLabel_3.setText(new String(tahminarray));
							if (!new String(tahminarray).contains("*")) {
								Oyundurumu = true;
								oyunubitir(lblNewLabel_3, kelime, yenikelime, tahmin);

							}

						} else {
							yanlistahminler.add(bosluksuztahmin);
							String tahminler = tahmineekle(bosluksuztahmin, lblNewLabel_5.getText());
							lblNewLabel_5.setText(tahminler);
							Kalantahminsayisi -= 1;
							lblNewLabel_7.setText(Kalantahminsayisi.toString());
							if (Kalantahminsayisi == 0) {
								oyunubitir(lblNewLabel_3, kelime, yenikelime, tahmin);

							}
						}
					} else {
						if (bosluksuztahmin.equals(kelime)) {
							Oyundurumu = true;
							oyunubitir(lblNewLabel_3, kelime, yenikelime, tahmin);
						} else {
							yanlistahminler.add(bosluksuztahmin);
							String tahminler = tahmineekle(bosluksuztahmin, lblNewLabel_5.getText());
							lblNewLabel_5.setText(tahminler);
							Kalantahminsayisi -= 1;
							lblNewLabel_7.setText(Kalantahminsayisi.toString());
							if (Kalantahminsayisi == 0) {
								oyunubitir(lblNewLabel_3, kelime, yenikelime, tahmin);

							}
						}
					}

				}
				textField.setText("");

			}
			

		});

	}

	public char[] Kelimeolustur(String kelime) {

		char[] tahminArray = new char[kelime.length()];
		for (int i = 0; i < kelime.length(); i++) {
			tahminArray[i] = '*';
		}
		return tahminArray;

	}

	public boolean kelimedeara(char[] tahminarray, String bosluksuztahmin, String kelime) {
		for (int i = 0; i < tahminarray.length; i++) {
			if (kelime.charAt(i) == bosluksuztahmin.charAt(0)) {
				return true;
			}

		}
		return false;
	}

	public char[] harfdegistir(char[] tahminarray, String bosluksuztahmin, String kelime) {
		for (int i = 0; i < tahminarray.length; i++) {
			if (kelime.charAt(i) == bosluksuztahmin.charAt(0)) {
				tahminarray[i] = bosluksuztahmin.charAt(0);
			}

		}
		return tahminarray;
	}

	public String tahmineekle(String bosluksuztahmin, String tahminler) {
		tahminler += "- " + bosluksuztahmin;
		return tahminler;
	}

	public void oyunubitir(JLabel dogrukelimelabel, String kelime, JButton btnNewButton1, JButton btnNewButton) {
		if (Oyundurumu) {
			dogrukelimelabel.setText(kelime);
			JOptionPane.showMessageDialog(this, "Tebrikler. Sonraki Kelimeye Geçebilirsiniz.");
			btnNewButton1.setVisible(true);
			btnNewButton.setVisible(false);

		} else {
			dogrukelimelabel.setText(kelime);
			JOptionPane.showMessageDialog(this, "Oyunu Kaybettiniz");
			btnNewButton1.setVisible(true);
			btnNewButton.setVisible(false);

		}

	}

	public void sifirla(String name, Integer skor) {
		if (Oyundurumu) {
			this.setVisible(false);
			JFrame f3 = new f2(name, ++skor);
			f3.setVisible(true);
		} else {

			try {
				String sql2 = "INSERT INTO Skorkaydi(adi,skor) VALUES (?,?)";
				PreparedStatement st = veritabani.getCon().prepareStatement(sql2);
				st.setString(1, name);
				st.setInt(2, skor);
				

				st.executeUpdate();
				this.setVisible(false);
				JFrame f3 = new f2(name, 0);
				f3.setVisible(true);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

			
		}
		
	}
	public String rastgelekelime() {
		int random=(int)(Math.random() * kelimeler.length);
		String secilenKelime = kelimeler[random ];
		return secilenKelime;

	}
	private String ipucuOlustur(String kelime) {
		StringBuilder ipucu = new StringBuilder();
        Random random = new Random();
        int rastgeleIndeks = random.nextInt(kelime.length()); 

        
        for (int i = 0; i < kelime.length(); i++) {
            if (i == rastgeleIndeks) {
                ipucu.append(kelime.charAt(i)); 
            } 
        }
        return ipucu.toString();
    }
    

}
