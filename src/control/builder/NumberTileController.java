package control.builder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import entity.builder.BuildableRelease;
import entity.player.*;

import javax.swing.*;

import boundary.builder.BuilderBoardPanel;

public class NumberTileController implements MouseListener{

	JComboBox<Integer> number;
	JComboBox<String> color;
	JRadioButton addingNumbers;
	BuildableRelease level;
	BuilderBoardPanel boardView;
	/**
	 * Constructor for NumberTileController
	 * @param n - number
	 * @param c - color
	 * @param l - current level
	 * @param b - current board panel
	 * @param a - adding numbers button
	 */
	public NumberTileController(JComboBox<Integer> n, JComboBox<String> c, BuildableRelease l, BuilderBoardPanel b, JRadioButton a){
		number = n;
		color = c;
		level = l;
		boardView = b;
		addingNumbers = a;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		return;
	}
	/**
	 * handles adding a number and color to a selected tile
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if(addingNumbers.isSelected()){
			int num = number.getItemAt(number.getSelectedIndex());
			String c = color.getItemAt(color.getSelectedIndex());
			ReleaseTile t = (ReleaseTile) boardView.getTile(e.getPoint());

			if(t == null){return;}
			if(num == 0){t.setColor("None"); t.setNumber(0);}
			t.setColor(c);
			t.setNumber(num);
			
			boardView.redraw();
			boardView.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		return;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		return;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		return;
	}
}