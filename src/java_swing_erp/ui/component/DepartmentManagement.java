package java_swing_erp.ui.component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java_swing_erp.dto.Department;
import java_swing_erp.ui.component.content.DepartmentPanel;
import java_swing_erp.ui.component.table.DepartmentTable;

@SuppressWarnings("serial")
public class DepartmentManagement extends JFrame implements ActionListener {

	private JButton btnCancel;
	private DepartmentTable table;
	private ArrayList<Department> itemList = new ArrayList<Department>();
	private DepartmentPanel pDepartment;
	private JPanel pBtns;
	private JPanel pTable;
	private JButton btnAdd;
	private JScrollPane scrollPane;

	public DepartmentManagement() {
		
		initComponents();
		
		Department item = new Department(1, "기가학과", "053-508-9600");
		pDepartment.setItem(item);
		
		itemList.add(new Department(1, "기본학과", "053-508-9600"));
		itemList.add(new Department(2, "기기학과", "053-1508-9600"));
		itemList.add(new Department(3, "기종학과", "053-2508-9600"));
		table.setItems(itemList);
		
	}
	
	private void initComponents() {
		setTitle("학과 관리 프로그램");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		
		pDepartment = new DepartmentPanel();
		getContentPane().add(pDepartment, BorderLayout.NORTH);
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	
		pBtns = new JPanel();
		getContentPane().add(pBtns);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnCancel= new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
		
		pTable = new JPanel();
		getContentPane().add(pTable);
		pTable.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pTable.add(scrollPane, BorderLayout.CENTER);
		
		table = new DepartmentTable();
		scrollPane.setViewportView(table);
		table.setVisible(true);
			
		CustomPopupMenu popMenu = new CustomPopupMenu(this);
		table.setComponentPopupMenu(popMenu);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			if (e.getSource() == btnCancel) {
				actionPerformedBtnCancel(e);
			}
			if (e.getSource() == btnAdd) {
				if ( e.getActionCommand().equals("추가")) {
					actionPerformedBtnAdd(e);
				}else {
					actionPerformedBtnUpdate();
				}
				
			}
		}
		if ( e.getSource() instanceof JMenuItem) {
			if (e.getActionCommand().equals("수정")) {
				ActionPerformedMenuUpdate();
			}
			if (e.getActionCommand().equals("삭제")) {
				ActionPerformedMenudelete();
			}
			if (e.getActionCommand().equals("세부 정보")) {
				ActionPerformedMenuDetail();
			}
		}
	}
	
//	public void actionPerformed(ActionEvent e) {
////		System.out.println(e);
//		if (e.getSource() instanceof JButton) {
//			if (e.getSource() == btnCancel) {
//				actionPerformedBtnCancel(e);
//			}
//			if (e.getSource() == btnAdd) {
//				if ( e.getActionCommand().equals("추가")) {
//					actionPerformedBtnAdd(e);
//				}else {
//					actionPerformedBtnUpdate();
//				}
//				
//			}
//		}
//		if ( e.getSource() instanceof JMenuItem) {
//			if (e.getActionCommand().equals("수정")) {
//				ActionPerformedMenuUpdate();
//			}
//			if (e.getActionCommand().equals("삭제")) {
//				ActionPerformedMenudelete();
//			}
//			if (e.getActionCommand().equals("세부 정보")) {
//				ActionPerformedMenuDetail();
//			}
//		}
//	}

	public void actionPerformedBtnUpdate() {
		// 1. DepartmentPanel에서 수정된 학생정보를 가져옴
		// 2. itemList에서 학생정보 수정
		// 3. DepartmentTable에서 학생정보 수정
		// 4. clearTf()
		// 5. DepartmentPanel setEditableTf(true)
		// 6. btnAdd 텍스트를 "추가"로 변경
		// 7. message()
		Department updatedItem = pDepartment.getItem();
		int idx = itemList.indexOf(updatedItem);
		itemList.set(idx, updatedItem);
		table.updateRow(idx, updatedItem);
		pDepartment.clearTf();
		pDepartment.setEditableNoTf(true);
		btnAdd.setText("추가");
		JOptionPane.showMessageDialog(null, String.format("%s ( %d ) 수정 완료!", updatedItem.getName(), updatedItem.getNo()));
	}

	private void ActionPerformedMenuUpdate() {
//		System.out.println("수정");
		int selIdx = table.getSelectedRow();
		if ( selIdx == -1 ) {
			JOptionPane.showMessageDialog(null, "해당 항복을 선택하세요.");
			return;
		}
		Department selItem = itemList.get(selIdx);
		pDepartment.setItem(selItem);
		// 1. 버튼 텍스트를 수정으로 변경
		// 2. pStudent 학번은 변경 불가능하게
		btnAdd.setText("수정");
		pDepartment.setEditableNoTf(false);
		
	}

	private void ActionPerformedMenudelete() {
//		System.out.println("삭제");
		int selIdx = table.getSelectedRow();
		if ( selIdx == -1 ) {
			JOptionPane.showMessageDialog(null, "해당 항복을 선택하세요.");
			return;
		}
		Department deleteStd = itemList.remove(selIdx);
		table.removeRow(selIdx);
		JOptionPane.showMessageDialog(null, String.format("%s ( %d ) 삭제 완료!", deleteStd.getName(), deleteStd.getNo()));
	}

	private void ActionPerformedMenuDetail() {
//		System.out.println("세부 정보");
		int selIdx = table.getSelectedRow();
		if ( selIdx == -1 ) {
			JOptionPane.showMessageDialog(null, "해당 항복을 선택하세요.");
			return;
		}
		Department detailItem = itemList.get(selIdx);
		System.out.println(detailItem);
	}

	public void actionPerformedBtnAdd(ActionEvent e) {
		// 1. StudentPanel 에서 getStudent()
		// 2. StudentTable addRow()
		// 3. StudentPanel ClearTf()
		// 4. Message()

		Department newItem = pDepartment.getItem();
		table.addRow(newItem);
		pDepartment.clearTf();
		JOptionPane.showMessageDialog(null, String.format("%s ( %d ) 추가 완료!", newItem.getName(), newItem.getNo()));
		itemList.add(newItem);
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		pDepartment.clearTf();
		if ( btnAdd.getText().equals("수정")) {
			btnAdd.setText("추가");
			pDepartment.setEditableNoTf(true);
			table.clearSelection();
		}
	}

	public class CustomPopupMenu extends JPopupMenu {

		public CustomPopupMenu(ActionListener listener) {
			JMenuItem updateMenu = new JMenuItem("수정");
			updateMenu.addActionListener(listener);
			add(updateMenu);
			JMenuItem deleteMenu = new JMenuItem("삭제");
			deleteMenu.addActionListener(listener);
			add(deleteMenu);
			JMenuItem detailMenu = new JMenuItem("세부 정보");
			detailMenu.addActionListener(listener);
			add(detailMenu);
		}

	}

	

}
