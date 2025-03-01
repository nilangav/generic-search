package org.example.search.request

import org.example.search.request.filter.ColumnFilter

data class FilterRequest(
    var filterModel: Map<String, ColumnFilter>? = null,
)
