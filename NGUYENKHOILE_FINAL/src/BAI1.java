import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class BAI1 {

	public JFrame f;
	public JTextField txtName,txtCity,txtPhone;
	public JButton btnInsert,btnReset;
	public DefaultTableModel model;
	public JTable jt;
	public JScrollPane sp;
	public String getName,getCity,getPhone;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BAI1 bai1=new BAI1();
	}
	public BAI1() {
		prepareGUI();
	}
	private void prepareGUI() {
		f=new JFrame("Register Form");
		JLabel lbl=new JLabel("info");
		lbl.setBounds(20,20,30,20);
		f.add(lbl);
		
		JLabel lblName=new JLabel("Name: ");
		lblName.setBounds(40,50,50,20);
		f.add(lblName);
		
		JLabel lblCity=new JLabel("City: ");
		lblCity.setBounds(40, 80,50,20 );
		f.add(lblCity);
		
		JLabel lblPhone=new JLabel("Phone: ");
		lblPhone.setBounds(40,110,50,20);
		f.add(lblPhone);
		
		txtName=new JTextField();
		txtName.setBounds(100,50,180,20);
		f.add(txtName);
		
		txtCity=new JTextField();
		txtCity.setBounds(100,80,180,20);
		f.add(txtCity);
		
		txtPhone=new JTextField();
		txtPhone.setBounds(100,110,180,20);
		f.add(txtPhone);
		
		btnInsert=new JButton("Insert");
		btnInsert.setBounds(100,140,80,25);
		f.add(btnInsert);
		
		btnReset=new JButton("Reset");
		btnReset.setBounds(200,140,80,25);
		f.add(btnReset);
		
		
		//Table
		String columns[]= {"Name","City","Phone"};
		String data[][]= {{"Le Khoi","Binh Thuan","0908569663"}};
		model=new DefaultTableModel (data,columns);
		jt=new JTable(model);
		sp=new JScrollPane(jt);
		sp.setBounds(20,200,290,250);
		f.add(sp);
		 
		
		//Validate number
		txtPhone.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {String value=txtPhone.getText();
			int l=value.length();
			if(ke.getKeyChar()>='0'&&ke.getKeyChar()<='9') {
				txtPhone.setEditable(true);;
			}else {
				txtPhone.setEditable(false);
			}
			}
		});
		
		//Add
		btnInsert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
		    {
		        String name=txtName.getText().toString();
		        String city=txtCity.getText().toString();
		        String phone=txtPhone.getText().toString();
				model.addRow(new Object[] {name,city,phone});
				JOptionPane.showMessageDialog(null, "Successfully Added");
		    }
		});
		
		
		//Clear
		btnReset.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e)
		    {	
		        txtName.setText(null);
		        txtCity.setText(null);
		        txtPhone.setText(null);
		        JOptionPane.showMessageDialog(null, "Succesfully Reset");
		    }
		});
		
		//Closing
		f.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent we) {
		        int result = JOptionPane.showConfirmDialog(f,
		            "Do you want to exit ?", "Warning",
		            JOptionPane.YES_NO_OPTION);
		        if (result == JOptionPane.YES_OPTION)
		          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        else 
		        	if
		        	(result == JOptionPane.NO_OPTION)
		          f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		      }
		      });
		
		f.setLayout(null);
		f.setSize(350,500);
		f.setVisible(true);
	}
}
