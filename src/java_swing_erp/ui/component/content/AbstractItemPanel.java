package java_swing_erp.ui.component.content;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public abstract class AbstractItemPanel<T> extends JPanel {
	public AbstractItemPanel() {
	}

	public abstract void setItem(T item);

	public abstract T getItem();

	boolean isTfEmpty() {
		for (Component c : getComponents()) {
			if (c instanceof JTextField) {
				if (((JTextField) c).getText().isEmpty()) {
					return true;
				}
			}
		}
		return false;
	}

	abstract boolean isValidTf();

	public void setTfEditable(boolean isEditable) {	
		for ( Component c : getComponents()) {
			if ( c instanceof JTextField) {
				((JTextField) c).setEditable(isEditable);
			}
		}
	}
		
	public void clearTf() {
		for (Component c : getComponents()) {
			if (c instanceof JTextField) {
				((JTextField) c).setText("");

			}
		}

	}

	public abstract void setEditableNoTf(boolean isEditable);
}
