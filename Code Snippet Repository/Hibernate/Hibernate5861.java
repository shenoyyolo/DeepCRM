    @Test
    @TestForIssue(jiraKey = "")
    public void singleAttributeNodeInheritanceTest() {
        EntityManager em = getOrCreateEntityManager();
        em.getTransaction().begin();

        Bar bar = new Bar();
        em.persist(bar);

        Foo foo = new Foo();
        foo.bar = bar;
        em.persist( foo );

        em.getTransaction().commit();
        em.clear();

        em.getTransaction().begin();

        EntityGraph<Foo> entityGraph = em.createEntityGraph( Foo.class );
        entityGraph.addSubgraph( "bar" );

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put( "javax.persistence.loadgraph", entityGraph );

        Foo result = em.find( Foo.class, foo.id, properties );

        assertTrue( Hibernate.isInitialized( result ) );
        assertTrue( Hibernate.isInitialized( result.bar ) );

        em.getTransaction().commit();
        em.close();
    }
