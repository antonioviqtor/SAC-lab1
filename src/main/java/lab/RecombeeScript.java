package lab;

import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.api_requests.*;
import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.exceptions.ApiException;
import com.recombee.api_client.util.Region;

import java.util.HashMap;
import java.util.List;

public class RecombeeScript {

    public static void main(String[] args) throws ApiException {
        RecombeeClient client = new RecombeeClient("universitatea-politehnica-bucuresti-dev", "Z5SkFBaVmpK7b7jvZIYP7Lzwy7emXVqJBxQ7YkHr5yjgVL1bJ97Im15ZPkVGiTzZ").setRegion(Region.EU_WEST);

        // client.send(new ResetDatabase());
       // addItemsToDatabase(client);
       // addUsers(client);
       // addInteractions(client);
       getUserRecommendation(client, "Iulia", 3);
       getUserRecommendation(client, "Dragos", 3);
       getUserRecommendation(client, "Consuela", 3);
       getUserRecommendation(client, "Marius", 3);
       getUserRecommendation(client, "Pisica", 3);
    }

    public static void addUsers(RecombeeClient client) {
        try {
            client.send(new AddUser("Iulia"));
            client.send(new AddUser("Dragos"));
            client.send(new AddUser("Consuela"));
            client.send(new AddUser("Marius"));
            client.send(new AddUser("Pisica"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void getUserRecommendation(RecombeeClient client, String userId, long number) {
        System.out.print(userId + ": ");
        try {
            Recommendation[] recommendations = client.send(new RecommendItemsToUser(userId, number)
                    .setReturnProperties(true)).getRecomms();
            for (var r : recommendations) {
                System.out.print(r.getValues().get("title") + "; ");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public static void addInteractions(RecombeeClient client) {
        try {
            client.send(new AddDetailView("Iulia", "s1"));
            client.send(new AddDetailView("Iulia", "s5"));
            client.send(new AddDetailView("Iulia", "s10"));
            client.send(new AddDetailView("Iulia", "s15"));
            client.send(new AddBookmark("Iulia", "s20"));

            client.send(new AddDetailView("Dragos", "s25"));
            client.send(new AddDetailView("Dragos", "s30"));
            client.send(new AddDetailView("Dragos", "s35"));
            client.send(new AddDetailView("Dragos", "s40"));
            client.send(new AddBookmark("Dragos", "s45"));

            client.send(new AddDetailView("Consuela", "s50"));
            client.send(new AddDetailView("Consuela", "s52"));
            client.send(new AddDetailView("Consuela", "s53"));
            client.send(new AddDetailView("Consuela", "s55"));
            client.send(new AddBookmark("Consuela", "s57"));

            client.send(new AddDetailView("Marius", "s60"));
            client.send(new AddDetailView("Marius", "s62"));
            client.send(new AddDetailView("Marius", "s63"));
            client.send(new AddDetailView("Marius", "s65"));
            client.send(new AddBookmark("Marius", "s66"));

            client.send(new AddDetailView("Pisica", "s70"));
            client.send(new AddDetailView("Pisica", "s74"));
            client.send(new AddDetailView("Pisica", "s77"));
            client.send(new AddDetailView("Pisica", "s79"));
            client.send(new AddBookmark("Pisica", "s99"));

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    public static void addItemsToDatabase(RecombeeClient client) {
        try {
            List<NetflixMovie> netflixMovies = NetflixMovieParser.parse();
            System.out.println(netflixMovies.get(0).getShowId());
            for (var movie : netflixMovies) {
                System.out.println(movie.toString());
            }

            addItemProperties(client);

            for (var movie : netflixMovies) {
                client.send(new SetItemValues(movie.getShowId(),
                        new HashMap<String, Object>() {{
                            put("genre", movie.getMovieType());
                            put("title", movie.getMovieTitle());
                            put("director", movie.getDirector());
                            put("country", movie.getCountry());
                            put("release_year", movie.getReleaseYear());
                            put("rating", movie.getRating());
                            put("listed_in", movie.getListedIn());
                            put("description", movie.getDescription());
                        }}
                ).setCascadeCreate(true));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void addItemProperties(RecombeeClient client) {
        try {
            client.send(new AddItemProperty("genre", "string"));
            client.send(new AddItemProperty("title", "string"));
            client.send(new AddItemProperty("director", "string"));
            client.send(new AddItemProperty("country", "string"));
            client.send(new AddItemProperty("release_year", "string"));
            client.send(new AddItemProperty("rating", "string"));
            client.send(new AddItemProperty("listed_in", "string"));
            client.send(new AddItemProperty("description", "string"));

        } catch (Exception exception) {
            System.out.println(exception.toString());
        }

    }
}
