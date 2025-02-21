package org.example.search.query

import org.jooq.Condition
import org.jooq.Field
import org.jooq.SortField

data class QueryCriteria(
    val offset: Int,
    val limit: Int,
    val filterModel: List<Condition>,
    val sortModel: List<SortField<Any>>,
    val valueColumns: List<Field<Any>>,
) {
    companion object {
        fun builder(): QueryCriteriaBuilder = QueryCriteriaBuilder()
    }
}
