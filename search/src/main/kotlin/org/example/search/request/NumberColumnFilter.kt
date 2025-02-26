package org.example.search.request

import org.example.search.enum.FilterType

data class NumberColumnFilter(
    var type: FilterType? = null,
    var filter: Int? = null,
    var filterTo: Int? = null,
) : ColumnFilter()
