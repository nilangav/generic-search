package org.example.search.filter

import org.example.search.request.filter.ColumnFilter
import org.example.search.request.filter.NumberColumnFilter
import org.example.search.request.filter.SetColumnFilter

object FilterConditionFactory {
    private val registry: MutableMap<Class<out ColumnFilter>, (ColumnFilter) -> FilterCondition> = hashMapOf()

    init {
        register(NumberColumnFilter::class.java) { filter -> NumberFilterCondition(filter as NumberColumnFilter) }
        register(SetColumnFilter::class.java) { filter -> SetFilterCondition(filter as SetColumnFilter) }
    }

    fun register(
        filterType: Class<out ColumnFilter>,
        creator: (ColumnFilter) -> FilterCondition,
    ) {
        registry[filterType] = creator
    }

    fun getFilterCondition(filter: ColumnFilter): FilterCondition =
        registry[filter.javaClass]?.invoke(filter)
            ?: throw IllegalArgumentException("No filter condition registered for ${filter.javaClass}")
}
