
public class Chord {
	private Note root;
	private ChordType type;
	private Note[] formingNotes;
	
	public Note[] chordElements() {
		return formingNotes.clone();
	}

	static public Note[] getChordElements(Note root, ChordType type) {
		switch (type) {
		case M:
			return new Note[] {
					root,
					NoteCalculator.ChangePitch(root, 4),
					NoteCalculator.ChangePitch(root, 7) 
					};
		case m:
			return new Note[] {
					root,
					NoteCalculator.ChangePitch(root, 3),
					NoteCalculator.ChangePitch(root, 7)
					};
		case _7:
			return new Note[] {
					root,
					NoteCalculator.ChangePitch(root, 4),
					NoteCalculator.ChangePitch(root, 7),
					NoteCalculator.ChangePitch(root, 10)
					};
		case M7:
			return new Note[] {
					root,
					NoteCalculator.ChangePitch(root, 4),
					NoteCalculator.ChangePitch(root, 7),
					NoteCalculator.ChangePitch(root, 11)
					};
		case m7:
			return new Note[] {
					root,
					NoteCalculator.ChangePitch(root, 3),
					NoteCalculator.ChangePitch(root, 7),
					NoteCalculator.ChangePitch(root, 10)
					};
		case mM7:
			return new Note[] {
					root,
					NoteCalculator.ChangePitch(root, 3),
					NoteCalculator.ChangePitch(root, 7),
					NoteCalculator.ChangePitch(root, 11)
					};
		default:
			return null;
		}
	}
	
	public boolean hasNote(Note note) {
		for (Note n : formingNotes)
			if (n == note)
				return true;
		return false;
	}

	public Chord(Note root, ChordType type) {
		changeChord(root,type);
	}
	
	public void changeChord(Note root, ChordType type) {
		this.root = root;
		this.type = type;
		this.formingNotes = getChordElements(root, type);
	}
}
