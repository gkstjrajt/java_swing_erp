package java_swing_erp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java_swing_erp.dto.Department;
import java_swing_erp.ui.component.DepartmentManagement;
import java_swing_erp.ui.component.StudentManagement;
import java_swing_erp.ui.component.content.DepartmentPanel;
import java_swing_erp.ui.component.table.DepartmentTable;

public class TestMain {
	public static void main(String[] args) {
//		test정규표현식적용();
		testDepartment();
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StudentManagement frame = new StudentManagement();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	@SuppressWarnings("unused")
	private static void test정규표현식적용() {
		String no = "ab";
		boolean isValid = Pattern.matches("\\d{1,3}", no);
		System.out.println(isValid);
		
		String name = "이현석";
		boolean isValidHan = Pattern.matches("^[가-힣]+$", name);
		System.out.println(isValidHan);
		
		String tel = "053-111-1111";
		boolean isValidTel = Pattern.matches("\\d{3}-\\d{3,4}-\\d{4}",tel);
		System.out.println(isValidTel);
	}

	public static void testDepartment() {
//	    test();
		DepartmentManagement dframe = new DepartmentManagement();
		dframe.setVisible(true);
//		JFrame frame = new JFrame();		// 기본 레이아웃은 borderlayout(동서남북)
//		frame.setSize(400, 400);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		DepartmentPanel sp = new DepartmentPanel();
//		frame.add(sp, BorderLayout.NORTH);	// 기본 center에 들어감
//		frame.setVisible(true);
//		
//		Department std = new Department(1, "경영학", "053-111-3333");
//		sp.setItem(std);
//		
//		JButton btn = new JButton("확인");	// borderlayout의 south에 추가
//		btn.addActionListener(new ActionListener() {
//			@Override						// callback method
//			public void actionPerformed(ActionEvent e) {
//				sp.getItem();
//				System.out.println(sp.getItem());
//			}
//		});
//		frame.add(btn, BorderLayout.EAST);
//		
//		
//		ArrayList<Department> itemList = new ArrayList<Department>();
//		itemList.add(new Department(1, "경영", "053-111-1111"));
//		itemList.add(new Department(2, "무역", "053-111-1111"));
//		
//	
//		DepartmentTable table = new DepartmentTable();
//		table.setItems(itemList);
//		
//		JScrollPane jp = new JScrollPane();
//		jp.setViewportView(table);
//		
//		frame.add(jp, BorderLayout.CENTER);
//		
//		Department tstd = new Department(3, "컴공", "053-221-1234");
//		itemList.add(tstd);
//		
//		table.addRow(tstd);
//		
////		table.removeRow(1);
////		itemList.remove(1);
//		
//		tstd.setName("컴퓨터공학");
//		tstd.setTel("053-444-4321");
//		
//		int searchIdx = itemList.indexOf(tstd);
//		
//		table.updateRow(searchIdx, tstd);
//		dframe.setVisible(true);
//		frame.setVisible(true);
	}
}
