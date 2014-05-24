package com.atapiwrapper.library.api.model.geometry;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Geometry returned by the server can be of different types determined by the type attribute. This is handled by a custom deserializerin
 * {@link com.atapiwrapper.library.api.AtApi}
 */
public abstract class Geometry {
	@JsonProperty("encoded") protected boolean encoded;
	@JsonProperty("type") protected String type;

	public boolean isEncoded() {
		return encoded;
	}

	public String getType() {
		return type;
	}
}
