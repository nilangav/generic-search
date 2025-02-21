package org.example.search.request

import java.io.Serializable

class GenericRequest(
    var startRow: Int = 0,
    var endRow: Int = 0,
    var rowGroupCols: List<ColumnVO> = emptyList(),
    var valueCols: List<ColumnVO> = emptyList(),
    var pivotCols: List<ColumnVO> = emptyList(),
    var isPivotMode: Boolean = false,
    var groupKeys: List<String> = emptyList(),
    var filterModel: Map<String, ColumnFilter> = emptyMap(),
    var sortModel: List<SortModel> = emptyList(),
) : Serializable
