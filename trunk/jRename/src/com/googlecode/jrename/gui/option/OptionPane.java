package com.googlecode.jrename.gui.option;



import java.awt.LayoutManager;

import javax.swing.JPanel;

import com.googlecode.jrename.gui.Resources;

import net.miginfocom.swing.MigLayout;

public class OptionPane extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public OptionPane(String title) {
		super(new MigLayout());
		setBorder(Resources.createTitledSeparator(title));
	}

	public OptionPane(LayoutManager layout, String title) {
		super(layout);
		setBorder(Resources.createTitledSeparator(title));
	}
	
}
