import java.util.*;

class Pokemon {
    public int solution(int[] nums) {
        int pokemonCount = nums.length / 2;
        Map<Integer, Integer> pokemon = new HashMap<>();
        
        for (int num : nums) {
            pokemon.put(num, pokemon.getOrDefault(num, 0) + 1);
        }
        
        return pokemon.keySet().size() >= pokemonCount ? pokemonCount : pokemon.keySet().size();
    }
}
