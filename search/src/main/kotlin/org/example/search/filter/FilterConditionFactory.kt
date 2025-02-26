package org.example.search.filter

import org.example.search.request.ColumnFilter
import org.example.search.request.NumberColumnFilter

object FilterConditionFactory {
    fun getFilterCondition(filter: ColumnFilter): FilterCondition =
        when (filter) {
            is NumberColumnFilter -> NumberFilterCondition(filter)
            else -> throw IllegalArgumentException("Invalid")
        }
}
