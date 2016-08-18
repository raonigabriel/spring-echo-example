/*
 * Copyright 2016 the original author or authors.
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
package com.waiamu.open;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class SpringEchoApp {

	private static final Logger LOG = LoggerFactory.getLogger(SpringEchoApp.class); 

	@Autowired
	private HttpServletRequest request;

	public static void main(String[] args) {
		SpringApplication.run(SpringEchoApp.class, args);
		LOG.info("Live and kicking!!");
	}

	@RequestMapping(value = "/**", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
		method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
	public ResponseEntity<Map<String, Object>> echoBack(@RequestBody(required = false) byte[] rawBody) throws IOException {

		Map<String, String> headers = new HashMap<String, String>();
		for (String headerName : Collections.list(request.getHeaderNames())) {
			headers.put(headerName, request.getHeader(headerName));
		}

		Map<String, Object> responseMap = new HashMap<String,Object>();
		responseMap.put("protocol", request.getProtocol());
		responseMap.put("method", request.getMethod());
		responseMap.put("headers", headers);
		responseMap.put("cookies", request.getCookies());
		responseMap.put("parameters", request.getParameterMap());
		responseMap.put("path", request.getServletPath());
		responseMap.put("body", rawBody != null ? Base64.getEncoder().encodeToString(rawBody) : null);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
	}	
}