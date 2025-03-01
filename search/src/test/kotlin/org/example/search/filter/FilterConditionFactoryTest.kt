package org.example.search.filter

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.types.shouldBeInstanceOf
import org.example.search.request.filter.ColumnFilter
import org.example.search.request.filter.NumberColumnFilter
import org.example.search.request.filter.SetColumnFilter
import org.jooq.Condition
import org.jooq.Field

class FilterConditionFactoryTest :
    ShouldSpec({

        should("return NumberFilterCondition given NumberColumnFilter") {
            // Act & Assert
            FilterConditionFactory
                .getFilterCondition(NumberColumnFilter())
                .shouldBeInstanceOf<NumberFilterCondition>()
        }

        should("return SetFilterCondition given SetColumnFilter") {
            // Act & Assert
            FilterConditionFactory
                .getFilterCondition(SetColumnFilter())
                .shouldBeInstanceOf<SetFilterCondition>()
        }

        should("throw an exception given an unsupported ColumnFilter") {
            // Arrange
            val unsupportedFilter = object : ColumnFilter() {}

            // Act & Assert
            shouldThrow<IllegalArgumentException> {
                FilterConditionFactory.getFilterCondition(unsupportedFilter)
            }
        }

        should("register and return a custom FilterCondition") {
            // Arrange
            class CustomColumnFilter : ColumnFilter()

            class CustomFilterCondition(
                override val filter: ColumnFilter,
            ) : FilterCondition() {
                override fun getDslCondition(field: Field<Any>): Condition {
                    TODO("Not yet implemented")
                }
            }

            FilterConditionFactory.register(CustomColumnFilter::class.java) { CustomFilterCondition(it as CustomColumnFilter) }

            // Act & Assert
            FilterConditionFactory
                .getFilterCondition(CustomColumnFilter())
                .shouldBeInstanceOf<CustomFilterCondition>()
        }
    })
