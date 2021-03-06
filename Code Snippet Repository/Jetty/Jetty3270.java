    @Test(timeout=60000)
    @Ignore
    public void testNoBlockingTimeoutWrite() throws Exception
    {
        configureServer(new HugeResponseHandler());
        Socket client=newSocket(_serverURI.getHost(),_serverURI.getPort());
        client.setSoTimeout(10000);

        Assert.assertFalse(client.isClosed());

        OutputStream os=client.getOutputStream();
        BufferedReader is=new BufferedReader(new InputStreamReader(client.getInputStream(),StandardCharsets.ISO_8859_1),2048);

        os.write((
                "GET / HTTP/1.0\r\n"+
                "host: "+_serverURI.getHost()+":"+_serverURI.getPort()+"\r\n"+
                "connection: keep-alive\r\n"+
                "Connection: close\r\n"+
        "\r\n").getBytes("utf-8"));
        os.flush();
        
        // read the header
        String line=is.readLine();
        Assert.assertThat(line,Matchers.startsWith("HTTP/1.1 200 OK"));
        while(line.length()!=0)
            line=is.readLine();
        
        for (int i=0;i<(128*1024);i++)
        {
            if (i%1028==0)
            {
                Thread.sleep(20);
                // System.err.println("read "+System.currentTimeMillis());
            }
            line=is.readLine();
            Assert.assertThat(line,Matchers.notNullValue());
            Assert.assertEquals(1022,line.length());
        }
    }
