package org.example.search.filter

import org.example.search.request.filter.ColumnFilter
import org.example.search.request.filter.SetColumnFilter
import org.jooq.Condition
import org.jooq.Field

class SetFilterCondition(
    override val filter: ColumnFilter,
) : FilterCondition() {
    override fun getDslCondition(field: Field<Any>): Condition {
        filter as SetColumnFilter
        return field.`in`(filter.values)
    }
}
