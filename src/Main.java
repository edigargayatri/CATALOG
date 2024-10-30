

import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static class Root {
        int base;
        String value;

        Root(int base, String value) {
            this.base = base;
            this.value = value;
        }
    }

    static class TestCase {
        int n;
        int k;
        Map<Integer, Root> roots = new HashMap<>();
    }

    public static void main(String[] args) {
        try {
            // Updated the file path to include the 'testcases' directory
            TestCase testCase = parseJSON("testcases/testcase1.json");
            BigInteger secret = lagrangeInterpolation(testCase);
            System.out.println("The secret (constant term c) is: " + secret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Parsing JSON file to retrieve n, k, and (x, y) roots
    public static TestCase parseJSON(String filePath) throws IOException, JSONException {
        TestCase testCase = new TestCase();
        JSONTokener tokener = new JSONTokener(new FileReader(filePath));
        JSONObject obj = new JSONObject(tokener);

        // Read n and k values
        JSONObject keys = obj.getJSONObject("keys");
        testCase.n = keys.getInt("n");
        testCase.k = keys.getInt("k");

        // Read (x, y) roots with encoded bases
        for (String key : obj.keySet()) {
            if (key.equals("keys")) continue;
            int x = Integer.parseInt(key);
            JSONObject rootObj = obj.getJSONObject(key);
            int base = Integer.parseInt(rootObj.getString("base"));
            String value = rootObj.getString("value");
            testCase.roots.put(x, new Root(base, value));
        }

        return testCase;
    }

    // Decode y-value from a given base to decimal
    public static BigInteger decodeValue(int base, String value) {
        return new BigInteger(value, base);
    }

    // Lagrange interpolation to find the constant term c
    public static BigInteger lagrangeInterpolation(TestCase testCase) {
        BigInteger secret = BigInteger.ZERO;

        for (Map.Entry<Integer, Root> i : testCase.roots.entrySet()) {
            int xi = i.getKey();
            BigInteger yi = decodeValue(i.getValue().base, i.getValue().value);
            BigInteger term = yi;

            for (Map.Entry<Integer, Root> j : testCase.roots.entrySet()) {
                int xj = j.getKey();
                if (xi != xj) {
                    term = term.multiply(BigInteger.valueOf(xj))
                            .divide(BigInteger.valueOf(xj - xi));
                }
            }

            secret = secret.add(term);
        }

        return secret;
    }
}
