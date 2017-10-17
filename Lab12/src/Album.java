import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Album {
	private String name;
	public ArrayList<Track> tracks = new ArrayList<Track>();
	
	public Album(String name, List<Track> tracks) {
		this.name = name;
		this.tracks.addAll(tracks);
	}

	public String getName() {
		return name;
	}
	
	public static List<Album> findFavs(List<Album> albums) {
		List<Album> favs = new ArrayList<>();
		albums.stream()
		.filter(album -> album.tracks.stream()
				.anyMatch(track -> track.getRating()>=4))
		.sorted(new Comparator<Album>() {
			public int compare(Album a1, Album a2) {
				return a1.name.compareTo(a2.name);
			}})
		.forEach(album -> favs.add(album));
		return favs;
	}
}
