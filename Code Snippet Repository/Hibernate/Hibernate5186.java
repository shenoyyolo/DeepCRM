	public <X> Calendar wrap(X value, WrapperOptions options) {
		if ( value == null ) {
			return null;
		}
		if ( Calendar.class.isInstance( value ) ) {
			return (Calendar) value;
		}

		if ( ! java.util.Date.class.isInstance( value ) ) {
			throw unknownWrap( value.getClass() );
		}

		Calendar cal = new GregorianCalendar();
		if ( Environment.jvmHasTimestampBug() ) {
			final long milliseconds = ( (java.util.Date) value ).getTime();
			final long nanoseconds = java.sql.Timestamp.class.isInstance( value )
					? ( (java.sql.Timestamp) value ).getNanos()
					: 0;
			cal.setTime( new Date( milliseconds + nanoseconds / 1000000 ) );
		}
		else {
			cal.setTime( (java.util.Date) value );
		}
		return cal;
	}
