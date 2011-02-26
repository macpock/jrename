package com.googlecode.jrename.gui.model;


import javax.swing.JLabel;

import com.googlecode.jrename.gui.Resources;

public class TinyLabel extends JLabel {

	private static final long serialVersionUID = 1L;

	public TinyLabel(String label) {
		super(label);
		setFont(Resources.SMALL);
	}
	
}
