package org.example.search.filter

import org.example.search.enum.FilterType
import org.example.search.request.ColumnFilter
import org.example.search.request.NumberColumnFilter
import org.jooq.Condition
import org.jooq.Field

class NumberFilterCondition(
    override val filter: ColumnFilter,
) : FilterCondition() {
    override fun getDslCondition(
        filter: ColumnFilter,
        field: Field<Any>,
    ): Condition {
        filter as NumberColumnFilter
        return when (filter.type) {
            FilterType.EQUALS -> field.eq(filter.filter)
            else -> throw IllegalArgumentException("Invalid")
        }
    }
}
