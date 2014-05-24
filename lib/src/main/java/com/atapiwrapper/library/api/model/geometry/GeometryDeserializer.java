package com.atapiwrapper.library.api.model.geometry;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class GeometryDeserializer extends JsonDeserializer<Geometry> {

	@Override public Geometry deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);

		String type = node.path("type").asText();
		boolean encoded = node.path("encoded").asBoolean();

		switch (type) {
		case "line":
			return oc.treeToValue(node, LineGeometry.class);
		case "polygon":
			return oc.treeToValue(node, PolygonGeometry.class);
		case "point":
			return oc.treeToValue(node, PointGeometry.class);
		case "multiline":
			if (encoded) return oc.treeToValue(node, MultiLineEncodedGeometry.class);
			else return oc.treeToValue(node, MultiLineGeometry.class);
		default:
			throw new IllegalArgumentException("Unknown geometry type");
		}

	}
}
