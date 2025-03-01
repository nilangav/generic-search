package org.example.search.query

import org.example.search.filter.FilterConditionFactory
import org.example.search.request.SortModel
import org.example.search.request.filter.ColumnFilter
import org.jooq.Condition
import org.jooq.Field
import org.jooq.SortField
import org.jooq.SortOrder
import org.jooq.impl.DSL

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

    fun filterModel(filterModel: Map<String, ColumnFilter>) =
        apply {
            this.filterModel = filterModel.map(::mapFilter)
        }

    fun sortModel(sortModel: List<SortModel>) =
        apply {
            this.sortModel = sortModel.map(::mapSort)
        }

    private fun mapFilter(entry: Map.Entry<String, ColumnFilter>): Condition =
        FilterConditionFactory
            .getFilterCondition(entry.value)
            .getCondition(DSL.field(entry.key))

    private fun mapSort(sortModel: SortModel): SortField<Any> =
        if (SortOrder.DESC.toString().equals(sortModel.sort, ignoreCase = true)) {
            DSL.field(sortModel.colId).desc()
        } else {
            DSL.field(sortModel.colId).asc()
        }

    fun build(): QueryCriteria = QueryCriteria(offset, limit, filterModel, sortModel, valueColumns)
}
