package org.example.search.request

data class SetColumnFilter(
    var values: List<String>? = null,
) : ColumnFilter()
