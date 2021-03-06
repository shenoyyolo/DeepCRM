	@Override
	@SuppressWarnings({ "" })
	public <N extends Number> Expression<N> diff(Expression<? extends N> expression1, Expression<? extends N> expression2) {
		if ( expression1 == null || expression2 == null ) {
			throw new IllegalArgumentException( "arguments to diff() cannot be null" );
		}

		final Class resultType = BinaryArithmeticOperation.determineResultType( expression1.getJavaType(), expression2.getJavaType() );

		return new BinaryArithmeticOperation<N>(
				this,
				resultType,
				BinaryArithmeticOperation.Operation.SUBTRACT,
				expression1,
				expression2
		);
	}
