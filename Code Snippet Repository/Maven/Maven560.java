    public ArtifactRepository createRepository( String url, String repositoryId, boolean releases,
                                                 String releaseUpdates, boolean snapshots, String snapshotUpdates,
                                                 String checksumPolicy ) throws Exception
    {
        ArtifactRepositoryPolicy snapshotsPolicy =
            new ArtifactRepositoryPolicy( snapshots, snapshotUpdates, checksumPolicy );

        ArtifactRepositoryPolicy releasesPolicy =
            new ArtifactRepositoryPolicy( releases, releaseUpdates, checksumPolicy );

        return createArtifactRepository( repositoryId, url, "default", snapshotsPolicy, releasesPolicy );
    }
