    @Test
    public void testReplaceServletHandlerWithServlet() throws Exception
    {
        ServletContextHandler context = new ServletContextHandler();
        context.addServlet(TestServlet.class,"/test");
        context.setContextPath("/");
        _server.setHandler(context);
        _server.start();

        StringBuffer request = new StringBuffer();
        request.append("GET /test HTTP/1.0\n");
        request.append("Host: localhost\n");
        request.append("\n");

        String response = _connector.getResponse(request.toString());
        assertResponseContains("Test", response);

        context.stop();
        ServletHandler srvHnd = new ServletHandler();
        srvHnd.addServletWithMapping(HelloServlet.class,"/hello");
        context.setServletHandler(srvHnd);
        context.start();

        request = new StringBuffer();
        request.append("GET /hello HTTP/1.0\n");
        request.append("Host: localhost\n");
        request.append("\n");

        response = _connector.getResponse(request.toString());
        assertResponseContains("Hello World", response);
    }
