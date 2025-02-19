package org.example.search.request

import java.io.Serializable

data class ColumnVO(
    var id: String? = null,
    var displayName: String? = null,
    var field: String? = null,
    var aggFunc: String? = null
) : Serializable