package org.example.search.request.filter

data class SetColumnFilter(
    var values: List<String>? = null,
) : ColumnFilter()
