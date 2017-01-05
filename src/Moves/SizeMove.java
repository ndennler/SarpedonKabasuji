package Moves;

import javax.swing.JComboBox;

import control.builder.IMove;
import entity.builder.IBuilderModel;
import entity.player.Tile;
/**
 * 
 * @author Drew
 *captures a change in the size of the board
 */
public class SizeMove implements IMove {
	int size;
	JComboBox<Integer> boardSize;
int redoSize;
	IBuilderModel model;

	public SizeMove(int start, IBuilderModel model, JComboBox<Integer> boardSize) {
		this.model = model;
		this.size = start;
		this.boardSize = boardSize;
	}
/**
 * undoes a change in the size of the board
 */
	public boolean undo() {
		//get the current tile array of the board
		Tile[][] boardShape = model.getBoard().getTileArray();
		int currsize = model.getBoard().getSize();
		redoSize = currsize;
		if (currsize == size )
		{
			System.out.print(size);
		}
		
		if(currsize < size){//when size requested is larger
			for(int i = 0; i<12; i++){
				for(int j = 0; j<12; j++){
					if(currsize < size && boardShape[i][j] == null){
						boardShape[i][j] = new Tile(i, j);
						currsize++;
					}
				}
			}
		}
		if(currsize > size){
			for(int i = 0; i<12; i++){
				for(int j = 0; j<12; j++){
					Tile t = boardShape[11-i][11-j];
					if(t != null){
					if(currsize > size && t.getCoveredBy() == null){
						boardShape[11-i][11-j] = null;
						currsize--;
					}
					}
				}
			}
		}
		 
		return true;
	}
@Override
public void redo() {
	//get the current tile array of the board
	Tile[][] boardShape = model.getBoard().getTileArray();
	int currsize = redoSize;
	if (currsize == size )
	{
		System.out.print(size);
	}
	if(currsize < size){//when size requested is larger
		for(int i = 0; i<12; i++){
			for(int j = 0; j<12; j++){
				if(currsize < size && boardShape[i][j] == null){
					boardShape[i][j] = new Tile(i, j);
					currsize++;
				}
			}
		}
	}
	if(currsize > size){
		for(int i = 0; i<12; i++){
			for(int j = 0; j<12; j++){
				Tile t = boardShape[11-i][11-j];
				if(t != null){
				if(currsize > size && t.getCoveredBy() == null){
					boardShape[11-i][11-j] = null;
					currsize--;
				}
				}
			}
		}
	}
	

	
}
}
