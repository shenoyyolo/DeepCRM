    public boolean calendarIsReferenced(Connection conn, String calendarName)
        throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(SELECT_REFERENCED_CALENDAR));
            ps.setString(1, calendarName);
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }
