import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

public class PokemonApi {
  public static void main(String[] args) throws IOException {
    getAndPrintJapaneseName(1);
    getAndPrintJapaneseName(123);
  }

  public static void getAndPrintJapaneseName(final int id) throws IOException {
    final OkHttpClient client = new OkHttpClient();
    final Request request =
        new Request.Builder().url("https://pokeapi.co/api/v2/pokemon-species/" + id).build();
    try (final Response response = client.newCall(request).execute()) {
      final Gson gson = new Gson();
      final String json = response.body().string();
      final PokemonSpeciesResponse pokemonSpeciesResponse =
          gson.fromJson(json, PokemonSpeciesResponse.class);
      final String pokemonName =
          pokemonSpeciesResponse.names.stream()
              .filter(e -> e.language.isJapanese())
              .findFirst()
              .get()
              .name;
      final String flavorText =
          pokemonSpeciesResponse.flavor_text_entries.stream()
              .filter(e -> e.language.isJapanese())
              .findFirst()
              .get()
              .flavor_text;
      System.out.println(pokemonName);
      System.out.println(flavorText);
      System.out.println();
    } finally {
      client.connectionPool().evictAll();
    }
  }

  class PokemonSpeciesResponse {
    public ArrayList<FlavorTextEntries> flavor_text_entries;
    public ArrayList<LanguageAndName> names;
  }

  class FlavorTextEntries {
    public String flavor_text;
    public Language language;
  }

  class LanguageAndName {
    public Language language;
    public String name;
  }

  class Language {
    public String name;

    public boolean isJapanese() {
      return name.equals("ja");
    }
  }
}
