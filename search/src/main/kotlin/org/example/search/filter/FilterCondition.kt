package org.example.search.filter

import org.example.search.enum.JoinOperator
import org.example.search.request.filter.ColumnFilter
import org.jooq.Condition
import org.jooq.Field

abstract class FilterCondition {
    abstract val filter: ColumnFilter

    fun getCondition(field: Field<Any>): Condition =
        if (filter.operator != null && filter.operator != null) {
            when (filter.operator) {
                JoinOperator.OR -> joinByOr(filter.conditions!!, field)
                JoinOperator.AND -> joinByAnd(filter.conditions!!, field)
                else -> throw IllegalArgumentException("Invalid")
            }
        } else {
            getDslCondition(field)
        }

    abstract fun getDslCondition(field: Field<Any>): Condition

    private fun joinByAnd(
        conditions: List<ColumnFilter>,
        field: Field<Any>,
    ): Condition {
        TODO("Not yet implemented")
    }

    private fun joinByOr(
        conditions: List<ColumnFilter>,
        field: Field<Any>,
    ): Condition {
        TODO("Not yet implemented")
    }
}
