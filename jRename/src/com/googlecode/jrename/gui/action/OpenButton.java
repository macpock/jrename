package com.googlecode.jrename.gui.action;



import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.googlecode.jrename.gui.Resources;
import com.googlecode.jrename.ui.Command;
import com.googlecode.jrename.ui.RenameMediator;



public class OpenButton extends JButton implements Command {

	private static final long serialVersionUID = 1L;
	private RenameMediator med;

	public OpenButton(ActionListener al, RenameMediator m) {
		super(Resources.get("button.open"));
		setOpaque(false);
		addActionListener(al);
        med = m;
	}
	
	public void execute() {
		med.openFolder();
	}

}
