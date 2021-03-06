    public void testSimpleThemeImageUsingActionAndMethod() throws Exception {
        TestAction testAction = (TestAction) action;
        testAction.setFoo("bar");

        SubmitTag tag = new SubmitTag();
        tag.setPageContext(pageContext);
        tag.setTheme("simple");
        tag.setType("button");
        tag.setName("myname");
        tag.setLabel("mylabel");
        tag.setAction("manager");
        tag.setMethod("update");

        tag.doStartTag();
        tag.doEndTag();

        verify(TextFieldTag.class.getResource("Submit-7.txt"));
    }
