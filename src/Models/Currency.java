package Models;

import java.util.HashMap;

public record Currency(String base_code, HashMap<String, Float> conversion_rates) {
}
