package com.googlecode.jrename.gui;


import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.googlecode.jrename.gui.action.ExitButton;
import com.googlecode.jrename.gui.action.RenameButton;
import com.googlecode.jrename.gui.action.UndoButton;
import com.googlecode.jrename.gui.model.BlueLabel;
import com.googlecode.jrename.gui.option.RestoreButton;
import com.googlecode.jrename.ui.RenameMediator;

import net.miginfocom.swing.MigLayout;

public class MenuPane extends JPanel {

	private static final long serialVersionUID = 1L;

	public MenuPane(ActionListener al, RenameMediator m) {
		super(new MigLayout("flowy", "5[]5", "5[]0[]10[][]20[][]push[]5"));
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY));
		JLabel title = new JLabel(Resources.get("application.name"));
		title.setFont(Resources.TITLE);
		JLabel version = new JLabel(Resources.get("application.version"));
		version.setFont(Resources.SMALL);
		
		JPanel libelles = new JPanel(new MigLayout("wrap 2, fillx", "[align right][]", ""));
		libelles.setOpaque(false);
		libelles.setBorder(Resources.createTitledBorder("title.shortcuts"));
		libelles.add(new JLabel(Resources.get("format.string.date.day")), "");
		libelles.add(new BlueLabel(Resources.get("format.date.day")), "");
		libelles.add(new JLabel(Resources.get("format.string.date.month")), "");
		libelles.add(new BlueLabel(Resources.get("format.date.month")), "");
		libelles.add(new JLabel(Resources.get("format.string.date.year")), "");
		libelles.add(new BlueLabel(Resources.get("format.date.year")), "");
		libelles.add(new JLabel(Resources.get("format.string.increment")), "");
		libelles.add(new BlueLabel(Resources.get("format.increment")), "");
		libelles.add(new JLabel(Resources.get("format.string.filename")), "");
		libelles.add(new BlueLabel(Resources.get("format.filename")), "");
		libelles.add(new JLabel(Resources.get("format.string.extension")), "");
		libelles.add(new BlueLabel(Resources.get("format.extension")), "");
		libelles.add(new JLabel(Resources.get("format.string.group")), "");
		libelles.add(new BlueLabel(Resources.get("format.group")), "");

		add(title, 						"alignx center");
		add(version, 					"alignx center");
		add(libelles, 					"alignx center");

		// --- Boutons
		add(new RestoreButton(al, m), 	"alignx center, sg 1");
		add(new UndoButton(al, m), 		"alignx center, sg 1");
		add(new RenameButton(al, m), 	"alignx center, sg 1");
		add(new ExitButton(al, m), 		"alignx center, sg 1");
		
		// --- Icon
//		ClassLoader cldr = this.getClass().getClassLoader();
//		java.net.URL imageURL   = cldr.getResource("logo.png");
//		ImageIcon icon = new ImageIcon(imageURL);
//		JLabel iconLabel = new JLabel(icon);
//		add(iconLabel);

	}
	
}
