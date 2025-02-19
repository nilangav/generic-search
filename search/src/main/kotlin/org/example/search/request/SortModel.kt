package org.example.search.request

import java.io.Serializable

data class SortModel(
    var colId: String? = null,
    var sort: String? = null
) : Serializable