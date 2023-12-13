
public class NoteCalculator {
	static public Note ChangePitch(Note origin, int amount) {
		return Note.values()[
		                     (origin.ordinal() + amount)
		                     %Note.values().length
		                     ];
	}
}
