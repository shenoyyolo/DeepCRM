    @Test
    public void testWarnStringParamSupplier() {
        logger2.disable().warn("abc {}", supplierArray1);
        assertTrue(logger2.list.isEmpty());
        assertFalse(supplier.invoked);

        logger2.enable().warn("abc {}", supplierArray1);
        assertEquals(1, logger2.list.size());
        assertTrue(supplier.invoked);

        final LogEvent event = logger2.list.get(0);
        assertEquals(Level.WARN, event.level);
        assertEquals("abc Hi", event.message.getFormattedMessage());
    }
