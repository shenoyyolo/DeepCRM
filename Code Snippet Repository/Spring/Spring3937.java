	@Test
	public void fixedDelayWithInitialDelaySubsequentExecution() {
		Date now = new Date();
		long period = 5000;
		long initialDelay = 30000;
		PeriodicTrigger trigger = new PeriodicTrigger(period);
		trigger.setInitialDelay(initialDelay);
		Date next = trigger.nextExecutionTime(context(now, 500, 3000));
		assertApproximateDifference(now, next, period + 3000);
	}
