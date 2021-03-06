	@Override
	@SuppressWarnings({ "" })
	public <Y> Expression<Y> all(Subquery<Y> subquery) {
		return new SubqueryComparisonModifierExpression<Y>(
				this,
				(Class<Y>) subquery.getJavaType(),
				subquery,
				SubqueryComparisonModifierExpression.Modifier.ALL
		);
	}
