    @Test
    public void testPutAll_nullKeyInSmallAdditional() throws Exception {
        final SortedArrayStringMap original = new SortedArrayStringMap();
        original.putValue("a", "aORIG");
        original.putValue("b", "bORIG");
        original.putValue("c", "cORIG");
        original.putValue("d", "dORIG");
        original.putValue("e", "eORIG");

        final SortedArrayStringMap other = new SortedArrayStringMap();
        other.putValue(null, "nullNEW");
        other.putValue("1", "11");
        other.putValue("a", "aa");
        original.putAll(other);

        assertEquals("size after put other", 7, original.size());
        assertEquals("aa", original.getValue("a"));
        assertEquals("bORIG", original.getValue("b"));
        assertEquals("cORIG", original.getValue("c"));
        assertEquals("dORIG", original.getValue("d"));
        assertEquals("eORIG", original.getValue("e"));
        assertEquals("11", original.getValue("1"));
        assertEquals("nullNEW", original.getValue(null));
    }
