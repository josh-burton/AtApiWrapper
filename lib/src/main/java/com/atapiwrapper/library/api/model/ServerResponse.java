package com.atapiwrapper.library.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServerResponse<T> {
	public static final String STATUS_OK = "OK";

	//successful response properties
	@JsonProperty("response") private T response;
	@JsonProperty("status") private String status;
	@JsonProperty("error") private Error error;

	//error response properties
	@JsonProperty("meta") private Meta meta;
	@JsonProperty("results") private Results results;

	public T getResponse() {
		return response;
	}

	public String getStatus() {
		return status;
	}

	public Error getError() {
		if (null != error) return error;
		if (null != results) return results.error;
		return null;
	}

	public Meta getMeta() {
		return meta;
	}

	//todo: better way to determine this?
	public boolean isSucess() {
		return null != status && status.equals(STATUS_OK);
	}

	public static class Meta {
		@JsonProperty("version") private String version;
		@JsonProperty("status_code") private String statusCode;

		public String getVersion() {
			return version;
		}

		public String getStatusCode() {
			return statusCode;
		}
	}

	public static class Results {
		@JsonProperty("error") private Error error;

		public Error getError() {
			return error;
		}
	}

	public static class Error {
		@JsonProperty("type") private String type;
		@JsonProperty("message") private String message;

		public String getType() {
			return type;
		}

		public String getMessage() {
			return message;
		}
	}

}
