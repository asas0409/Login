package Login;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class Main extends JFrame implements ActionListener{
	
	JLabel IDLabel = new JLabel("ID");
	JTextField IDTextField = new JTextField();
	JLabel PWLabel = new JLabel("PW");
	JPasswordField PWTextField = new JPasswordField();
	JButton Login = new JButton("Login");
	JButton SignUp = new JButton("SignUp");
	DBConnection connection = new DBConnection();
	makeAccount newAccount;
	
	public static void main(String[] args) {
		Main start = new Main();
	}
	
	//public void paint(Graphics g) {
		//g.drawImage(new ImageIcon(Main.class.getResource("../image/sky.png")).getImage(),0,0,null);
	//}
	
	Main(){
		setTitle("Login");
		setSize(600, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		IDLabel.setBounds(190,100,50,50);
		IDLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		IDTextField.setBounds(250,100,150,50);
		
		PWLabel.setBounds(190,180,50,50);
		PWLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		PWTextField.setBounds(250,180,150,50);
		PWTextField.setEchoChar('*');
		
		Login.setBounds(240,500,120,40);
		Login.addActionListener(this);
		
		SignUp.setBounds(240,540,120,40);
		SignUp.addActionListener(this);
		
		add(IDLabel);
		add(IDTextField);
		add(PWLabel);
		add(PWTextField);
		add(Login);
		add(SignUp);
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Login) {
			int result = connection.login(IDTextField.getText(),PWTextField.getText());
			if(result==1) {
				JOptionPane.showMessageDialog(null, "Login Success!!");
				dispose();
				new adminProgram();
				
			}else if(result == 0) {
				JOptionPane.showMessageDialog(null, "Login Success!!");
				dispose();
				new program();
			}
			else {
				JOptionPane.showMessageDialog(null, "ID 혹은 PW가 잘못되었거나 존재하지 않는 계정입니다.");
			}
		}else if(e.getSource()==SignUp) {
			newAccount = new makeAccount();
		}
		
	}
	
	class makeAccount extends JFrame implements ActionListener{
		
		JLabel newIDLabel = new JLabel("ID");
		JTextField newIDTextField = new JTextField();
		JLabel newPWLabel = new JLabel("PW");
		JPasswordField newPWTextField = new JPasswordField();
		JLabel PWRetypeLabel = new JLabel("PW 확인");
		JPasswordField PWRetypeTextField = new JPasswordField();
		JLabel newNameLabel = new JLabel("NAME");
		JTextField newNameTextField = new JTextField();
		JLabel newDOBLabel = new JLabel("DOB");
		JTextField newDOBTextField = new JTextField("0000-00-00");
		JLabel newPhoneLabel = new JLabel("PHONE");
		JTextField newPhoneTextField = new JTextField("000-0000-0000");
		JLabel newGenderLabel = new JLabel("GENDER");
		ButtonGroup gender = new ButtonGroup();
		JRadioButton male = new JRadioButton("남");
		JRadioButton female = new JRadioButton("여");
		JButton register = new JButton("REGISTER");
		JButton check = new JButton("중복 확인");
		boolean isExist = true;
		
		makeAccount(){
		setTitle("SignUp");
		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		

		newIDLabel.setBounds(100,50,60,50);
		newIDLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		newIDTextField.setBounds(160,50,150,50);
		
		newPWLabel.setBounds(100,100,60,50);
		newPWLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		newPWTextField.setBounds(160,100,150,50);
		
		PWRetypeLabel.setBounds(100,150,60,50);
		PWRetypeLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		PWRetypeTextField.setBounds(160,150,150,50);
		
		newNameLabel.setBounds(100,200,60,50);
		newNameLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		newNameTextField.setBounds(160,200,150,50);
		
		newDOBLabel.setBounds(100,250,60,50);
		newDOBLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		newDOBTextField.setBounds(160,250,150,50);
		
		newPhoneLabel.setBounds(100,300,60,50);
		newPhoneLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		newPhoneTextField.setBounds(160,300,150,50);
		

		newGenderLabel.setBounds(100,350,60,50);
		newGenderLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		male.setBounds(160,350,50,50);
		male.setSelected(true);
		male.setBackground(Color.white);
		
		female.setBounds(210,350,50,50);
		female.setBackground(Color.white);
		
		register.setBounds(200,420,100,30);
		register.addActionListener(this);
		
		check.setBounds(310,50,90,50);
		check.addActionListener(this);
		
		add(newIDLabel);
		add(newIDTextField);
		add(newPWLabel);
		add(newPWTextField);
		add(PWRetypeLabel);
		add(PWRetypeTextField);
		add(newNameLabel);
		add(newNameTextField);
		add(newDOBLabel);
		add(newDOBTextField);
		add(newPhoneLabel);
		add(newPhoneTextField);
		add(newGenderLabel);
		add(register);
		gender.add(male);
		gender.add(female);
		add(male);
		add(female);
		add(check);
		
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==register) {
				String ID = newIDTextField.getText();
				String PW = newPWTextField.getText();
				String PWCheck = PWRetypeTextField.getText();
				String Name = newNameTextField.getText();
				String DOB = newDOBTextField.getText();
				String Phone = newPhoneTextField.getText();
				String Gender = male.isSelected()?"남":"여";
				if(ID.equals("")) {
					JOptionPane.showMessageDialog(null, "사용할 ID를 입력하세요.");
				}else if(isExist) {
					JOptionPane.showMessageDialog(null, "입력하신 ID가 이미 존재하거나 ID 중복체크를 하지 않으셨습니다.");
				}else if(PW.equals("")) {
					JOptionPane.showMessageDialog(null, "사용할 비밀번호를 입력하세요.");
				}else if(!PW.equals(PWCheck)) {
					JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.");
				}else if(Name.equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
				}else if(DOB.equals("0000-00-00")) {
					JOptionPane.showMessageDialog(null, "생년월일을 입력하세요.");
				}else if(Phone.equals("000-0000-0000")) {
					JOptionPane.showMessageDialog(null, "전화번호를 입력하세요.");
				}else if(!DOB.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
					JOptionPane.showMessageDialog(null, "잘못된 날짜 형식입니다.");
				}else {
					if(connection.register(ID,PW,Name,DOB,Phone,Gender)) {
						JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다!");
					}else {
						JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
					}
					this.dispose();
				}
			}else if(e.getSource()==check) {
				if(connection.IDCheck(newIDTextField.getText())){
					JOptionPane.showMessageDialog(null, "이미 사용중인 ID입니다.");
				}else {
					JOptionPane.showMessageDialog(null, "사용 가능한 ID입니다!");
					isExist = false;
				}
			}
		}
	}
	
	class program extends JFrame implements ActionListener{
		JLabel welcome = new JLabel("USER ACCOUNT");
		JButton edit = new JButton("EDIT INFO");
		JButton delete = new JButton("DELETE ACCOUNT");
		JButton exit = new JButton("EXIT");
	
		
	    program(){
			setSize(500,500);
			setLayout(null);
			setLocationRelativeTo(null);
			setVisible(true);
			
			welcome.setBounds(200,0,100,50);
			
			edit.setBounds(150,100,200,50);
			edit.addActionListener(this);
			
			delete.setBounds(150,200,200,50);
			delete.addActionListener(this);
			
			exit.setBounds(150,300,200,50);
			exit.addActionListener(this);
			
			add(welcome);
			add(edit);
			add(delete);
			add(exit);
		}
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==edit) {

				ArrayList<String> userInfo = connection.getInfo(IDTextField.getText());
				
				new editScreen(userInfo.get(0),userInfo.get(1),userInfo.get(2),userInfo.get(3),userInfo.get(4),userInfo.get(5));
			}else if(e.getSource()==delete) {
				new deleteScreen();
				
			}else if(e.getSource()==exit) {
				dispose();
			}
			
		}
		
	}
	
	
	class editScreen extends JFrame implements ActionListener{
		
		JLabel newIDLabel = new JLabel("ID");
		JLabel newIDTextField = new JLabel();
		JLabel newPWLabel = new JLabel("PW");
		JLabel newPWTextField = new JLabel();
		JLabel adminApplyLabel = new JLabel("APPLY");
		JButton adminApply = new JButton("관리자 등록 신청");
		JLabel newNameLabel = new JLabel("NAME");
		JTextField newNameTextField = new JTextField();
		JLabel newDOBLabel = new JLabel("DOB");
		JTextField newDOBTextField = new JTextField();
		JLabel newPhoneLabel = new JLabel("PHONE");
		JTextField newPhoneTextField = new JTextField();
		JLabel newGenderLabel = new JLabel("GENDER");
		JLabel newGenderTextField = new JLabel();
		JButton edit = new JButton("EDIT");
		JButton changePW = new JButton("변경");
		
		editScreen(String ID,String PW, String Name, String DOB, String Phone ,String Gender){
		setTitle("Edit Information");
		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		

		newIDLabel.setBounds(100,50,50,50);
		newIDLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		newIDTextField.setBounds(160,50,150,50);
		newIDTextField.setText(ID);
		
		newPWLabel.setBounds(100,100,50,50);
		newPWLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		newPWTextField.setBounds(160,100,150,50);
		newPWTextField.setText("**********");
		
		adminApplyLabel.setBounds(100,150,50,50);
		adminApplyLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		adminApply.setBounds(160,150,150,50);
		adminApply.addActionListener(this);
		
		newNameLabel.setBounds(100,200,50,50);
		newNameLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		newNameTextField.setBounds(160,200,150,50);
		newNameTextField.setText(Name);
		
		newDOBLabel.setBounds(100,250,50,50);
		newDOBLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		newDOBTextField.setBounds(160,250,150,50);
		newDOBTextField.setText(DOB);
		
		newPhoneLabel.setBounds(100,300,50,50);
		newPhoneLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		newPhoneTextField.setBounds(160,300,150,50);
		newPhoneTextField.setText(Phone);

		newGenderLabel.setBounds(100,350,50,50);
		newGenderLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		newGenderTextField.setBounds(160,350,150,50);
		newGenderTextField.setBackground(Color.white);
		newGenderTextField.setText(Gender);
		
		changePW.setBounds(310,100,70,50);
		changePW.addActionListener(this);
		
		edit.setBounds(200,420,100,30);
		edit.addActionListener(this);
		
		add(newIDLabel);
		add(newIDTextField);
		add(newPWLabel);
		add(newPWTextField);
		add(adminApplyLabel);
		add(adminApply);
		add(newNameLabel);
		add(newNameTextField);
		add(newDOBLabel);
		add(newDOBTextField);
		add(newPhoneLabel);
		add(newPhoneTextField);
		add(newGenderLabel);
		add(newGenderTextField);
		add(edit);
		add(changePW);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==edit) {
				String PW = JOptionPane.showInputDialog("비밀번호를 입력하세요");
				if(PW.equals(PWTextField.getText())) {
					if(connection.update(newIDTextField.getText(),newNameTextField.getText(),newDOBTextField.getText(),newPhoneTextField.getText(),newGenderTextField.getText())==true) {
						JOptionPane.showMessageDialog(null, "정보가 수정되었습니다!");
						dispose();
					}
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호가 잘못되었습니다!");
				}
			}else if(e.getSource()==changePW) {
				new changePWScreen();
			}else if(e.getSource()==adminApply) {
				connection.adminApply(IDTextField.getText());
				JOptionPane.showMessageDialog(null, "관리자 등록 요청이 전송되었습니다.");
			}
		}
		
	}
	
	class deleteScreen extends JFrame implements ActionListener{
		JLabel message = new JLabel("비밀번호를 입력하세요.");
		JPasswordField PW = new JPasswordField();
		JButton OK = new JButton("확인");
		
		deleteScreen(){
			setSize(300,150);
			setTitle("Delete Account");
			setLocationRelativeTo(null);
			setLayout(null);
			setVisible(true);
			
			message.setBounds(0,0,200,50);
			
			PW.setBounds(0,50,200,50);
			
			OK.setBounds(200,50,80,50);
			OK.addActionListener(this);
			
			add(message);
			add(PW);
			add(OK);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==OK) {
				if(PW.getText().equals(PWTextField.getText())) {
					int confirm = JOptionPane.showConfirmDialog(null, "정말로 탈퇴하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
					if(confirm == JOptionPane.YES_OPTION) {
						if(connection.delete(IDTextField.getText())) {
							JOptionPane.showMessageDialog(null, "탈퇴되었습니다.");
							System.exit(0);
						}
					}else {
						JOptionPane.showMessageDialog(null, "취소되었습니다.");
					}
				}else {
					JOptionPane.showMessageDialog(null, "잘못된 비밀번호입니다.");
				}
				dispose();
			}
			
		}
		
	}
	
	class adminProgram extends JFrame implements ActionListener{
		JLabel welcome = new JLabel("ADMIN ACCOUNT");
		JButton edit = new JButton("EDIT INFO");
		JButton delete = new JButton("DELETE ACCOUNT");
		JButton manage = new JButton("MANAGE ACCOUNTS");
		JButton exit = new JButton("EXIT");
	
		
	    adminProgram(){
			setSize(500,500);
			setLayout(null);
			setLocationRelativeTo(null);
			setVisible(true);
			
			welcome.setBounds(150,0,200,50);
			welcome.setHorizontalAlignment(JLabel.CENTER);

			
			edit.setBounds(150,100,200,50);
			edit.addActionListener(this);
			
			delete.setBounds(150,200,200,50);
			delete.addActionListener(this);
			
			manage.setBounds(150,300,200,50);
			manage.addActionListener(this);
			
			exit.setBounds(150,400,200,50);
			exit.addActionListener(this);
			
			add(welcome);
			add(edit);
			add(delete);
			add(manage);
			add(exit);
		}
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==edit) {
				String PW = JOptionPane.showInputDialog("비밀번호를 입력하세요");
				ArrayList<String> userInfo = connection.getInfo(IDTextField.getText());
				if(PW==null) {
					JOptionPane.showMessageDialog(null, "취소되었습니다.");
				}else if(PW.equals(userInfo.get(1))) {
					new editScreen(userInfo.get(0),userInfo.get(1),userInfo.get(2),userInfo.get(3),userInfo.get(4),userInfo.get(5));
				}else {
					JOptionPane.showMessageDialog(null,"잘못된 비밀번호입니다.");
				}
			}else if(e.getSource()==delete) {
				new deleteScreen();
				
			}else if(e.getSource()==manage){
				ArrayList<ArrayList<String>> table = connection.getAllInfo();
				new manageScreen(table.size(),table);
			}else if(e.getSource()==exit) {
				dispose();
			}
			
		}
		
	}
	
	class changePWScreen extends JFrame implements ActionListener{
		JLabel PWLabel = new JLabel("PW"); 
		JPasswordField PWText = new JPasswordField();
		JLabel newPW = new JLabel("NEW PW"); 
		JPasswordField newPWTextField = new JPasswordField(); 
		JLabel newPWCheck = new JLabel("RETYPE PW");
		JPasswordField Check = new JPasswordField();
		JButton OK = new JButton("확인");

		changePWScreen(){
			setSize(300,200);
			setTitle("Change PW");
			setLayout(null);
			setLocationRelativeTo(null);
			setVisible(true);
			
			PWLabel.setBounds(0,0,75,40);
			
			PWText.setBounds(75,0,200,40);
			
			newPW.setBounds(0,40,75,40);
			
			newPWTextField.setBounds(75,40,200,40);
			
			newPWCheck.setBounds(0,80,75,40);
			
			Check.setBounds(75,80,200,40);
			
			OK.setBounds(125,120,60,50);
			OK.addActionListener(this);
			
			add(PWLabel);
			add(PWText);
			add(newPW);
			add(newPWTextField);
			add(newPWCheck);
			add(Check);
			add(OK);
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==OK) {
				if(PWText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
				}else if(this.newPWTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "새로 사용할 비밀번호를 입력하세요.");
				}else if(this.Check.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "새로 사용할 비밀번호를 한번 더 입력하세요.");
				}else if(!PWText.getText().equals(PWTextField.getText())){
					JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.");
				}else if(!this.newPWTextField.getText().equals(this.Check.getText())) {
					JOptionPane.showMessageDialog(null, "입력하신 새 비밀번호와 한번 더 입력한 비밀번호가 일치하지 않습니다.");
				}else {
					if(connection.changePW(IDTextField.getText(),newPWTextField.getText())) {
						JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.");
						PWTextField.setText(newPWTextField.getText());
						dispose();
					}
				}
			}
		}
		
	}
	
	class manageScreen extends JFrame implements ActionListener{
		String header[] = {"ID","PW","Name","DOB","Phone","Gender","isAdmin","adminApply"};
		JTable allData;
		JScrollPane a;
		JButton delete = new JButton("강제 탈퇴");
		JButton edit = new JButton("APPLY");
		
		manageScreen(int rows,ArrayList<ArrayList<String>> datas){
			String[][] contents = new String[rows][8];
			for(int i = 0; i<rows;i++) {
				for(int j=0;j<8;j++) {
					if(j==6) {
						if(datas.get(i).get(j)==null) {
							contents[i][j]="N";
						}else if(datas.get(i).get(j).equals("1")) {
							contents[i][j]="Y";
						}
						continue;
					}else if(j==7) {
						if(datas.get(i).get(j)==null) {
							contents[i][j] = datas.get(i).get(j);
						}else if(datas.get(i).get(j).equals("1")) {
							contents[i][j]="√";
						}
						continue;
					}
					contents[i][j] = datas.get(i).get(j);
				}
			}
			
			allData = new JTable(contents,header);

			setSize(700,500);
			setLayout(null);
			setLocationRelativeTo(null);
			//getContentPane().setBackground(Color.WHITE);
			setVisible(true);

			a = new JScrollPane(allData);
			a.setBounds(0,0,685,400);
			
			delete.setBounds(245,400,100,50);
			delete.addActionListener(this);
			
			edit.setBounds(355,400,100,50);
			edit.addActionListener(this);
			
			add(a);
			add(delete);
			add(edit);
			
	}
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==delete) {
				if(allData.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "데이터가 선택되지 않았습니다.");
				}else {
					int confirm = JOptionPane.showConfirmDialog(null, allData.getValueAt(allData.getSelectedRow(),0) + "님을 정말로 탈퇴시키겠습니까?","강제탈퇴",JOptionPane.YES_NO_OPTION );
					if(confirm == JOptionPane.YES_OPTION) {
						if(connection.delete(allData.getValueAt(allData.getSelectedRow(),0).toString())) {
							JOptionPane.showMessageDialog(null, "탈퇴되었습니다.");
							ArrayList<ArrayList<String>> temp = connection.getAllInfo();
							new manageScreen(temp.size(),temp);
							dispose();
						}
					}else {
						JOptionPane.showMessageDialog(null, "취소되었습니다.");
					}
				}
			}else if(e.getSource()==edit) {
				if(allData.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "데이터가 선택되지 않았습니다.");
				}else {
					int confirm = JOptionPane.showConfirmDialog(null, allData.getValueAt(allData.getSelectedRow(),0) + "님을 정보를 수정하시겠습니까?","정보수정",JOptionPane.YES_NO_OPTION );
					if(confirm == JOptionPane.YES_OPTION) {
						if(connection.adminRegister(allData.getValueAt(allData.getSelectedRow(),0).toString(),allData.getValueAt(allData.getSelectedRow(),6).toString())) {
							JOptionPane.showMessageDialog(null, "수정되었습니다.");
							ArrayList<ArrayList<String>> temp = connection.getAllInfo();
							new manageScreen(temp.size(),temp);
							dispose();
						}
					}else {
						JOptionPane.showMessageDialog(null, "취소되었습니다.");
					}
				}
			}
			
		}
	
	
}
}
