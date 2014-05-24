package com.atapiwrapper.library.api.model.geometry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MultiLineEncodedGeometry extends Geometry{
	@JsonProperty("coordinates") private List<String> data;
}
