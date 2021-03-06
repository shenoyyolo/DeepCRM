    public Object getLastDayOfMonth(Session session, Object dateTime) {

        TimestampData ts     = (TimestampData) dateTime;
        Calendar      cal    = session.getCalendarGMT();
        long          millis = (ts.getSeconds() + ts.getZone()) * 1000;

        HsqlDateTime.setTimeInMillis(cal, millis);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);

        millis = cal.getTimeInMillis();

        return new TimestampData(millis / 1000, 0, 0);
    }
