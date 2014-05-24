package com.atapiwrapper.library.api.model.geometry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown=true)
public class MultiLineGeometry extends Geometry{
	@JsonProperty("coordinates") private List<List<List<Double>>> data;
}
