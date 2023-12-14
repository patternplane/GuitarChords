import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChordViewer {
	public void start() {
		GuitarNotes guitar = new GuitarNotes(17);
		Note[][] guitarNotes = guitar.getAllNotes();
		
		Chord c;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		while (true) {
			try {
				input = br.readLine();
			} catch(Exception e) {
				input = "";
			}
			c = StringChordConverter.NoteChordtypeSeperator(input);
			if (c == null)
				System.out.println("non Chord");
			else
				printNotesByChord(guitarNotes,c);
		}
		
	}
	
	private void printNotesByChord(Note[][] guitarNotes,Chord c) {
		for (int i = 0; i < guitarNotes.length; i ++) {
			for (int j = 0; j < guitarNotes[0].length; j++)
				System.out.print((c.hasNote(guitarNotes[i][j])?"¡Ü":"¡Û") + guitarNotes[i][j] + "  ");
			System.out.println();
		}
	}
}
