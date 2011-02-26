package com.googlecode.jrename.gui.action;



import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.googlecode.jrename.gui.Resources;
import com.googlecode.jrename.ui.Command;
import com.googlecode.jrename.ui.RenameMediator;



public class UndoButton extends JButton implements Command {

	private static final long serialVersionUID = 1L;
	private RenameMediator med;

	public UndoButton(ActionListener al, RenameMediator m) {
		super(Resources.get("button.undo"));
		setEnabled(false);
		setOpaque(false);
		addActionListener(al);
        med = m;
        med.registerUndo(this);
	}
	
	public void execute() {
		med.undo();
	}

}
