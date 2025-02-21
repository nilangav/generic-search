package org.example.search.request

data class FilterRequest(
    var filterModel: Map<String, ColumnFilter>? = null,
)
