import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TestLab12 {

	public static void main(String[] args) {
		//Testing trimming list of strings
		List<String> list = Arrays.asList("  A ", "B   ", "C", "    D", "\nE");
		list = TrimStringsInList.trimStrings(list);
		list.stream()
		.forEach(e -> System.out.print(e));
		System.out.println();
		
		//Testing printing male names from roster
		ArrayList<Person> roster = new ArrayList<Person>();
		roster.add(new Person("Alice", Person.Sex.FEMALE));
		roster.add(new Person("Bob", Person.Sex.MALE));
		roster.add(new Person("Charles", Person.Sex.MALE));
		roster.add(new Person("Darrin", Person.Sex.MALE));
		roster.add(new Person("Eliza", Person.Sex.FEMALE));
		roster.add(new Person("Fara", null));
		PrintMales.printMales(roster);
		
		//Test finding fav albums
		ArrayList<Album> albums = new ArrayList<Album>();
		albums.add(new Album("5 Star Hits", 
				Arrays.asList(new Track("Cool Jams", 5), 
						new Track("Sweet Sounds", 5), 
						new Track("'Mazing Melodies", 5))));
		albums.add(new Album("Mixed Ratings", 
				Arrays.asList(new Track("Popular Pianos", 5), 
						new Track("Average Autotune", 3), 
						new Track("Terrible Tones", 1))));
		albums.add(new Album("On Clearance", 
				Arrays.asList(new Track("Boring Banjos", 2), 
						new Track("Harmful Harmonies", 1), 
						new Track("Mr Bone's Wild Song", 1))));
		List<Album> favs = Album.findFavs(albums);
		favs.stream()
		.forEach(album -> System.out.println(album.getName()));
	}

}
