	@Test
	public void defaultReaders() throws Exception {
		List<HttpMessageReader<?>> readers = this.configurer.getReaders();
		assertEquals(12, readers.size());
		assertEquals(ByteArrayDecoder.class, getNextDecoder(readers).getClass());
		assertEquals(ByteBufferDecoder.class, getNextDecoder(readers).getClass());
		assertEquals(DataBufferDecoder.class, getNextDecoder(readers).getClass());
		assertEquals(ResourceDecoder.class, getNextDecoder(readers).getClass());
		assertStringDecoder(getNextDecoder(readers), true);
		assertEquals(FormHttpMessageReader.class, readers.get(this.index.getAndIncrement()).getClass());
		assertEquals(SynchronossPartHttpMessageReader.class, readers.get(this.index.getAndIncrement()).getClass());
		assertEquals(MultipartHttpMessageReader.class, readers.get(this.index.getAndIncrement()).getClass());
		assertEquals(Jaxb2XmlDecoder.class, getNextDecoder(readers).getClass());
		assertEquals(Jackson2JsonDecoder.class, getNextDecoder(readers).getClass());
		assertEquals(Jackson2SmileDecoder.class, getNextDecoder(readers).getClass());
		assertStringDecoder(getNextDecoder(readers), false);
	}
