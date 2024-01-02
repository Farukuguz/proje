package denemearayuz2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class kural extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kural frame = new kural();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public kural() {
		setTitle("Oyun Kuralları");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 606, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrkullancAdBo = new JTextArea();
		txtrkullancAdBo.setForeground(new Color(0, 0, 0));
		txtrkullancAdBo.setEnabled(false);
		txtrkullancAdBo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrkullancAdBo.setText("                                       OYUN BİLGİLERİ\r\n\r\n1-Kullanıcı adı boş olamaz.\r\n2-Kelimelerin tamamı yazılım alanı ile ilgilidir.\r\n3-Başlangıçta 5 hak verilir.Her yanlış tahminde hak bir azalır.\r\n4-Kelimenin tamamını veya tek bir harfi tahmin edebilirsin.\r\n5-Doğru tahmin yapıldığında yeni kelimeye geçilir.\r\n6-Yanlış harfler aşşağıda gösterilir.Tekrar o harflerden biri yazıldığında hak azalmaz.\r\n7-Her kelime için bir ipucu hakkı vardır.\r\n8-Tahmin hakkı kalmadığında skor veri tabanına gönderilir oyun biter.\r\n\r\n                                           BAŞARILAR:)");
		txtrkullancAdBo.setBounds(10, 11, 571, 258);
		contentPane.add(txtrkullancAdBo);
		
	}
}
