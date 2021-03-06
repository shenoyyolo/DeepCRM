	@Test
	public void actualRequestCredentialsWithOriginWildcard() throws Exception {
		this.request.setMethod(HttpMethod.GET.name());
		this.request.addHeader(HttpHeaders.ORIGIN, "http://domain2.com");
		this.conf.addAllowedOrigin("*");
		this.conf.setAllowCredentials(true);

		this.processor.processRequest(this.conf, this.request, this.response);
		assertTrue(this.response.containsHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN));
		assertEquals("http://domain2.com", this.response.getHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN));
		assertTrue(this.response.containsHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS));
		assertEquals("true", this.response.getHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS));
		assertEquals(HttpServletResponse.SC_OK, this.response.getStatus());
	}
