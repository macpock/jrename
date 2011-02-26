package com.googlecode.jrename.gui.option.generic;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

import com.googlecode.jrename.bean.Option;
import com.googlecode.jrename.ui.Command;
import com.googlecode.jrename.ui.RenameMediator;



public class OptionSpinner extends JSpinner implements Command, Option {

	private static final long serialVersionUID = 1L;
	private RenameMediator med;
	private String option;
	private int defaultValue;

	public OptionSpinner(ChangeListener cl, RenameMediator m, int start, int min, String opt) {
		super(new SpinnerNumberModel(start, min, Integer.MAX_VALUE, 1));
		option = opt;
		defaultValue = start;
		((JTextField)((JSpinner.DefaultEditor)getEditor()).getTextField()).setColumns(4);
		addChangeListener(cl);
        med = m;
        med.registerOption(this);
        execute();
	}
	
	public void execute() {
		med.setOption(getValue(), option, int.class);
	}

	public void restoreDefault() {
		setValue(defaultValue);
		execute();
	}

}
