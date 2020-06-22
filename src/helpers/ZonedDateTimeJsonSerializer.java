package helpers;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ZonedDateTimeJsonSerializer implements JsonSerializer<ZonedDateTime> {

	@Override
	public JsonElement serialize(ZonedDateTime arg0, Type arg1, JsonSerializationContext arg2) {
		return new JsonPrimitive(arg0.toString());
	}

}
