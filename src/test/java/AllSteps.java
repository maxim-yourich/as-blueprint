import com.bluep.api.PokeAPI;

public class AllSteps {
    private final PokeAPI pokeAPI = new PokeAPI();

    public String getPokes() {
        return pokeAPI.getPokes();
    }
}
