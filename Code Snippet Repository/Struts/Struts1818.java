    public void testGetIndexWithParams() throws Exception {
        req.setupGetRequestURI("/my/namespace/bar/1/foo/");
        req.setupGetServletPath("/my/namespace/bar/1/foo/");
        req.setupGetAttribute(null);
        req.addExpectedGetAttributeName("javax.servlet.include.servlet_path");
        req.setupGetMethod("GET");

        ActionMapping mapping = mapper.getMapping(req, configManager);

        assertEquals("/my/namespace", mapping.getNamespace());
        assertEquals("foo/", mapping.getName());
        assertEquals("index", mapping.getMethod());
        assertEquals(1, mapping.getParams().size());
        assertEquals("1", mapping.getParams().get("bar"));
    }
