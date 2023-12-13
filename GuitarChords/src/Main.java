
public class Main {

	public static void main(String[] args) {
		GuitarNotes a = new GuitarNotes(12);
		Note[][] b = a.getAllNotes();
		
		Chord c = new Chord(Note.D, ChordType.M);
		
		for (int i = 0; i < b.length; i ++) {
			for (int j = 0; j < b[0].length; j++)
				System.out.print((c.hasNote(b[i][j])?"¡Ü":"¡Û") + b[i][j] + "  ");
			System.out.println();
		}
	}

}
