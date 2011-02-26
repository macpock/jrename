package com.googlecode.jrename.gui.option.output;


import javax.swing.JTextField;
import javax.swing.event.CaretListener;

import com.googlecode.jrename.bean.Option;
import com.googlecode.jrename.gui.Resources;
import com.googlecode.jrename.ui.Command;
import com.googlecode.jrename.ui.RenameMediator;



public class OutputString extends JTextField implements Command, Option {

	private static final long serialVersionUID = 1L;
	private RenameMediator med;
	private String defaultValue;

	public OutputString(CaretListener cl, RenameMediator m) {
		super(Resources.get("format.filename")+"."+Resources.get("format.extension"));
		defaultValue = getText();
		addCaretListener(cl);
        med = m;
        med.registerOption(this);
        execute();
	}
	
	public void execute() {
		med.setResultString(getText());
	}

	public void restoreDefault() {
		setText(defaultValue);
		execute();
	}

}
