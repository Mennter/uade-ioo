package helpers;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class ZonedDateTimeJsonDeserializer implements JsonDeserializer<ZonedDateTime> {

	@Override
	public ZonedDateTime deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2)
			throws JsonParseException {
		return ZonedDateTime.parse(arg0.getAsString());
	}
   
}
