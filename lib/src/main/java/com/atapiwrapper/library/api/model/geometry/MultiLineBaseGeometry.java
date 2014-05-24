package com.atapiwrapper.library.api.model.geometry;

////@formatter:off
//@JsonTypeInfo(
//		use = JsonTypeInfo.Id.NAME,
//		include = JsonTypeInfo.As.PROPERTY,
//		property = "encoded")
//@JsonSubTypes({
//		@JsonSubTypes.Type(value = MultiLineGeometry.class, name = "false"),
//		@JsonSubTypes.Type(value = MultiLineEncodedGeometry.class, name = "true")})
////@formatter:on
//@JsonIgnoreProperties(ignoreUnknown=true)
public  class MultiLineBaseGeometry extends Geometry{
}
