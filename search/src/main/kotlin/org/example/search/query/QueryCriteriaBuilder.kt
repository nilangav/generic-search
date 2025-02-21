package org.example.search.query

import org.jooq.Condition
import org.jooq.Field
import org.jooq.SortField

class QueryCriteriaBuilder {
    private var offset: Int = 0
    private var limit: Int = Int.MAX_VALUE
    private var filterModel: List<Condition> = mutableListOf()
    private var sortModel: List<SortField<Any>> = mutableListOf()
    private var valueColumns: List<Field<Any>> = mutableListOf()

    fun offset(startRow: Int) =
        apply {
            this.offset = startRow
        }

    fun limit(
        startRow: Int,
        endRow: Int,
    ) = apply {
        this.limit = (endRow - startRow).coerceAtLeast(0)
    }

    fun build(): QueryCriteria = QueryCriteria(offset, limit, filterModel, sortModel, valueColumns)
}
