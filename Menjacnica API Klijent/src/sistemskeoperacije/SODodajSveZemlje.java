package sistemskeoperacije;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import main.URLConnectionUtil;

public class SODodajSveZemlje {

	public static void izvrsi() {

		try {
			String podaci = URLConnectionUtil.getContent("http://free.currencyconverterapi.com/api/v3/countries");

			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			JsonObject jObject = gson.fromJson(podaci, JsonObject.class);

			try (FileWriter writer = new FileWriter("zemlje/zemlje.json")) {
				writer.write(gson.toJson(jObject));
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
