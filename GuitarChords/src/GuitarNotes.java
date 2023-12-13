
public class GuitarNotes {
	static final Note[] START_NTOES =
		{
				Note.E,
				Note.B,
				Note.G,
				Note.D,
				Note.A,
				Note.E
		};
	static final int LINE_SIZE = 6;

	private Note[][] guitarNotes;
	private int fretSize;
	
	public GuitarNotes(int size) {
		fretSize = size;
		guitarNotes = new Note[LINE_SIZE][fretSize];
		
		for (int line = 0; line < LINE_SIZE; line++)
			for (int fret = 0; fret < fretSize; fret++)
				guitarNotes[line][fret] = NoteCalculator.ChangePitch(START_NTOES[line],fret); 
	}
	
	public Note[][] getAllNotes() {
		Note[][] copy = new Note[guitarNotes.length][guitarNotes[0].length];
		
		for (int line = 0; line < LINE_SIZE; line++)
			for (int fret = 0; fret < fretSize; fret++)
				copy[line][fret] = guitarNotes[line][fret];
		
		return copy;
	}
}
