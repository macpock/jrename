package com.googlecode.jrename.gui.list.model;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class MiddleCellRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	public MiddleCellRenderer() {
		super();
	}

	// --- Center display
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		JLabel renderedLabel = (JLabel) super.getTableCellRendererComponent(
				table, value, isSelected, hasFocus, row, column);
		renderedLabel.setVerticalAlignment(SwingConstants.CENTER);
		return renderedLabel;
	}
}
