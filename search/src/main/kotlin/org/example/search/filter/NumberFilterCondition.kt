package org.example.search.filter

import org.example.search.enum.FilterType
import org.example.search.request.filter.ColumnFilter
import org.example.search.request.filter.NumberColumnFilter
import org.jooq.Condition
import org.jooq.Field

class NumberFilterCondition(
    override val filter: ColumnFilter,
) : FilterCondition() {
    override fun getDslCondition(field: Field<Any>): Condition {
        filter as NumberColumnFilter
        return when (filter.type) {
            FilterType.EQUALS.value -> field.eq(filter.filter)
            FilterType.NOT_EQUALS.value -> field.ne(filter.filter)
            FilterType.GREATER_THAN.value -> field.gt(filter.filter)
            FilterType.GREATER_THAN_OR_EQUALS.value -> field.ge(filter.filter)
            FilterType.LESS_THAN.value -> field.lt(filter.filter)
            FilterType.LESS_THAN_OR_EQUALS.value -> field.le(filter.filter)
            FilterType.IN_RANGE.value -> field.between(filter.filter, filter.filterTo)
            else -> throw IllegalArgumentException("Invalid filter type ${filter.type}")
        }
    }
}
