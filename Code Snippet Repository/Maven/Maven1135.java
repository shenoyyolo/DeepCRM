    public void testBuildParentVersionRangeExternallyWithoutChildVersion() throws Exception
    {
        File f1 =
            getTestFile(
                "src/test/resources/projects/parent-version-range-external-child-without-version/pom.xml" );

        try
        {
            this.getProjectFromRemoteRepository( f1 );
            fail( "Expected 'ProjectBuildingException' not thrown." );
        }
        catch ( final ProjectBuildingException e )
        {
            assertNotNull( e.getMessage() );
            assertTrue( e.getMessage().contains( "Version must be a constant" ) );
        }
    }
