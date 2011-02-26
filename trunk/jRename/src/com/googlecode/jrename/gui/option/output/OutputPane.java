package com.googlecode.jrename.gui.option.output;


import java.util.EventListener;

import javax.swing.event.CaretListener;

import com.googlecode.jrename.gui.option.OptionPane;
import com.googlecode.jrename.ui.RenameMediator;

import net.miginfocom.swing.MigLayout;

public class OutputPane extends OptionPane {

	private static final long serialVersionUID = 1L;

	public OutputPane(EventListener el, RenameMediator m) {
		super(new MigLayout("fillx", "0[]0", "[]"), "title.output");
		OutputString output = new OutputString((CaretListener) el, m);
		add(output, "growx");
	}
		
	
}
