    @Override           
    protected Object getJobDataFromBlob(ResultSet rs, String colName)
        throws ClassNotFoundException, IOException, SQLException {
        if (canUseProperties()) {
            InputStream binaryInput = null;
            byte[] bytes = rs.getBytes(colName);
            if(bytes == null || bytes.length == 0) {
                return null;
            }
            binaryInput = new ByteArrayInputStream(bytes);
            return binaryInput;
        }
        return getObjectFromBlob(rs, colName);
    }
