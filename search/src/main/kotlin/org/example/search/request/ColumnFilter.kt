package org.example.search.request

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import org.example.search.enum.JoinOperator

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "filterType",
)
@JsonSubTypes(
    JsonSubTypes.Type(
        value = NumberColumnFilter::class,
        name = "number",
    ),
    JsonSubTypes
        .Type(
            value = SetColumnFilter::class,
            name = "set",
        ),
)
abstract class ColumnFilter {
    var filterType: String? = null
    var operator: JoinOperator? = null
    var conditions: List<ColumnFilter>? = null
}
