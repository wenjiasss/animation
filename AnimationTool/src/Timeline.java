import java.util.ArrayList;

/**
 * This class represents a timeline that contains frames. The main feature of
 * this class is cycling through frames.
 * 
 * @author Sofia Violet
 * @version 4.0
 * @date 5.20.20
 *
 */
public class Timeline {
	
	// FIELDS
	private ArrayList<Frame> frames = new ArrayList<Frame>();

	// CONSTRUCTORS
	/**
	 * Creates a new Timeline with one Frame
	 */
	public Timeline() {
		frames.add(new Frame(0));
	}

	// METHODS

	/**
	 * Adds a new blank Frame to the end of the Timeline.
	 */
	public void addFrame() {
		frames.add(new Frame(frames.size()));
	}

	/**
	 * Adds a new, specified frame to the Timeline
	 * 
	 * @param f the new Frame to be added to the Timeline
	 */
	public void addFrame(Frame f) {
		frames.add(f);
	}

	/**
	 * Returns the Frame at the specified index of the Timeline
	 * 
	 * @param index the index of the Frame requested
	 * @return the Frame at the requested index
	 */
	public Frame getFrame(int index) {
		return frames.get(index);
	}

	/**
	 * Returns the index of the specified Frame.
	 * 
	 * @param f the Frame whose index is requested.
	 * @return the index of the Frame specified.
	 */
	public int getIndex(Frame f) {
		return frames.indexOf(f);

	}

	/**
	 * Returns an ArrayList of every Frame in the Timeline.
	 * 
	 * @return an ArrayList with every Frame in the Timeline.
	 */
	public ArrayList<Frame> getFrameList() {
		return frames;
	}

}
