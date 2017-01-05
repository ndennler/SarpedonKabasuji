package Moves;

import control.builder.IMove;
import entity.builder.IBuilderModel;
import entity.player.Hint;
import entity.player.Piece;


public class HintMove implements IMove {
	
	Hint aHint;
	IBuilderModel aModel;
	Piece aPiece;
	boolean add ;

public HintMove(IBuilderModel model, Hint hint){
	aHint = hint;
	aModel = model;
	aPiece = null;
	add = false;
}

public HintMove(IBuilderModel model, Piece adding, Hint removing) {
	aHint = removing;
	aModel = model;
	add = true;
}

@Override
public boolean undo() {
	if(!add){
		aModel.getHints().remove(aHint);
	}
	else{
		aModel.getHints().add(aHint);
	}
	return true;
	
}

@Override
public void redo() {
	if(add){
		aModel.getHints().remove(aHint);
	}
	else{
		aModel.getHints().add(aHint);
	}
	
	
}
}