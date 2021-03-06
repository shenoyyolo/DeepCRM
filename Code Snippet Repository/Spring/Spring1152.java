	@Test
	public void testBeanPostProcessorWithWrappedObjectAndCloseable() {
		DefaultListableBeanFactory lbf = new DefaultListableBeanFactory();
		RootBeanDefinition bd = new RootBeanDefinition(BeanWithCloseable.class);
		lbf.registerBeanDefinition("test", bd);
		lbf.addBeanPostProcessor(new BeanPostProcessor() {
			@Override
			public Object postProcessBeforeInitialization(Object bean, String beanName) {
				return new TestBean();
			}
			@Override
			public Object postProcessAfterInitialization(Object bean, String beanName) {
				return bean;
			}
		});
		BeanWithDisposableBean.closed = false;
		lbf.preInstantiateSingletons();
		lbf.destroySingletons();
		assertTrue("Destroy method invoked", BeanWithCloseable.closed);
	}
