	@Test
	public void requestPart() {
		Mono<ClientResponse> result = webClient
				.post()
				.uri("/requestPart")
				.contentType(MediaType.MULTIPART_FORM_DATA)
				.body(BodyInserters.fromMultipartData(generateBody()))
				.exchange();

		StepVerifier
				.create(result)
				.consumeNextWith(response -> assertEquals(HttpStatus.OK, response.statusCode()))
				.verifyComplete();
	}
