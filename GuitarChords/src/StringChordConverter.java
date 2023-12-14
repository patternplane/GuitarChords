
class NotePair {
	public Note note;
	public String str;
	public NotePair(Note note, String str) {
		this.note = note;
		this.str = str;
	}
}

class ChordTypePair {
	public ChordType type;
	public String str;
	public ChordTypePair(ChordType chordType, String str) {
		this.type = chordType;
		this.str = str;
	}
}
	
public class StringChordConverter {
	
	private static final NotePair[] NOTE_PAIRS = {
			new NotePair(Note.A,"A"),
			new NotePair(Note.Ap,"A#"),
			new NotePair(Note.B,"B"),
			new NotePair(Note.C,"C"),
			new NotePair(Note.Cp,"C#"),
			new NotePair(Note.D,"D"),
			new NotePair(Note.Dp,"D#"),
			new NotePair(Note.E,"E"),
			new NotePair(Note.F,"F"),
			new NotePair(Note.Fp,"F#"),
			new NotePair(Note.G,"G"),
			new NotePair(Note.Gp,"G#")			
	};
	
	private static final ChordTypePair[] CHORD_TYPE_PAIRS = {
			new ChordTypePair(ChordType.M, ""),
			new ChordTypePair(ChordType._7, "7"),
			new ChordTypePair(ChordType.M7, "M7"),
			new ChordTypePair(ChordType.m, "m"),
			new ChordTypePair(ChordType.m7, "m7"),
			new ChordTypePair(ChordType.mM7, "mM7")
	};
	
	public static Chord NoteChordtypeSeperator(String chord) {
		String[] ChordPair = new String[2];
		
		if (chord.length() < 2) {
			ChordPair[0] = new String(chord);
			ChordPair[1] = "";
		}
		else if (chord.charAt(1) == '#') {
			ChordPair[0] = chord.substring(0,2);
			ChordPair[1] = chord.substring(2,chord.length());
		}
		else {
			ChordPair[0] = chord.substring(0,1);
			ChordPair[1] = chord.substring(1,chord.length());
		}
		
		Note root = makeNoteByString(ChordPair[0]);
		ChordType type = makeChordTypeByString(ChordPair[1]);
		
		if (root == null || type == null)
			return null;
		return new Chord(root,type);
	}
	
	public static Note makeNoteByString(String s) {
		for (NotePair notePair : NOTE_PAIRS)
			if (s.compareTo(notePair.str) == 0)
				return notePair.note;
		return null;
	}
	
	public static ChordType makeChordTypeByString(String s) {
		for (ChordTypePair chordTypePair : CHORD_TYPE_PAIRS)
			if (s.compareTo(chordTypePair.str) == 0)
				return chordTypePair.type;
		return null;
	}
}
