package org.example.search.request

@com.fasterxml.jackson.annotation.JsonTypeInfo(
    use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME,
    include = com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY,
    property = "filterType"
)
@com.fasterxml.jackson.annotation.JsonSubTypes(
    com.fasterxml.jackson.annotation.JsonSubTypes.Type(
        value = NumberColumnFilter::class,
        name = "number"
    ), com.fasterxml.jackson.annotation.JsonSubTypes.Type(value = SetColumnFilter::class, name = "set")
)
abstract class ColumnFilter {
    open var filterType: String? = null
}