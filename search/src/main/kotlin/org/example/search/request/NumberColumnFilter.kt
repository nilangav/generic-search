package org.example.search.request

data class NumberColumnFilter(
    var type: String? = null,
    var filter: Int? = null,
    var filterTo: Int? = null
) : ColumnFilter()