    public static Boolean succeeds(Session session, Object[] a, Type[] ta,
                                   Object[] b, Type[] tb) {

        Type commonType = normalizeInput(session, a, ta, b, tb, false);

        if (commonType == null) {
            return null;
        }

        if (commonType.compare(session, a[0], b[1]) >= 0) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
