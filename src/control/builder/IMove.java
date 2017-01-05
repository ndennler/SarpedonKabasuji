package control.builder;
/**
 * Interface for all moves
 * @author Drew
 *
 */
public interface IMove {

	/**
	 * Will undo a given move
	 * @return if the move can be undone
	 */
	public boolean undo();

	public void redo();
}
