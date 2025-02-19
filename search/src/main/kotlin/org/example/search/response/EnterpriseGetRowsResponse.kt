package org.example.search.response

data class EnterpriseGetRowsResponse<T>(
    var data: List<T>,
    var lastRow: Int
)
