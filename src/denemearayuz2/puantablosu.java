package denemearayuz2;

import java.awt.Component;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class puantablosu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Veritabanibaglant veritabani;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					puantablosu frame = new puantablosu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public puantablosu(Veritabanibaglant veritabani) {
		this.veritabani=veritabani;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 481, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Skor Tablosu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(50, 11, 92, 37);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textArea.setEnabled(false);
		textArea.setBounds(48, 48, 329, 272);
		contentPane.add(textArea);
		puanbilgisi(textArea);
		

	
		
	}
	public void puanbilgisi(JTextArea textArea) {
		String t = " Ad\t Skor\n";
		String QU="SELECT id,adi,skor FROM skorkaydi";
		try {
			Statement st=this.veritabani.con.createStatement();
			ResultSet rs= st.executeQuery(QU);
			while(rs.next()) {
				t += rs.getString("adi")+"\t"+rs.getString("skor")+"\n";
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		textArea.setText(t);
	}
}
