    public void testAppendIteratorDisposeItselfFromComponentStack() throws Exception {
        TextFieldTag t = new TextFieldTag();
        t.setPageContext(pageContext);
        t.setName("textFieldName");

        AppendIteratorTag tag = new AppendIteratorTag();
        tag.setPageContext(pageContext);

        try {
            t.doStartTag();
            tag.doStartTag();
            assertEquals(tag.getComponent().getComponentStack().peek(), tag.getComponent());
            tag.doEndTag();
            assertEquals(t.getComponent().getComponentStack().peek(), t.getComponent());
            t.doEndTag();
        }
        catch(Exception e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }
