package com.atapiwrapper.library.api.model.geometry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LineGeometry extends Geometry{
	@JsonProperty("coordinates") private List<List<Float>> data;
}
