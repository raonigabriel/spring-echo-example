/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.waiamu.open.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class JsonPayload {
	
	public static final String PROTOCOL = "protocol";

	public static final String METHOD = "method";
	
	public static final String HEADERS = "headers";
	
	public static final String COOKIES = "cookies";
	
	public static final String PARAMETERS = "parameters";
	
	public static final String PATH = "path";
	
	public static final String BODY = "body";

	private final Map<String, Object> attributes = new HashMap<>();

	@JsonAnySetter
	public void set(String name, Object value) {
		attributes.put(name, value);
	}

	@JsonAnyGetter
	public Map<String, Object> getAttributes() {
		return attributes;
	}

}